<%@ page contentType="text/html;charset=UTF-8"  language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--获取请求路径、引入全局css样式--%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<!-- A11Y：注意设置页面的 lang 属性 -->
<html lang="zh">
<head>
  <meta charset="utf-8" />
  <!-- A11Y：打开页面时，屏幕阅读器会首先阅读 title 的内容，确保 title 准确描述页面 -->
  <title>充电支付</title>
  <meta name="description" content="" />
  <meta name="keywords" content="" />
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
  <meta name="format-detection" content="telephone=no, email=no" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
  <!-- A11Y：如果有无障碍方面的需求，建议使用下面的 viewport 设置，不要禁止页面缩放 -->
  <!--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />-->
  <script>
    var docEl = document.documentElement;
    docEl.style.fontSize = 100 / 375 * docEl.clientWidth  + 'px';
    window.addEventListener('resize', function() {
      docEl.style.fontSize = 100 / 375 * docEl.clientWidth + 'px';
    });
  </script>
  <link rel="stylesheet" href="https://gw.alipayobjects.com/as/g/antui/antui/10.1.10/dpl/antui.css"/>
  	<link rel="stylesheet" type="text/css" href="plugin/layer/skin/default/layer.css">
  </head>
<body>
<form action="pay/alipay" method="post" id="form">
 <input type="hidden" name="out_trade_no" value="${out_trade_no}"/>
<div class="am-list twoline">
  <div class="am-list-header" id="demo-radio-header-2">付款方式</div>
  <div class="am-list-body" id="demo-radio-header-2">
    <label class="am-list-item radio" id="zhifubao">
      <div class="am-list-thumb">
        <img
          src="img/zhifubao.jpg"
          alt="图片描述"
          style="width: 30"
        />
      </div>
      <div class="am-list-content">
        <div class="am-list-title">支付宝</div>
       <!--  <div class="am-list-brief">辅助标签</div> -->
      </div>
      <div class="am-checkbox middle">
        <input type="radio" name="x22" checked="checked">
        <span class="icon-check" aria-hidden="true"></span>
      </div>
    </label>
<%--     <label class="am-list-item radio" id="weixin">
      <div class="am-list-thumb">
        <img
          src="img/weixin.jpg"
          alt="图片描述"
          style="width: 30"
        />
      </div>
      <div class="am-list-content">
        <div class="am-list-title">微信</div>
       <!--  <div class="am-list-brief">辅助标签</div> -->
      </div>
      <div class="am-checkbox middle">
        <input type="radio" name="x22">
        <span class="icon-check" aria-hidden="true"></span>
      </div>
    </label> --%>
  </div>
</div>

<div class="am-list am-list-form">
  <div class="am-list-item">
    <div class="am-list-label" id="list-label-25">支付金额</div>
    <div class="am-list-control">
    </div>
    <div>
   ${total_amount}元
    </div>
  </div>
</div>
<button id="okBtn" type="button" class="am-button">确定</button>
</form>
<script src="//cdn.bootcss.com/jquery/2.2.1/jquery.js" charset="UTF-8"></script>
<script src="plugin/layer/layer.js"></script>
<script type="text/javascript">
var payWay=1;
$(function(){
	$("#zhifubao").on("click",function(){
		payWay=1;
	});
	$("#weixin").on("click",function(){
		payWay=2;
	});
	$("#okBtn").on("click",function(){
		if(payWay == 2){
			$.post("pay/pay_wechatPay",{},function(data){
				var url = data.wechatPayUrl; 
				if(!isEmpty(url)){
					href(url);
				}else{
					layer.msg("暂不支持微信支付")
				}
			});
		}else{
			$("#form").submit();
		}
	});
	
})

function href(url) {
	window.location.href=url;
}
function isEmpty(str){
	if(!str){
		return true;
	}else if(str == undefined){
		return true;
	}else if($.trim(str).length <= 0){
		return true;
	}
	return false;
}
</script>
</body>
</html>
