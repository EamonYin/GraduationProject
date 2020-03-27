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
<!--[if lt IE 9]>
<script type="text/javascript" src="../../lib/html5shiv.js"></script>
<script type="text/javascript" src="../../lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="../../lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>药品管理</title><link rel="stylesheet" href="${pageContext.request.contextPath}/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<style>
		.updata1{
			width: 500px;
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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 药品信息管理 <span class="c-gray en">&gt;</span> 问题药品信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<%--<div class="text-c">
		<input type="text" name="" id="ssk" placeholder=" 药品名字" style="width:250px" class="input-text">
		<button name="" id="sou" class="btn btn-success" onclick="ac()"><i class="Hui-iconfont">&#xe665;</i> 搜药品</button>
	</div>--%>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <%--<span class="l"> <a class="btn btn-primary radius" onclick="opon()" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加图书</a></span>--%> <span class="r">共有数据：<strong>${OnSaleSize}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
			<tr class="text-c">
				<th width="100">药品编号</th>
				<th width="100">药品名称</th>
				<th width="60">药品价格</th>
				<th width="60">药品数量</th>
				<th width="100">药品状态</th>
				<th width="60">药品过期时间</th>
				<th width="100">药品类型</th>
				<th width="100">受理业务员</th>
				<th width="100">操作</th>
			</tr>
			</thead>

			<tbody>
			<c:forEach items="${OnSales}" var="OnSale">
			<tr class="text-c va-m">
				<td>${OnSale.oId}</td>
				<td>${OnSale.oName}</td>
				<td>${OnSale.oPrice}元</td>
				<td>${OnSale.oCount}件</td>
				<td>
						<%--多条件改变span颜色--%>
					<span class="label label-success radius"
						  style="background-color: ${OnSale.oState == '正常' ? 'green' : (OnSale.oState == '临期' ? 'blue' : (OnSale.oState == '库存过低' ? 'orange' : (OnSale.oState == '过期' ? 'red' : 'black')))}">
							${OnSale.oState}
					</span>
				</td>
				<td><fmt:formatDate value="${OnSale.oPastdate}" pattern="yyyy-MM-dd"/></td>
				<td>${OnSale.oClassify}</td>
				<td>${OnSale.oOperator}</td>

				<td class="td-manage">
					<a style="text-decoration:none" class="ml-5" onClick="Edit(this)" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
					<input class="iis" id="OnSale_oId" style="display: none" value="${OnSale.oId}"/>
					<a  style="text-decoration:none" class="ml-5" onClick="DeleteIt(this)" href="javascript:;"  title="删除">
						<i class="Hui-iconfont">&#xe6e2;</i>
					</a>
				</td>
			</tr>
			</c:forEach>
			</tbody>

		</table>
	</div>
</div>

<%--编辑药品信息--%>
<div class="updata2" id="EditMsg">
	<div method="get" action="updateMedicine" class="basic-grey">
		<label>
			<span style="width: auto">药品名称：</span>
			<input id="oName" type="text" name="Drug_Name" disabled="disabled" placeholder="${TheOnSale.oName}"/>
		</label>

		<label>
			<span style="width: auto">药品价格：</span>
			<input id="oPrice" type="text" name="Drug_Price" disabled="disabled" placeholder="${TheOnSale.oPrice}"/>
		</label>
		<label>
			<span style="width: auto">药品售出：</span>
			<input  id="oCount" type="text" name="Drug_Sale" placeholder="${TheOnSale.oCount}"/>件
		</label>
		<label>
			<span style="width: auto">药品类型：</span>
			<input id="oClassify" type="text" name="Drug_Classify" disabled="disabled" placeholder="${TheOnSale.oClassify}"/>
		</label>

		<label>
			<p style="text-align: center ; width: auto">最近记录</p><br>
			<textarea id="mRemark"  name="mRemark" style="font-size: 15px;height: 50px;width: 100%;overflow: hidden" ></textarea>
		</label>

        <label style="text-align: center">
			<input id="oId" style="display: none"  value="${TheOnSale.oId}" />
		    <button id="xiu" type="submit" value="修改" class="button" onclick="UpDate(this)">修改</button>
		    <button id="onn" type="button" value="取消" class="button" onclick="Cancel()">取消</button>
        </label>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">

	//显示 修改问题药品信息 弹窗
	function Edit(obj) {

		var OnSaleDrugId = obj.nextElementSibling.value;

		$.ajax({
			type : "POST",
			dataType : "JSON",
			data : {'OnSaleDrugId' : OnSaleDrugId},
			url: "${pageContext.request.contextPath}/ShowOnSaleMsg",
			success :function (TheOnSale) {
				$("#EditMsg").css("display","block");
				for (var key in TheOnSale)
				{
					if(key=="oName"){
						$("#oName").attr("value",TheOnSale[key]);
					}else if(key=="oPrice"){
						$("#oPrice").attr("value",TheOnSale[key]);
					}else if(key=="oCount"){
						$("#oCount").attr("value",TheOnSale[key]);
					}else if(key=="oClassify"){
						$("#oClassify").attr("value",TheOnSale[key]);
					}else if(key=="oId"){
						$("#oId").attr("value",TheOnSale[key]);
					}
				}
			}

	});
	}

	//提交 修改问题药品信息
	function UpDate(obj) {
		var OnSaleId = obj.previousElementSibling.value;
		var OnSaleCount = $("#oCount").val();
		var mRemark = $("#mRemark").val();
		var oName = $("#oName").val();

		$.ajax({
			type : "POST",
			dataType : "text",
			data : {
				'OnSaleId' : OnSaleId,
				'OnSaleCount' : OnSaleCount,
				'mRemark' : mRemark,
				'oName' : oName,
			},
			url: "${pageContext.request.contextPath}/UpDateOnSale",

		});
		$("#EditMsg").css("display","none");

	}

	//取消 修改问题药品信息 弹窗
	function Cancel() {
		$("#EditMsg").css("display","none");
	}

	//删除选中药品
	function DeleteIt(obj) {
		var OnSaleId = obj.previousElementSibling.value;
		flag = window.confirm("确定要删除该信息？");
		if(flag==false){ return false }
		window.location.href = "${pageContext.request.contextPath}/DeleteIt?OnSaleId="+OnSaleId;
	}

	$('.table-sort').dataTable({
		"aaSorting": [[ 0, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
			{"orderable":false,"aTargets":[1,2,6,7]}// 制定列不参与排序
		]
	});

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
</body>
</html>