<%@ page contentType="text/html;charset=UTF-8"  language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--获取请求路径、引入全局css样式--%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html lang="zh-CN">
<head>
	<title>充电支付</title>
	<meta charset="utf-8">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="format-detection" content="telephone=no">
	<meta name="format-detection" content="email=no">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" type="text/css" href="css/pay/antui.min.css" media="all">
	<link rel="stylesheet" href="https://as.alipayobjects.com/g/component/swiper/3.2.7/swiper.min.css" />
</head>
<body>
<div class="widget-demo-show-panel">
<div class="am-message result">
<s:if test="#request.result == 'success'">
	<i class="am-icon result success"></i>
</s:if>
<s:elseif test="#request.result == 'fail'">
	<i class="am-icon result wait"></i>
</s:elseif>
<s:elseif test="#request.result == 'unknown'">
	<i class="am-icon result error"></i>
</s:elseif>
<s:elseif test="#request.result == 'waring'">
	<i class="am-icon result info"></i>
</s:elseif>
<div class="am-message-main">${message}</div>
<div class="am-message-sub">${subMessage}</div>
</div>
</div>
</body>
<script src="//cdn.bootcss.com/jquery/2.2.1/jquery.js" charset="UTF-8"></script>
<script type="text/javascript">
</script>
</html>