package com.holley.charging.share.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.holley.charging.action.BaseAction;
import com.holley.charging.common.util.JobInitBase;
import com.holley.charging.common.util.ShareChargeCache;
import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.bus.BusPaymentExample;
import com.holley.charging.model.def.ChargingConfig;
import com.holley.charging.model.def.NotificationPayStatusInfoBase;
import com.holley.charging.model.def.NotifyPayStatusInfo;
import com.holley.charging.model.def.PayStatusBean;
import com.holley.charging.service.share.CommonService;
import com.holley.charging.share.util.AlipayConfig;
import com.holley.charging.share.util.ChaShareUtil;
import com.holley.charging.share.util.HttpXmlUtils;
import com.holley.charging.share.util.JdomParseXmlUtils;
import com.holley.charging.share.util.Unifiedorder;
import com.holley.charging.share.util.UnifiedorderResult;
import com.holley.charging.share.util.WechatConfig;
import com.holley.charging.share.util.WechatPayResult;
import com.holley.charging.share.util.WechatSignUtils;
import com.holley.common.constants.charge.ChargeDealStatusEnum;
import com.holley.common.constants.charge.ChargePayStatusEnum;
import com.holley.common.constants.charge.PayWayEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;
import com.holley.common.util.StringUtil;

public class PayAction extends BaseAction {

    private final static Logger logger = Logger.getLogger(PayAction.class);
    String                      wechatPayUrl;
    @Resource
    private CommonService       commonService;
    @Resource
    private JobInitBase         jobInitBase;
    private PayStatusBean       payStatusBean;

    /**
     * 支付宝异步返回
     * 
     * @return
     */
    public void alipayNotify() {
        PrintWriter writer = null;
        // 支付宝交易号
        // String trade_no = getRequest().getParameter("trade_no");
        // 商户订单号
        String localTradeNo = getParameter("out_trade_no");
        // 交易状态
        String trade_status = getParameter("trade_status");
        String buyer_pay_amount = getParameter("buyer_pay_amount");
        // BusPayment payment = returnPayment(localTradeNo);
        // 计算得出通知验证结果
        try {
            writer = getResponse().getWriter();
            // if (payment != null) {
            if (alipayResult()) {// 验证成功
                ChargePayStatusEnum payStatus;
                BigDecimal money = new BigDecimal(buyer_pay_amount).multiply(new BigDecimal("100"));// 元转分
                NotificationPayStatusInfoBase notificationPayStatusInfoBase = new NotificationPayStatusInfoBase();
                notificationPayStatusInfoBase.setFrom(ChargingConfig.getDomainOperatorId());
                notificationPayStatusInfoBase.setSeq(getEStartChargeSeq(localTradeNo));
                notificationPayStatusInfoBase.setT(System.currentTimeMillis() + "");
                notificationPayStatusInfoBase.setTotal_fee(money.intValue());
                if (trade_status.equals("WAIT_BUYER_PAY")) {// 表示等待付款
                    logger.info("---trade_status:WAIT_BUYER_PAY,不处理---" + DateUtil.DateToLongStr(new Date()));
                    writer.println(("success"));
                    if (writer != null) {
                        writer.flush();
                        writer.close();
                    }
                    return;
                } else if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
                    payStatus = ChargePayStatusEnum.SUCCESS;
                    notificationPayStatusInfoBase.setTrade_status("success");
                } else {// TRADE_CLOSED:在指定时间段内未支付时关闭的交易；在交易完成全额退款成功时关闭的交易。
                    payStatus = ChargePayStatusEnum.FAILURE;
                    notificationPayStatusInfoBase.setTrade_status("close");
                }
                commonService.updatePaymentstatus(localTradeNo, new BigDecimal(buyer_pay_amount), payStatus, PayWayEnum.ALIPAY);
                notificationPayStatusInfoBase.setSign(ChaShareUtil.createSign(ChaShareUtil.createParameters(NotificationPayStatusInfoBase.class, notificationPayStatusInfoBase)));
                NotifyPayStatusInfo notifyPayStatusInfo = new NotifyPayStatusInfo();
                notifyPayStatusInfo.setParams(ChaShareUtil.createKeyValue(ChaShareUtil.createParameters(NotificationPayStatusInfoBase.class, notificationPayStatusInfoBase)));
                notifyPayStatusInfo.setSeq(notificationPayStatusInfoBase.getSeq());
                notifyPayStatusInfo.setUpdateTime(System.currentTimeMillis());
                ShareChargeCache.addOrUpdateNotifyPayStatusInfo(notifyPayStatusInfo, ChargingConfig.getOperatorIdByTradeNo(localTradeNo));
                // String rs = QueryActionUtil.notificationPayStatus(notificationPayStatusInfoBase);
                // if (!"success".equals(rs)) {
                //
                // }
                writer.println("success");
            } else {// 验证失败
                logger.info("alipayNotify:" + "验证失败");
                writer.println("fail");
            }
            // } else {
            // logger.info("未知订单：" + out_trade_no);
            // // writer.println("success");
            // }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

    }

