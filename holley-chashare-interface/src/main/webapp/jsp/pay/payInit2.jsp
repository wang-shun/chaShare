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
	<title>AntUI</title>
	<meta charset="utf-8">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="format-detection" content="telephone=no">
	<meta name="format-detection" content="email=no">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" type="text/css" href="plugin/layer/skin/default/layer.css">
	<link rel="stylesheet" type="text/css" href="https://as.alipayobjects.com:443/g/snake/h5cashier/1.0.5/h5cashier.css" media="all">
	<link rel="stylesheet" type="text/css" href="css/pay/mycss/reset.css">
	<!--  <link rel="stylesheet" type="text/css" href="css/pay/mycss/balance.css"> -->
</head>
<body>
<style>
    .am-content h5.am-ft-center {
        margin-top: 0;
        margin-bottom: 20px;
    }
    .am-list div.am-list-item .am-list-item-title {
        margin-top: 4px;
        font-size: 12px;
        font-weight: 300;
    }
    .am-list .am-list-item .am-list-item-text {
        font-size: 14px;
    }
    #cashierPreConfirm .am-list div.am-list-item {
        padding: 14px 14px;
    }
    .am-list .am-list-item {
        padding: 14px 30px 14px 15px;
    }
    .am-ft-clear {
        clear: both;
    }
    .am-list .am-list-item .am-list-item-title {
        font-size: 12px;
        margin-top: 2px;
    }
    .am-list div.am-list-item .am-list-item-title.am-ft-xl {
        font-size: 16px;
    }
    .am-list .am-list-item .am-list-item-text.am-ft-xxl {
        font-size: 20px;
        color: #000;
    }
    .am-list .am-list-item a.am-list-item-text {
        margin: 10px 0;
        color: #0AF;
        font-size: 14px;
    }
    .am-list div.need-pay {
        padding: 5px 15px;
    }

    .protocol-content {
        opacity: 0;
        position: fixed;
        top: 0;
        left: 0;
        z-index: 888;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.3);
    }
    .protocol-button {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        position: absolute;
        left: 0;
        bottom: 0;
        width: 100%;
        padding: 10px;
    }
    .protocol-button-alipay {
        margin-bottom: 10px;
    }
    .protocol-button-bank {
        margin-bottom: 20px;
    }
    .protocol-button .am-button-white {
        color: #00aaff;
    }

    .need-pay .am-list-item-title {
        margin-top: 14px;
    }
	.J-cashierPreConfirm,
    .J-pwdValidate {
        display: none;
    }
    
    .pay-logo {
    position: absolute;
    bottom: 15px;
    left: 53%;
    display: block;
    width: 48px;
    height: 48px;
    margin: 10px auto auto -35px;
    background-image: url(img/user_head.png);
    background-size: cover;
}

</style>
 <div class="J-cashierPreConfirm" style="display: block;">
    <form action="pay/alipay" method="post" id="form">
        <div class="am-list am-list-flat-chip">
			<div class="am-list-item">
                    <span id="test" class="am-list-item-title am-ft-ellipsis am-ft-gray">订单编号</span>
                    <span class="am-list-item-text am-ft-ellipsis am-ft-gray">${out_trade_no}</span>
                    <input type="hidden" name="out_trade_no" value="${out_trade_no}"/>
            </div>
            <div class="am-list-item">
                    <span class="am-list-item-title am-ft-ellipsis am-ft-gray">付款方式</span>
                    <span class="am-list-item-text am-ft-ellipsis am-ft-gray"><i class="iconfont" style="color: #1DABEA;">&#xe600;</i>支付宝</span>
            </div> 
            
   <!--          <div class="am-list-item content">
            <div>
				<p>付款方式</p>
				<ul id="payList">
					<li class="show">
						<i class="iconfont weixin">&#xe501;</i>
						<a href="javascript:;" data-switch="1">微信支付</a>
						<div class="icon">
							<img src="img/check.png">
							</div>
					</li>
					<li>
						<i class="iconfont zhifubao">&#xe600;</i>
						<a href="javascript:;" data-switch="2">支付宝</a>
						<div class="icon">
							<img src="img/check.png">
						</div>
					</li>
				</ul>
				</div>
			</div> -->
			
            <div class="am-list-item">
                                
                <div class="am-ft-clear">
                    <span class="am-list-item-title am-ft-ellipsis am-ft-xl">需付款</span>
                    <span class="am-list-item-text am-ft-ellipsis am-ft-xxl">${total_amount}元</span>
                </div>
            </div>
        </div>
        <div class="am-section">
            <button type="button" id="okBtn" class="am-button am-button-blue" seed="v5_cashier_pre_confirm-submit">确认付款</button>
        </div>
    </form>
</div>
<footer>
    <div class="pay-logo"></div>
</footer>
</body>
<script src="//cdn.bootcss.com/jquery/2.2.1/jquery.js" charset="UTF-8"></script>
<script src="plugin/layer/layer.js"></script>
<script type="text/javascript">
$(function(){
	$("#okBtn").on("click",function(){
		if(false){
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
</html>