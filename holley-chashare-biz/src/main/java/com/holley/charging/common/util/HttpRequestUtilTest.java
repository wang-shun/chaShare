package com.holley.charging.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.holley.charging.model.def.ChargingConfig;
import com.holley.common.cache.RedisUtil;
import com.holley.common.constants.Globals;
import com.holley.common.constants.QueryBean;
import com.holley.common.constants.share.SuccStatTypeEnum;
import com.holley.common.security.HMacMD5;
import com.holley.common.security.SecurityUtil;
import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;

public class HttpRequestUtilTest {

    private final static Logger logger       = Logger.getLogger(HttpRequestUtilTest.class);
    private final static String baseurl      = "http://api.map.baidu.com/geoconv/v1/?ak=Gf39Vxv6N9I9pfdb8tyg6GIA&output=json&coords=";
    private final static String ecbaseurl    = "http://localhost:8088/evcs/v1/";
    private final static String payecbaseurl = "http://localhost:8088/evcs/pay/";

    // private static String ecbaseurl = "http://123.56.113.123:9020/evcs/20160701/";

    // static {
    // InputStream inStream = HttpRequestUtil.class.getClassLoader().getResourceAsStream("openActive.properties");
    // Properties prop = new Properties();
    // try {
    // prop.load(inStream);
    // ecbaseurl = prop.getProperty("openUrl");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    //
    // }

    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static JSONArray sendGet(String param) {
        String result = "";
        BufferedReader in = null;
        JSONArray array = null;
        try {
            String urlNameString = baseurl + param;

            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            connection.setConnectTimeout(10000);
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            // Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // for (String key : map.keySet()) {
            // System.out.println(key + "--->" + map.get(key));
            // }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject resultJsonObj = JSONObject.fromObject(result);
            if (resultJsonObj.getInt("status") == 0) {
                String resultListJsonObj = resultJsonObj.get("result").toString();
                array = JSONArray.fromObject(resultListJsonObj);

            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return array;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String queryToken(String oId, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret) throws Exception {
        String localtoken = RedisUtil.getString(Globals.KEY_PUSH_TOKEN + oId);
        if (StringUtil.isNotEmpty(localtoken)) {
            return localtoken;
        }

        QueryBean qb = new QueryBean(new Date());
        qb.setOperatorID(ChargingConfig.getDomainOperatorId());

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("OperatorID", ChargingConfig.getDomainOperatorId());
        param.put("OperatorSecret", operatorSecret);
        JSONObject jsonObj = httpTest("query_token", param, qb, null, operatorSecret, dataSecret, dataSecretIV, sigSecret);
        String enData = jsonObj.getString("Data");
        String deData = SecurityUtil.aesDecrypt(enData, dataSecret, dataSecretIV);
        if (StringUtil.isNotEmpty(deData)) {
            JSONObject obj = JSONObject.fromObject(deData);
            int succStat = obj.getInt("SuccStat");
            if (SuccStatTypeEnum.SUCCESS.getValue() == succStat) {
                String token = obj.getString("AccessToken");
                int timelong = obj.getInt("TokenAvailableTime");
                RedisUtil.setString(Globals.KEY_PUSH_TOKEN + oId, token, timelong);
                return token;
            }

        }
        return null;
    }

    public static String httpUrlConnection(String baseurl, String requestString) {
        try {
            // 建立连接
            URL url = new URL(baseurl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            // //设置连接属性
            httpConn.setDoOutput(true);// 使用 URL 连接进行输出
            httpConn.setDoInput(true);// 使用 URL 连接进行输入
            httpConn.setUseCaches(false);// 忽略缓存
            httpConn.setRequestMethod("POST");// 设置URL请求方法
            httpConn.setConnectTimeout(3000);
            httpConn.setReadTimeout(3000);
            // String requestString =
            // "{OperatorID:348375727,OperatorSecret:123,Sig:1F28FB25653BF36B6485DB0BDF38839B,Data:NEODLvcvWaUNSt6tjAYp/6Uu2b0ALLMNCvrINsCpwm2pdpQ3cMjp8Q9krGXvFHDGHTfo1t8nss4vQ/MJLHRdJA==,TimeStamp:123,Seq:0001}";

            // 设置请求属性
            // 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
            byte[] requestStringBytes = requestString.getBytes("UTF-8");
            httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);
            httpConn.setRequestProperty("Content-Type", "application/octet-stream");
            httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            httpConn.setRequestProperty("Charset", "UTF-8");

            // 建立输出流，并写入数据
            OutputStream outputStream = httpConn.getOutputStream();
            outputStream.write(requestStringBytes);
            outputStream.close();
            // 获得响应状态
            int responseCode = httpConn.getResponseCode();
            StringBuffer sb = new StringBuffer();
            if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
                // 当正确响应时处理数据
                String readLine;
                BufferedReader responseReader;
                // 处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();
            }
            // logger.info(sb.toString());
            System.out.println(sb.toString());
            return sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static JSONObject httpUrlConnection(String baseurl, String requestString, String token) {
        try {
            // 建立连接
            URL url = new URL(baseurl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            // //设置连接属性
            httpConn.setDoOutput(true);// 使用 URL 连接进行输出
            httpConn.setDoInput(true);// 使用 URL 连接进行输入
            httpConn.setUseCaches(false);// 忽略缓存
            httpConn.setRequestMethod("POST");// 设置URL请求方法
            httpConn.setConnectTimeout(3000);
            httpConn.setReadTimeout(3000);
            // String requestString =
            // "{OperatorID:348375727,OperatorSecret:123,Sig:1F28FB25653BF36B6485DB0BDF38839B,Data:NEODLvcvWaUNSt6tjAYp/6Uu2b0ALLMNCvrINsCpwm2pdpQ3cMjp8Q9krGXvFHDGHTfo1t8nss4vQ/MJLHRdJA==,TimeStamp:123,Seq:0001}";

            // 设置请求属性
            // 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
            byte[] requestStringBytes = requestString.getBytes("UTF-8");
            httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);
            httpConn.setRequestProperty("Content-Type", "application/octet-stream");
            httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            httpConn.setRequestProperty("Charset", "UTF-8");
            //
            if (StringUtil.isNotEmpty(token)) {
                httpConn.setRequestProperty("Authorization", "Bearer " + token);
            }

            // 建立输出流，并写入数据
            OutputStream outputStream = httpConn.getOutputStream();
            outputStream.write(requestStringBytes);
            outputStream.close();
            // 获得响应状态
            int responseCode = httpConn.getResponseCode();
            StringBuffer sb = new StringBuffer();
            if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
                // 当正确响应时处理数据
                String readLine;
                BufferedReader responseReader;
                // 处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();
            }
            logger.info(sb.toString());
            return JSONObject.fromObject(sb.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    // public static JSONObject httpTest(String actionUrl, Map<String, Object> param, Map<String, Object> data, String
    // token) throws Exception {
    //
    // String enstr = SecurityUtil.aesEncrypt(JSON.toJSONString(param, SerializerFeature.WriteMapNullValue),
    // "wRhI9mOq0H49cZ2Q", "i9SyMklPlsuUmcal");
    // data.put("Data", enstr);
    //
    // String oid = data.get("OperatorID").toString();
    // String Data = data.get("Data").toString();
    // String TimeStamp = data.get("TimeStamp").toString();
    // String Seq = data.get("Seq").toString();
    // String Sig = oid + Data + TimeStamp + Seq;
    // Sig = HMacMD5.getHmacMd5Str("OpzDCdyuzr0hwxdK", Sig);
    // data.put("Sig", Sig);
    // return httpUrlConnection(ecbaseurl + actionUrl, JSONObject.fromObject(data).toString(), token);
    //
    // }

    public static JSONObject httpTest(String actionUrl, Object param, QueryBean queryBean, String token, String operatorSecret, String dataSecret, String dataSecretIV,
                                      String sigSecret) throws Exception {

        String enstr = SecurityUtil.aesEncrypt(JSON.toJSONString(param, SerializerFeature.WriteMapNullValue), dataSecret, dataSecretIV);
        queryBean.setData(enstr);
        String OperatorID = queryBean.getOperatorID();
        String Data = queryBean.getData().toString();
        String TimeStamp = queryBean.getTimeStamp();
        String Seq = queryBean.getSeq();
        String Sig = OperatorID + Data + TimeStamp + Seq;
        Sig = HMacMD5.getHmacMd5Str(sigSecret, Sig);
        queryBean.setSig(Sig);
        return httpUrlConnection(ecbaseurl + actionUrl, JSON.toJSONString(queryBean, SerializerFeature.WriteMapNullValue), token);

    }

    // TEST
    /**
     * 测试获取token
     * 
     * @throws Exception
     */
    public static void testQueryToken(String operatorID, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret) throws Exception {
        // token 请求
        QueryBean qb = new QueryBean();
        qb.setOperatorID(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("OperatorID", "348375727");
        param.put("OperatorSecret", "qu31xLHf8PoZ9xro");
        httpTest("query_token", param, qb, null, operatorSecret, dataSecret, dataSecretIV, sigSecret);
    }

    /**
     * 测试获取设备信息
     * 
     * @param token
     * @throws Exception
     */
    public static void testQueryStationInfo(String operatorID, String token, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorID(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("PageSize", "10");
        param.put("LastQueryTime", "2017-01-01 00:00:00");

        httpTest("query_stations_info", param, qb, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);

    }

    /**
     * 测试获取设备状态
     * 
     * @param token
     * @throws Exception
     */
    public static void testQueryStationStatus(String operatorID, String token, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorID(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        String[] st = { "XY20170100000001" };
        param.put("StationIDs", st);
        httpTest("query_station_status", param, qb, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);
    }

    /**
     * 测试统计新
     * 
     * @param token
     * @throws Exception
     */
    public static void testQueryStationStats(String operatorID, String token, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret) throws Exception {
        QueryBean qb = new QueryBean();
        qb.setOperatorID(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(new Date()));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("StationID", 1);
        param.put("StartTime", "2016-12-16");
        param.put("EndTime", "2016-12-17");

        // stationID = 1;
        // startTime = "2016-12-16";
        // endTime = "2016-12-17";
        httpTest("query_station_stats", param, qb, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);
    }

    /**
     * 测试设备认证
     * 
     * @param token
     * @throws Exception
     */
    public static void testQueryEquipAuth(String operatorID, String token, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret) throws Exception {
        Date now = new Date();
        QueryBean qb = new QueryBean();
        qb.setOperatorID(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(now));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ConnectorID", "201705240000000101");
        param.put("EquipAuthSeq", "348375727" + DateUtil.DateToLong14Str(now) + StringUtil.randomNumber(4));
        httpTest("query_equip_auth", param, qb, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);
    }

    /**
     * 请求启动充电
     * 
     * @param operatorID
     * @param token
     * @throws Exception
     */
    public static void testQueryStartCharge(String operatorID, String token, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret) throws Exception {
        Date now = new Date();
        QueryBean qb = new QueryBean();
        qb.setOperatorID(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(now));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ConnectorID", "201712181111111002");
        param.put("StartChargeSeq", "348375727" + DateUtil.DateToLong14Str(now) + StringUtil.randomNumber(4));
        param.put("QRCode", "201712181111111002");
        httpTest("query_start_charge", param, qb, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);
    }

    /**
     * 请求启动充电
     * 
     * @param operatorID
     * @param token
     * @throws Exception
     */
    public static void testQueryStopCharge(String operatorID, String token, String operatorSecret, String dataSecret, String dataSecretIV, String sigSecret, String tradeNo)
                                                                                                                                                                            throws Exception {
        Date now = new Date();
        QueryBean qb = new QueryBean();
        qb.setOperatorID(operatorID);
        qb.setTimeStamp(DateUtil.DateToLong14Str(now));
        qb.setSeq("0001");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ConnectorID", "201712141111111001");
        param.put("StartChargeSeq", tradeNo);
        param.put("QRCode", "201712181111111002");
        httpTest("query_stop_charge", param, qb, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);
    }

    public static JSONObject httpTest(String actionUrl, Object obj) {
        return httpUrlConnection(payecbaseurl + actionUrl, JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue), null);
    }

    public static String httpTestPay(String actionUrl, Object obj) {
        return httpUrlConnection(payecbaseurl + actionUrl, JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue));
    }

    /**
     * 发送HttpPost请求
     * 
     * @param strURL 服务地址
     * @param params json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
     * @return 成功:返回json字符串<br/>
     */
    public static String postJson(String strURL, String params) {
        try {
            // 创建连接
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            // 设置请求方式
            connection.setRequestMethod("POST");
            // 设置接收数据的格式
            connection.setRequestProperty("Accept", "application/json");
            // 设置发送数据的格式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // utf-8编码
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.append(params);
            // 关闭流
            out.flush();
            out.close();
            // 读取响应 ，获取长度
            int length = (int) connection.getContentLength();
            InputStream is = connection.getInputStream();
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                // utf-8编码
                String result = new String(data, "UTF-8");
                // 返回
                return result;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 自定义错误信息
        return "error";
    }

    public static void main(String[] args) {
        String token = "bdd63c18f383447b975f4959d34ef8ec";
        String operatorID = "348375727";
        String operatorSecret = "qu31xLHf8PoZ9xro";
        String dataSecret = "wRhI9mOq0H49cZ2Q";
        String dataSecretIV = "i9SyMklPlsuUmcal";
        String sigSecret = "OpzDCdyuzr0hwxdK";
        try {
            // System.out.println("41131804182000000000000000000039".length());
            // testQueryStationInfo(operatorID, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);
            // System.out.println(sendPost("http://123.56.160.244:8082/h5pay/setbillstatus",
            // "from=330414214&seq=348375727000000000000126612"));
            // System.out.println("01377786283900000000".substring(1, 12));
            testQueryToken(operatorID, operatorSecret, dataSecret, dataSecretIV, sigSecret);
            // Map<String, Object> m = new HashMap<String, Object>();
            // httpTestPay("alipayReturn", null);
            // testQueryStopCharge(operatorID, token, operatorSecret, dataSecret, dataSecretIV, sigSecret,
            // "348375727000000000000127772");
            // testQueryStartCharge(operatorID, token, operatorSecret, dataSecret, dataSecretIV, sigSecret);
            // System.out.println("00000348375727201712181404543611".length());
            // System.out.println("0157571153240000000000000000000000000000000000000000".length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