    /**
     * 支付宝同步返回
     * 
     * @return
     * @throws IOException
     * @throws AlipayApiException
     */
    public String alipayReturn() throws IOException {
        // 商户订单号
        String localTradeNo = getParameter("out_trade_no");
        String total_amount = getParameter("total_amount");
        // 支付宝交易号
        // String trade_no = getRequest().getParameter("trade_no");
        BusPayment payment = returnPayment(localTradeNo);

        if (payment != null) {
            if (alipayResult()) {// 验证成功
                logger.info("alipayReturn:" + "验证成功");
                // 请在这里加上商户的业务逻辑程序代码
                // 该页面可做页面美工编辑
                // ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                getRequest().setAttribute("result", "success");
                getRequest().setAttribute("message", "支付成功");
                getRequest().setAttribute("subMessage", total_amount + "元");
            } else {
                // 该页面可做页面美工编辑
                logger.info("alipayReturn:" + "验证失败");
                getRequest().setAttribute("result", "fail");
                getRequest().setAttribute("message", "等待");
                getRequest().setAttribute("subMessage", "已提交申请，请稍后查看");
            }
        } else {
            getRequest().setAttribute("result", "unknown");
            getRequest().setAttribute("message", "订单信息不存在");
            getRequest().setAttribute("subMessage", "未知订单");
        }

        return SUCCESS;
    }

    public String payInit() throws IOException {
        String[] keys = { "from", "seq", "sign", "sign_type", "t" };
        SortedMap<String, Object> param = checkSign(keys);
        if (param.get("checkSign") == null || !(boolean) param.get("checkSign")) {
            getRequest().setAttribute("result", "waring");
            getRequest().setAttribute("message", "签名有误");
            getRequest().setAttribute("subMessage", "验签失败");
            return MSG;
        }
        String out_trade_no = getDataStringForMap(param, "seq");
        String localTradeNo = getLocalStartChargeSeq(out_trade_no);
        BusPayment payment = returnPayment(localTradeNo);
        if (payment == null) {
            getRequest().setAttribute("result", "unknown");
            getRequest().setAttribute("message", "订单信息不存在");
            getRequest().setAttribute("subMessage", "未知订单");
            return MSG;
        } else if (ChargePayStatusEnum.SUCCESS.getShortValue().equals(payment.getPayStatus())) {
            getRequest().setAttribute("result", "waring");
            getRequest().setAttribute("message", "订单：" + out_trade_no + "，已支付");
            getRequest().setAttribute("subMessage", "已支付订单");
            return MSG;
        }
        getRequest().setAttribute("total_amount", NumberUtil.formateScale2Str(payment.getShouldMoney()));
        getRequest().setAttribute("out_trade_no", out_trade_no);
        return SUCCESS;
    }

    public String alipay() {
        String out_trade_no = getParameter("out_trade_no");
        String localTradeNo = getLocalStartChargeSeq(out_trade_no);
        BusPayment payment = returnPayment(localTradeNo);
        if (payment == null) {
            getRequest().setAttribute("result", "unknown");
            getRequest().setAttribute("message", "订单信息不存在");
            getRequest().setAttribute("subMessage", "未知订单");
            return MSG;
        } else if (ChargePayStatusEnum.SUCCESS.getShortValue().equals(payment.getPayStatus())) {
            getRequest().setAttribute("result", "waring");
            getRequest().setAttribute("message", "订单：" + out_trade_no + "，已支付");
            getRequest().setAttribute("subMessage", "已支付订单");
            return MSG;
        }
        try {
            // 调用SDK生成表单
            String form = wrapAlipayFormData(localTradeNo, NumberUtil.formateScale2Str(payment.getShouldMoney()));
            getResponse().setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            getResponse().getWriter().write(form);// 直接将完整的表单html输出到页面
            getResponse().getWriter().flush();
            getResponse().getWriter().close();
        } catch (Exception e) {
            logger.info("生成表单出错");
            e.printStackTrace();
        }
        return null;
    }

