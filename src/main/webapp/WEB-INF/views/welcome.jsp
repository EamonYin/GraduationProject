<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>我的桌面</title>
<link type="text/css" href="static/welcome/css/style.css" rel="stylesheet" />
<script src="http://www.jq22.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/welcome/js/scroll.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.list_lh li:even').addClass('lieven');
})
$(function(){
	$("div.list_lh").myScroll({
		speed:40, //数值越大，速度越慢
		rowHeight:68 //li的高度
	});
});
</script>
</head>
<body>
<div class="page-container">
	<p class="f-14">欢迎使用 <span class="f-20 text-success">名创药业</span> 管理系统！</p>
	<p>当前登录用户：${user.uUsername} </p>
	<p>登录IP：${IP}  登录时间：${Date}</p>
	
	<div class="box" style="width:100%; " >
		<div class="bcon">
			<!-- <h1><b>领号实时播报</b></h1> -->
			<h1><a>药品手账推送</a></h1>
			<!-- 代码开始 -->
			<div class="list_lh">
				<ul>
                    <c:forEach items="${RemarkMsgs}" var="RemarkMsg">
					<li>
						<p>
							<a href="#">${RemarkMsg.drugName}</a>
						</p>
						<p>
							<span href="#" class="a_blue">${RemarkMsg.drugRemark}</span>
						</p>
					</li>
					</c:forEach>
					<%--<li>
						<p>
							<a href="#">222222</a>
							<!-- <a href="#" class="btn_lh">领号</a> -->
							<!-- <em>获得</em> -->
						</p>
						<p>
							<span href="#" class="a_blue">jquery使用方法2</span>
							<!-- <span>17:28:05</span> -->
						</p>
					</li>
					<li>
						<p>
							<a href="#">333333</a>
							<!-- <a href="#" class="btn_lh">领号</a> -->
							<!-- <em>获得</em> -->
						</p>
						<p>
							<span href="#" class="a_blue">jquery使用方法3</span>
							<!-- <span>17:28:05</span> -->
						</p>
					</li>
					<li>
						<p>
							<a href="#">444444</a>
							<!-- <a href="#" class="btn_lh">领号</a> -->
							<!-- <em>获得</em> -->
						</p>
						<p>
							<span href="#" class="a_blue">jquery使用方法4</span>
							<!-- <span>17:28:05</span> -->
						</p>
					</li>
					<li>
						<p>
							<a href="#">555555</a>
							<!-- <a href="#" class="btn_lh">领号</a> -->
							<!-- <em>获得</em> -->
						</p>
						<p>
							<span href="#" class="a_blue">jquery使用方法5</span>
							<!-- <span>17:28:05</span> -->
						</p>
					</li>
					<li>
						<p>
							<a href="#">666666</a>
							<!-- <a href="#" class="btn_lh">领号</a> -->
							<!-- <em>获得</em> -->
						</p>
						<p>
							<span href="#" class="a_blue">jquery使用方法6</span>
							<!-- <span>17:28:05</span> -->
						</p>
					</li>
					<li>
						<p>
							<a href="#">777777</a>
							<!-- <a href="#" class="btn_lh">领号</a> -->
							<!-- <em>获得</em> -->
						</p>
						<p>
							<span href="#" class="a_blue">jquery使用方法7</span>
							<!-- <span>17:28:05</span> -->
						</p>
					</li>
					<li>
						<p>
							<a href="#">88888888</a>
							<!-- <a href="#" class="btn_lh">领号</a> -->
							<!-- <em>获得</em> -->
						</p>
						<p>
							<span href="#" class="a_blue">jquery使用方法7</span>
							<!-- <span>17:28:05</span> -->
						</p>
					</li>--%>
				</ul>
			</div>
			<!-- 代码结束 -->
		</div>
		
	</div>

</div>
<footer class="footer mt-20">
	<div class="container">
		<p>感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br>
			Copyright &copy;2015-2017 H-ui.admin v3.1 All Rights Reserved.<br>
			本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持</p>
	</div>
</footer>
<!-- <script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> -->
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 

</body>
</html>