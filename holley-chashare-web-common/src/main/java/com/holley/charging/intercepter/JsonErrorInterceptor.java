package com.holley.charging.intercepter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.holley.charging.common.util.LocalCacheUtil;
import com.holley.common.cache.RedisUtil;
import com.holley.common.constants.Globals;
import com.holley.common.constants.ResultBean;
import com.holley.common.constants.share.RetTypeEnum;
import com.holley.common.security.HMacMD5;
import com.holley.common.security.SecurityUtil;
import com.holley.common.util.StringUtil;
import com.holley.platform.model.sys.SysSecretKey;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * JSON调用异常拦截
 * 
 * @author zhouli
 */
public class JsonErrorInterceptor extends BaseInterceptor {

    private static final Logger log              = Logger.getLogger(JsonErrorInterceptor.class);
    private static final long   serialVersionUID = 1L;
    @Resource
    private LocalCacheUtil      localCacheUtil;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            String path = getServletPath().replaceFirst("/", "");
            log.info("拦截器调用到了。。。" + path);
            if ("v1/notification_stationStatus".equals(path)) {
                return invocation.invoke();
            }
            log.info("读取到token。。。" + getRequest().getHeader("Authorization"));

            ValueStack st = invocation.getStack();
            ResultBean bean = (ResultBean) st.findValue("resultBean");
            JSONObject da = readerLine();
            log.info("读取到数据。。。" + da);
            String operatorID = getDataString(da, "OperatorID");
            SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorID);
            if (StringUtil.isEmpty(operatorID) || sk == null) {
                bean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
                return "errorjson";
            }

            if (!checkSig(da, sk)) {
                bean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
                return "errorjson";
            }
            Globals.threadLocal.set(da.toString());
            // SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorID);
            // JSONObject deda = getDecodeData(da.getString("Data"), sk);
            // if (sk == null) {
            // bean.setRet(RetTypeEnum.KEY_PARAM_ERROR.getValue());
            // return "errorjson";
            // }

            if (!"v1/query_token".equals(path)) {
                // String noToken = da.getString("TimeStamp");
                // if ("123".equals(noToken)) {
                // return invocation.invoke();
                // }
                if (cheackOperatorKey(da, invocation)) {
                    return invocation.invoke();
                } else {
                    return "errorjson";
                }
            }
        } catch (Exception e) {
            log.info("非法调用");
            ValueStack st = invocation.getStack();
            ResultBean bean = (ResultBean) st.findValue("resultBean");
            if (bean != null) {
                bean.setRet(RetTypeEnum.SYS_ERROR.getValue());
            }
            e.printStackTrace();
            return "errorjson";
        }
        return invocation.invoke();
    }

    private boolean checkSig(JSONObject da, SysSecretKey sk) {
        String operatorID = getDataString(da, "OperatorID");
        String sig = getDataString(da, "Sig");
        String key = sk.getSigsecret();
        String data = getDataString(da, "Data");
        String tempdate = getDataString(da, "TimeStamp");
        String seq = getDataString(da, "Seq");
        String str = operatorID + data + tempdate + seq;
        String lsig = HMacMD5.getHmacMd5Str(key, str);
        System.out.println("okSig：" + lsig);
        System.out.println(" querySig：" + sig);
        return lsig.equals(sig);
    }

    private boolean cheackOperatorKey(JSONObject da, ActionInvocation invocation) throws Exception {
        try {
            String operatorID = getDataString(da, "OperatorID");
            // String requestToken = da.getString("Token");
            String requestToken = getRequest().getHeader("Authorization");
            String[] tokens = requestToken.split(" ");
            requestToken = tokens[1];

            ValueStack st = invocation.getStack();
            ResultBean bean = (ResultBean) st.findValue("resultBean");
            System.out.println("传送的token：----" + requestToken);
            String localToken = RedisUtil.getString(Globals.KEY_TOKEN + operatorID);
            System.out.println("存储的token：----" + localToken);
            if (StringUtil.isNull(requestToken, localToken) || !requestToken.equals(localToken)) {
                bean.setRet(RetTypeEnum.TOKEN_ERROR.getValue());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private JSONObject readerLine() {
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputReader = null;
        BufferedReader bufferReader = null;
        try {
            inputReader = new InputStreamReader(getRequest().getInputStream(), "UTF-8");
            bufferReader = new BufferedReader(inputReader);
            String line = null;
            while ((line = bufferReader.readLine()) != null) {
                sb.append(line);
            }
            String temp = sb.toString();
            if (temp.startsWith("Data:")) {
                temp.substring("Data:".length(), temp.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputReader != null) {
                try {
                    inputReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return JSONObject.fromObject(sb.toString());
    }

    private JSONObject getDecodeData(String enData, SysSecretKey sk) throws Exception {
        String str = SecurityUtil.aesDecrypt(enData, sk.getDatasecret(), sk.getDatasecretiv());
        return JSONObject.fromObject(str);
    }

    public static void main(String[] args) {
        String s = "Data:{\"TimeStamp\": \"20170609161236\", \"Sig\": \"1E2D37ED6C7852D0100435C80AF927DC\", \"Data\": \"UlGbRcobX2QmU5mmo7Kt75dxDLOgA6orC0ucOsSNHWPdeS0S5SZjo7QL3YHzEWD+eZIttVSBhY3fp+2lR1VgISHVx6fsaimMJESANAu63dA=\", \"OperatorID\": \"348375727\", \"Seq\": 3}";
        // JSONObject o = JSONObject.fromObject(s);
        if (s.startsWith("Data:")) {
            s = s.substring("Data:".length(), s.length());
        }
        System.out.println(s);
    }
}