    public String wechatPay() throws Exception {

        // WebUser webUser = getWebuser();
        // String money = getParameter("rechargeMoney");
        // String rechargeWay = getParameter("rechargeWay");
        // String out_trade_no = getParameter("out_trade_no");
        // String msg = checkRecharge(rechargeWay, money);
        // BusRecharge record = new BusRecharge();
        // record.setAccountInfo(null);
        // record.setAddTime(new Date());
        // record.setFee(null);
        // record.setMoney(new BigDecimal(money));
        // record.setPayWay(Short.valueOf(rechargeWay));
        // record.setStatus(RechargeStatusEnum.RECHARGING.getShortValue());
        // record.setTradeNo(out_trade_no);
        // record.setUserId(webUser.getUserId());
        // if (rechargeService.insertRechargeSelective(record) > 0) {
        BigDecimal tempmoney = new BigDecimal("0.01").multiply(new BigDecimal("100")).setScale(0);
        SortedMap<String, Object> params = new TreeMap<String, Object>();
        params.put("appid", WechatConfig.appid);
        params.put("mch_id", WechatConfig.mch_id);
        params.put("nonce_str", StringUtil.randomString(16));
        params.put("time_start", DateUtil.DateToLong14Str(new Date()));
        params.put("trade_type", "MWEB");// H5支付
        params.put("spbill_create_ip", getRemoteIP());
        params.put("body", "充电支付");
        params.put("detail", "充电支付");
        params.put("out_trade_no", DateUtil.DateToLong14Str(new Date()) + StringUtil.zeroPadString(1 + "", 6));
        params.put("total_fee", tempmoney);
        // String noticeUrl = RoleUtil.selectRuleByPrimaryKey(RoleUtil.WEB_URL) + getRequest().getContextPath();
        params.put("notify_url", WechatConfig.notify_url);
        String sign = WechatSignUtils.createSign("UTF-8", params);
        Iterator<String> it = params.keySet().iterator();
        String key;
        Object value;
        Unifiedorder unifiedorder = new Unifiedorder();
        while (it.hasNext()) {
            key = it.next();
            value = params.get(key);
            try {
                BeanUtils.setProperty(unifiedorder, key, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        unifiedorder.setSign(sign);
        String weixinPos = HttpXmlUtils.httpsRequest(WechatConfig.unifiedorder_url, "POST", HttpXmlUtils.xmlInfo(unifiedorder)).toString();
        logger.info("xml============================" + weixinPos);
        UnifiedorderResult result = JdomParseXmlUtils.getUnifiedorderResult(weixinPos);
        if ("SUCCESS".equals(result.getReturn_code()) && "SUCCESS".equals(result.getResult_code()) && StringUtil.isNotEmpty(result.getMweb_url())) {
            wechatPayUrl = result.getMweb_url();
        }
        return SUCCESS;
        // MatrixToImageWriter.createCodeStream(result.getCode_url(), getResponse());
    }

    public String message() {
        String msg = getParameter("msg");
        getRequest().setAttribute("result", "waring");
        getRequest().setAttribute("message", msg);
        getRequest().setAttribute("subMessage", msg);
        return MSG;
    }

    public void wechatNotify() {
        logger.info("---[微信回调：充值支付]---start---" + DateUtil.DateToLongStr(new Date()));
        try {
            BufferedReader reader = getRequest().getReader();
            String line = "";
            StringBuffer inputString = new StringBuffer();
            try {
                PrintWriter writer = getResponse().getWriter();
                while ((line = reader.readLine()) != null) {
                    inputString.append(line);
                }
                if (reader != null) {
                    reader.close();
                }
                logger.info("----[微信回调：充值支付]接收到的报文---" + inputString.toString());
                if (!StringUtils.isEmpty(inputString.toString())) {
                    WechatPayResult wxPayResult = JdomParseXmlUtils.getWXPayResult(inputString.toString());
                    if ("SUCCESS".equalsIgnoreCase(wxPayResult.getReturn_code())) {
                        SortedMap<String, Object> parameters = WechatConfig.objectToTreeMap(wxPayResult);
                        // 反校验签名
                        String sign = WechatSignUtils.createSign("UTF-8", parameters);
                        if (WechatConfig.isNull(wxPayResult.getOut_trade_no(), wxPayResult.getTotal_fee(), sign)) {
                            logger.info("[FAIL]商户订单号为空或者总金额为空或者签名为空!");
                            writer.println(HttpXmlUtils.backWeixin("FAIL", "商户订单号为空或者总金额为空或者签名为空"));
                            writer.close();
                            return;
                        }
                        if (sign.equals(wxPayResult.getSign())) {
                            // 修改订单的状态
                            ChargePayStatusEnum payStatus;
                            if ("SUCCESS".equals(wxPayResult.getResult_code())) {// 表示交易成功
                                payStatus = ChargePayStatusEnum.SUCCESS;
                            } else {// 交易失败
                                payStatus = ChargePayStatusEnum.FAILURE;
                            }
                            BigDecimal operateMoney = new BigDecimal(wxPayResult.getTotal_fee());
                            operateMoney = operateMoney.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                            String accountInfo = getWechatAccountInfo(wxPayResult.getTransaction_id());

                            commonService.updatePaymentstatus(wxPayResult.getOut_trade_no(), operateMoney, payStatus, PayWayEnum.ALIPAY);
                            // rechargeService.updatePaystatusAndAccount(wxPayResult.getOut_trade_no(), operateMoney,
                            // accountInfo, payStatus);
                            writer.println(HttpXmlUtils.backWeixin("SUCCESS", "OK"));
                            logger.info("[SUCCESS]OK!");
                        } else {
                            writer.println(HttpXmlUtils.backWeixin("FAIL", "签名失败"));
                            logger.info("[FAIL]签名失败!sign1=" + sign + ",sign2=" + wxPayResult.getSign());
                        }
                    } else {
                        writer.println(HttpXmlUtils.backWeixin("FAIL", wxPayResult.getReturn_msg()));
                        logger.info("---------微信支付返回Fail----------" + wxPayResult.getReturn_msg());
                    }
                } else {
                    writer.println(HttpXmlUtils.backWeixin("FAIL", "未获取到微信返回的结果"));
                    logger.info("[FAIL]未获取到微信返回的结果!");
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 处理微信支付的账号信息
     * 
     * @param transactionid
     * @return
     */
    private String getWechatAccountInfo(String transactionid) {
        String accountInfo = "";
        if (!StringUtils.isEmpty(transactionid)) {
            accountInfo += "[微信支付订单号:" + transactionid + "]";
        }
        return accountInfo;
    }

    private String wrapAlipayFormData(String out_trade_no, String total_amount) throws AlipayApiException {
        // String out_trade_no = getParameter("out_trade_no");
        // 订单名称，必填
        String subject = "充电支付";
        // 付款金额，必填
        // String total_amount = getParameter("total_amount");
        // 商品描述，可空
        String body = "充电支付";
        // 超时时间 可空
        // String timeout_express = "2m";
        // 销售产品码 必填
        String product_code = "QUICK_WAP_PAY";
        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
        // 调用RSA签名方式
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                                                      AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setBody(body);
        // model.setTimeoutExpress(timeout_express);
        model.setProductCode(product_code);
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(AlipayConfig.notify_url);
        // 设置同步地址
        alipay_request.setReturnUrl(AlipayConfig.return_url);
        // form表单生产
        String form = client.pageExecute(alipay_request).getBody();
        return form;
    }

    private BusPayment returnPayment(String out_trade_no) {
        String tradeNo = out_trade_no != null ? out_trade_no : "";
        BusPaymentExample emp = new BusPaymentExample();
        BusPaymentExample.Criteria cr = emp.createCriteria();
        cr.andTradeNoEqualTo(tradeNo);
        List<BusPayment> list = commonService.queryPaymentByExample(emp);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 解析支付返回结果
     * 
     * @return
     */
    private boolean alipayResult() {
        boolean rs = false;
        try {
            Map<String, String> params = new HashMap<String, String>();
            Map requestParams = getRequest().getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
                params.put(name, valueStr);
            }
            if (params.containsKey("sign")) {
                String sign = params.get("sign");
                if (sign.contains(" ")) {
                    sign = sign.replace(" ", "+");
                    params.put("sign", sign);
                }
            }
            rs = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public String queryPayStatus() {
        // JSONObject jsonobj = readerData();
        // String tradeNo = getDataString(jsonobj, "seq");
        String[] keys = { "from", "seq", "sign", "sign_type", "t" };
        SortedMap<String, Object> param = checkSign(keys);
        String form = getDataStringForMap(param, "from");
        String seq = getDataStringForMap(param, "seq");
        String t = getDataStringForMap(param, "t");
        PayStatusBean payStatusBean = new PayStatusBean(form, seq, t);
        if (param.get("checkSign") == null || !(boolean) param.get("checkSign")) {
            payStatusBean.setResult_code("fail");
            payStatusBean.setResult_msg("sign_error");
            payStatusBean.setSign(ChaShareUtil.createSign(ChaShareUtil.createParameters(PayStatusBean.class, payStatusBean)));
            this.payStatusBean = payStatusBean;
            return SUCCESS;
        }
        BusPaymentExample paymentEmp = new BusPaymentExample();
        BusPaymentExample.Criteria paymentCr = paymentEmp.createCriteria();
        paymentCr.andTradeNoEqualTo(getLocalStartChargeSeq(payStatusBean.getSeq()));
        List<BusPayment> list = commonService.queryPaymentByExample(paymentEmp);
        if (list == null || list.size() <= 0) {
            payStatusBean.setResult_code("fail");
            payStatusBean.setResult_msg("unknown_seq");// 未知订单
            payStatusBean.setSign(ChaShareUtil.createSign(ChaShareUtil.createParameters(PayStatusBean.class, payStatusBean)));
            this.payStatusBean = payStatusBean;
            return SUCCESS;
        }
        BusPayment payment = list.get(0);
        Integer total_fee = payment.getShouldMoney() != null ? payment.getShouldMoney().multiply(new BigDecimal("100")).intValue() : null;// 元转分
        payStatusBean.setTotal_fee(total_fee);
        if (ChargePayStatusEnum.SUCCESS.getShortValue().equals(payment.getPayStatus())) {
            payStatusBean.setResult_code("success");
            payStatusBean.setResult_msg("ok");
            payStatusBean.setTrade_status("success");
        } else if (!ChargeDealStatusEnum.SUCCESS.getShortValue().equals(payment.getDealStatus())) {
            payStatusBean.setResult_code("fail");
            payStatusBean.setResult_msg("dealing");// 交易未完成
            payStatusBean.setTrade_status("fail");
        } else {
            payStatusBean.setResult_code("fail");
            payStatusBean.setResult_msg("unpaid");// 未支付
            payStatusBean.setTrade_status("unpaid");
        }
        payStatusBean.setSign(ChaShareUtil.createSign(ChaShareUtil.createParameters(PayStatusBean.class, payStatusBean)));
        this.payStatusBean = payStatusBean;
        return SUCCESS;
    }

    /**
     * 申请开发票
     * 
     * @return
     */
    public String queryPublish() {
        String[] keys = { "from", "name", "seq", "company", "telephone", "address", "taxId", "totalFee", "applyTime", "sign", "signType", "t" };

        return SUCCESS;
    }

    /**
     * 验签
     * 
     * @param keys
     * @return
     */
    private SortedMap<String, Object> checkSign(String[] keys) {
        SortedMap<String, Object> params = new TreeMap<String, Object>();
        for (String key : keys) {
            params.put(key, getParameter(key));
        }
        String sign = ChaShareUtil.createSign(params);
        logger.info("PARAM:" + params);
        logger.info("LOCAL_SIGN:" + sign);
        logger.info("RETURN_SIGN:" + params.get("sign"));
        params.put("checkSign", sign.equals(params.get("sign")));
        return params;
    }

    public String getWechatPayUrl() {
        return wechatPayUrl;
    }

    public PayStatusBean getPayStatusBean() {
        return payStatusBean;
    }

}
