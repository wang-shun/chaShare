package com.holley.web.common.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

/**
 * 发送邮件
 * 
 * @author shencheng
 */
public class MailUtil {

    private static Logger      logger = Logger.getLogger(MailUtil.class);
    private String             host;                                     // 服务器地址"smtp.163.com"
    private String             from;                                     // 企业邮箱地址
    private String             to;                                       // 目的邮箱地址
    private String             subject;                                  // 邮件信息标题
    private String             body;                                     // 邮件内容
    private String             nickname;                                 // 企业邮箱昵称
    private EmailAutherticator auth;
    private static MailUtil    mailUtil;

    /*
     * public MailUtil(String host, String username, String password) { init(host, username, password); }
     */

    public static void init(String host, String username, String password, String nickname) {
        if (mailUtil == null) {
            mailUtil = new MailUtil();
            mailUtil.setAuth(new EmailAutherticator(username, password));
            mailUtil.setFrom(username);
            mailUtil.setHost(host);
            mailUtil.setNickname(nickname);
        }

    }

    public static MailUtil getInstance() {
        return mailUtil;
    }

    public void sendMail(String subject, String content, String to) throws Exception {
        this.setBody(content);// 邮箱内容
        this.setTo(to);// 目的邮箱地址
        Properties props = new Properties();
        props.put("mail.smtp.host", mailUtil.getHost());
        props.put("mail.smtp.auth", "true");
        System.out.println(props);
        Session session = Session.getDefaultInstance(props, mailUtil.getAuth());
        MimeMessage message = new MimeMessage(session);
        // message.setContent("Hello", "text/plain");
        logger.info(subject);
        message.setSubject(subject, "utf-8");// 设置邮件主题
        message.setSentDate(new Date());// 设置邮件发送时期
        Address address = new InternetAddress(from, mailUtil.getNickname(), "utf-8");
        message.setFrom(address);// 设置邮件发送者的地址
        Address toaddress = new InternetAddress(to);// 设置邮件接收者的地址
        message.addRecipient(Message.RecipientType.TO, toaddress);
        // 创建一个包含HTML内容的MimeBodyPart
        logger.info("body:" + mailUtil.getBody());
        Multipart mainPart = new MimeMultipart();
        BodyPart html = new MimeBodyPart();
        html.setContent(mailUtil.getBody(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 将MiniMultipart对象设置为邮件内容
        message.setContent(mainPart);
        // message.setText(str,"utf-8");
        message.saveChanges();
        logger.info("TO:" + to);
        Transport.send(message);
        System.out.println("Send Mail Ok!");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public EmailAutherticator getAuth() {
        return auth;
    }

    public void setAuth(EmailAutherticator auth) {
        this.auth = auth;
    }

    public static MailUtil getMailUtil() {
        return mailUtil;
    }

    public static void setMailUtil(MailUtil mailUtil) {
        MailUtil.mailUtil = mailUtil;
    }

    /*
     * public void readMailCodeMsg(){//邮件发送验证码内容 String msg = ""; WebApplicationContext wac =
     * ContextLoader.getCurrentWebApplicationContext(); MsgTemplateDao msgTemplateDao = (MsgTemplateDao)
     * wac.getBean("msgTemplateDao"); msg = msgTemplateDao.find(2).getContent(); setBody(msg); } public void
     * readActiveMailMsg(){//激活邮件模版内容 String msg = ""; WebApplicationContext wac =
     * ContextLoader.getCurrentWebApplicationContext(); MsgTemplateDao msgTemplateDao = (MsgTemplateDao)
     * wac.getBean("msgTemplateDao"); msg = msgTemplateDao.find(1).getContent(); setBody(msg); }
     */
    /*
     * public void readGetpwdMailMsg(){//获取密码邮件内容 String msg = ""; WebApplicationContext wac =
     * ContextLoader.getCurrentWebApplicationContext(); MsgTemplateDao msgTemplateDao = (MsgTemplateDao)
     * wac.getBean("msgTemplateDao"); msg = msgTemplateDao.find(3).getContent(); setBody(msg); } private void
     * readMsg(String filename){ StringBuffer sb=new StringBuffer(); InputStream
     * fis=Mail.class.getResourceAsStream(filename); InputStreamReader isr=null; try { isr=new
     * InputStreamReader(fis,"UTF-8"); } catch (UnsupportedEncodingException e1) { logger.error("读取文件遇见不正确的文件编码！"); }
     * BufferedReader br=new BufferedReader(isr); String line=""; try { while((line=br.readLine())!=null){
     * sb.append(line); } } catch (IOException e) { logger.error(e.getMessage()); } String msg=sb.toString();
     * logger.info(msg); setBody(msg); }
     */
    /*
     * public String getdecodeIdStr(User user){ String chars="0123456789qwertyuiopasdfghjklmnbvcxz-=~!@#$%^*+-._/*<>|";
     * int length=chars.length(); StringBuffer url=new StringBuffer(); StringBuffer rancode=new StringBuffer(); String
     * timeStr=System.currentTimeMillis()/1000+""; String userIDAddtime = user.getUserId() + "" +
     * DateUtils.getYYYYMMddHHmmss(user.getAddtime()); MD5 md5=new MD5(); userIDAddtime =
     * md5.getMD5ofStr(userIDAddtime); url.append(user.getUserId()) .append(",") .append(userIDAddtime) .append(",")
     * .append(user.getEmail()) .append(",") .append(timeStr) .append(","); for(int i=0;i<10;i++){ int
     * num=(int)(Math.random()*(length-2))+1; rancode.append(chars.charAt(num)); } url.append(rancode); String
     * idurl=url.toString(); BASE64Encoder encoder=new BASE64Encoder(); String s=encoder.encode(idurl.getBytes());
     * return s; } public void replace(String webname,String host,String username,String email,String url){ SystemInfo
     * info=Global.SYSTEMINFO; String fuwutel = info.getValue("fuwutel");//服务热线 String msg=this.getBody();
     * msg=msg.replace("$webname$", webname).replace("$email$", email).replace("$host$", host).replace("$username$",
     * username) .replace("$url$", host+url).replace("$fuwutel$", fuwutel); this.setBody(msg); } public void
     * replace(String username,String email,String url){ SystemInfo info=Global.SYSTEMINFO; String
     * weburl=info.getValue("weburl"); String webname=info.getValue("webname");
     * replace(webname,weburl,username,email,url); } public void replace(Map<String,String> map){ SystemInfo
     * info=Global.SYSTEMINFO; String weburl=info.getValue("weburl");//官网 String webname=info.getValue("webname");//网站名称
     * String fuwutel = info.getValue("fuwutel");//服务热线 String api_name = info.getValue("api_name");//接口名称 String
     * username = map.get("username")!=null?map.get("username"):"";//用户名 String no =
     * map.get("no")!=null?map.get("no"):"";//手机号或者身份证号 if(!StringUtils.isEmpty(no)){ no = no.substring(0,
     * no.length()-4)+ "****"; } String email = map.get("email")!=null?map.get("email"):"";//邮箱 String status =
     * map.get("status")!=null?map.get("status"):"";//认证状态 String type =
     * map.get("type")!=null?map.get("type"):"";//“手机”或者“身份证” String money =
     * map.get("money")!=null?map.get("money"):"";//提现、充值金额 String time =
     * map.get("time")!=null?map.get("time"):"";//提现充值时间 String m = map.get("msg")!=null?map.get("msg"):"";//提示信息 String
     * fee= map.get("fee")!=null?map.get("fee"):"0";//手续费 String borrowname =
     * map.get("borrowname")!=null?map.get("borrowname"):"";//标名 String account =
     * map.get("account")!=null?map.get("account"):"";//借款总额 String apr = map.get("apr")!=null?map.get("apr"):"";//年利率
     * String borrowUrl = map.get("borrowUrl")!=null?map.get("borrowUrl"):"";//标的地址 String timelimit =
     * map.get("timelimit")!=null?map.get("timelimit"):"";//借款期限 String order =
     * map.get("order")!=null?map.get("order"):"";//借款当前期 String monthapr =
     * map.get("monthapr")!=null?map.get("monthapr"):"";//月利率 //v1.8.0.3 TGPROJECT-12 lx 2014-04-02 start String
     * tenderAccount = map.get("tenderAccount")!=null?map.get("tenderAccount"):""; String tenderInterest =
     * map.get("tenderInterest")!=null?map.get("tenderInterest"):""; String tenderRepaymentYesAccount =
     * map.get("tenderRepaymentYesAccount")!=null?map.get("tenderRepaymentYesAccount"):""; //v1.8.0.3 TGPROJECT-30 lx
     * 2014-04-09 start String endTime = map.get("endTime") != null ? map .get("endTime") : ""; String valueDate =
     * map.get("valueDate") != null ? map .get("valueDate") : ""; String repaymentTime = map.get("repaymentTime") !=
     * null ? map .get("repaymentTime") : ""; String msg=this.getBody(); msg=msg.replace("$webname$",
     * webname).replace("$host$", weburl).replace("$username$", username) .replace("$NO$", no).replace("$status$",
     * status).replace("$type$", type) .replace("$money$", money).replace("$time$", time).replace("$msg$",
     * m).replace("$fee$", fee) .replace("$fuwutel$", fuwutel).replace("$borrowname$", borrowname).replace("$account$",
     * account) .replace("$apr$", apr).replace("$timelimit$", timelimit).replace("$order$", order)
     * .replace("$tenderAccount$", tenderAccount).replace("$tenderInterest$",
     * tenderInterest).replace("$tenderRepaymentYesAccount$", tenderRepaymentYesAccount) .replace("$endTime$",
     * endTime).replace("$valueDate$", valueDate).replace("$repaymentTime$", repaymentTime) .replace("$email$",
     * email).replace("$borrowUrl$", borrowUrl).replace("$monthapr$", monthapr).replace("$api_name$", api_name);
     * this.setBody(msg); if(map.get("subject")!=""&&map.get("subject")!=null){ this.subject = map.get("subject"); } }
     */

}
