<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
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
<title>客户管理列表</title>

	<style>
		.updata1{
			width: 50%;
			height: 500px;
			z-index: 10;
			position: fixed;
			left: 50%;
			top: 50%;
			transform: translate(-50%, -50%);
			display:none;
		}
		.updata2{
			width: 50%;
			height: auto;
			z-index: 10;
			position: fixed;
			left: 50%;
			top: 50%;
			transform: translate(-50%, -50%);
			display:none;
		}
		.basic-grey {
			margin-left:auto;
			margin-right:auto;
			max-width: 500px;
			background: #F7F7F7;
			padding: 25px 15px 25px 10px;
			font: 12px Georgia, "Times New Roman", Times, serif;
			color: #888;
			text-shadow: 1px 1px 1px #FFF;
			border:1px solid #E4E4E4;
		}
		.basic-grey h1 {
			font-size: 25px;
			padding: 0px 0px 10px 40px;
			display: block;
			border-bottom:1px solid #E4E4E4;
			margin: -10px -15px 30px -10px;;
			color: #888;
		}
		.basic-grey h1>span {
			display: block;
			font-size: 11px;
		}
		.basic-grey label {
			display: block;
			margin: 0px;
		}
		.basic-grey label>span {
			float: left;
			width: 20%;
			text-align: right;
			padding-right: 10px;
			margin-top: 10px;
			color: #888;
		}
		.basic-grey input[type="text"], .basic-grey input[type="email"], .basic-grey textarea, .basic-grey select {
			border: 1px solid #DADADA;
			color: #888;
			height: 30px;
			margin-bottom: 16px;
			margin-right: 6px;
			margin-top: 2px;
			outline: 0 none;
			padding: 3px 3px 3px 5px;
			width: 70%;
			font-size: 12px;
			line-height:15px;
			box-shadow: inset 0px 1px 4px #ECECEC;
			-moz-box-shadow: inset 0px 1px 4px #ECECEC;
			-webkit-box-shadow: inset 0px 1px 4px #ECECEC;
		}
		.basic-grey textarea{
			padding: 5px 3px 3px 5px;
		}

		.basic-grey .button {
			background: #E27575;
			border: none;
			padding: 10px 25px 10px 25px;
			color: #FFF;
			box-shadow: 1px 1px 5px #B6B6B6;
			border-radius: 3px;
			text-shadow: 1px 1px 1px #9E3F3F;
			cursor: pointer;

		}

	</style>

</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 账户管理 <span class="c-gray en">&gt;</span> 顾客列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
			<%--<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>--%>
			<a href="javascript:;" onclick="admin_add('添加用户','${pageContext.request.contextPath}/GoClientAddPage','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a>
		</span> <span class="r">共有数据：<strong>${ClientsSize}</strong> 条</span> </div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">员工列表</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th >ID</th>
				<th >登录名</th>
				<th >密码</th>
				<th >电话号码</th>
				<th >操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${Clients}" var="Client">
			<tr class="text-c">
				<td><input type="checkbox" value="1" name=""></td>
				<td>${Client.cId}</td>
				<td>${Client.cClientname}</td>
				<td>${Client.cPassword}</td>
				<td>${Client.cPhonenum}</td>
				<td class="td-manage">
					<a title="编辑" href="javascript:;" onclick="client_edit(this)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<input id="uId" style="display: none"  value="${Client.cId}" />
					<a title="删除" href="javascript:;" onclick="client_del(this)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="updata2" id="mainContent">
	<div method="get" action="updateMedicine" class="basic-grey">
		<label>
			<span style="width: auto">登&nbsp;录&nbsp;名：</span>
			<input id="cClientname" type="text" name="cClientname"  placeholder="${EditClient.cClientname}"/>
		</label>
		<label>
			<span style="width: auto">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
			<input  id="cPassword" type="text" name="cPassword"  placeholder="${EditClient.cPassword}"/>
		</label>
		<label>
			<span style="width: auto">电话号码：</span>
			<input  id="cPhonenum" type="text" name="cPhonenum"  placeholder="${EditClient.cPhonenum}"/>
		</label>

		<label style="text-align: center">
			<button id="xiu" type="submit" value="修改" class="button" onclick="UpDate(this)">修改</button>
			<input id="uuid" style="display: none" value="${EditClient.cId}">
			<button id="onn" type="button" value="取消" class="button" onclick="Cancel()">取消</button>
		</label>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

	/*弹出编辑页面*/
	function client_edit(obj) {
		var cId = obj.nextElementSibling.value;
		// alert(cId)
		$.ajax({
			type : "POST",
			dataType : "JSON",
			data : {'EditClientId' : cId},
			url: "${pageContext.request.contextPath}/ShowClientMsg",
			success :function (EditClient) {
				$("#mainContent").css("display","block");
				for (var key in EditClient)
				{
					if(key=="cId"){
						$("#uuid").attr("value",EditClient[key]);
					}else if(key=="cClientname"){
						$("#cClientname").attr("value",EditClient[key]);
					}else if(key=="cPassword"){
						$("#cPassword").attr("value",EditClient[key]);
					}else if(key=="cPhonenum"){
						$("#cPhonenum").attr("value",EditClient[key]);
					}
				}
			}

		});
	}
    /*更新用户信息*/
	function UpDate(obj) {
      var cId = obj.nextElementSibling.value;
      var cClientname = $("#cClientname").val();
      var cPassword = $("#cPassword").val();
	  var cPhonenum = $("#cPhonenum").val();
	  // alert(cId);
		$.ajax({
			type : "POST",
			dataType : "text",
			data : {
				'cId' : cId,
				'cClientname' : cClientname,
				'cPassword' : cPassword,
				'cPhonenum' : cPhonenum,
			},
			url: "${pageContext.request.contextPath}/UpDateClient",
		});
		$("#mainContent").css("display","none");
	}
    /*取消，关闭编辑页面*/
	function Cancel() {
		$("#mainContent").css("display","none");
	}
	//删除选中用户
	function client_del(obj) {
		var uId = obj.previousElementSibling.value;
		flag = window.confirm("确定要删除该信息？");
		if(flag==false){ return false }
		window.location.href = "${pageContext.request.contextPath}/DeleteClient?uId="+uId;
	}

	function admin_add(title,url,w,h){
		layer_show(title,url,w,h);
	}

</script>
</body>
</html>