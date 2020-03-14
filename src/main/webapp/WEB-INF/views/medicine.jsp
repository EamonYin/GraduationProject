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
			width: 500px;
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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 药品管理 <span class="c-gray en">&gt;</span> 药品信息管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" name="" id="ssk" placeholder=" 药品名字" style="width:250px" class="input-text">
		<button name="" id="sou" class="btn btn-success" onclick="ac()"><i class="Hui-iconfont">&#xe665;</i> 搜药品</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <%--<span class="l"> <a class="btn btn-primary radius" onclick="opon()" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加图书</a></span>--%> <span class="r">共有数据：<strong>${num}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
			<tr class="text-c">
				<th width="100">药品编号</th>
				<th width="100">药品名称</th>
				<th width="60">种类</th>
				<th width="60">价格</th>
				<th width="100">过期时间</th>
				<th width="60">库存</th>
				<th width="100">状态</th>
				<th>最近记录</th>
				<th width="100">操作</th>
			</tr>
			</thead>

			<tbody>
			<c:forEach items="${list}" var="list">
			<tr class="text-c va-m">
				<td>${list.mMedicineid}</td>
				<td>${list.mName}</td>
				<td>${list.mClassify}</td>
				<td><span class="price">${list.mPrice}</span> 元</td>
				<td><fmt:formatDate value="${list.mPastdate}" pattern="yyyy-MM-dd"/></td>
				<td>${list.mInventory}</td>
				<td><span class="label label-success radius">${list.mState}</span></td>
				<td class="td-status"><div  style="overflow-y: scroll;height: 40px">${list.mRemark}</div></td>
				<td class="td-manage">
					<input class="iis" style="display: none" value="${list.mMedicineid}"/>
					<a style="text-decoration:none" class="ml-5" onclick="add(this)" href="javascript:;" title="添加记录"><i class="Hui-iconfont">&#xe600;</i></a>
					<input class="iis" style="display: none" value="${list.mRemark}"/>
					<a style="text-decoration:none" class="ml-5" onClick="abb(this)" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
					<input class="iis" style="display: none" value="${list.mMedicineid}"/>
					<a  style="text-decoration:none" class="ml-5" onClick="acc(this)" href="javascript:;"  title="删除">
						<i class="Hui-iconfont">&#xe6e2;</i>
					</a>
				</td>
			</tr>
			</c:forEach>
			</tbody>

		</table>
	</div>
</div>

<%--添加记录--%>
<div class="updata1" id="remark">
	<form method="get" action="addRemark" class="basic-grey">
		<label>
			<p style="text-align: center">最近记录</p><br>
			<textarea id="mRemark"  name="mRemark" style="font-size: 15px;height: 350px;width: 100%;overflow: hidden" ></textarea>
		</label>
        <label style="text-align: center">
		    <button id="ok" type="submit" value="添加" class="button">添加</button>
			<input class="iis" style="display: none" id="r1" name="r1" />
		    <button id="no" type="button" value="取消" class="button" onclick="bbc()">取消</button>
        </label>
	</form>
</div>
<%--编辑药品信息--%>
<div class="updata2" id="mainContent">
	<form method="get" action="updateMedicine" class="basic-grey">
		<label>
			<span>药品编号：</span>
			<input id="mMedicineid" type="text" name="mMedicineid"  placeholder="${asc.mMedicineid}"/>
		</label>
		<label>
			<span>药品名称：</span>
			<input  id="mName" type="text" name="mName"  placeholder="${asc.mName}"/>
		</label>
		<label>
			<span>药品种类：</span>
			<input  id="mClassify" type="text" name="mClassify" placeholder="${asc.mClassify}"/>
		</label>
		<label>
			<span>药品价格：</span>
			<input id="mPrice" type="text" name="mPrice"  placeholder="${asc.mPrice}"/>
		</label>

        <label style="text-align: center">
		    <button id="xiu" type="submit" value="修改" class="button">修改</button>
		    <button id="onn" type="button" value="取消" class="button" onclick="bac()">取消</button>
        </label>
	</form>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">


	//添加记录
	function bbc() {
		$("#remark").css("display","none");
	}
	function add(obj) {
		var id=obj.previousElementSibling.value;
		var re=obj.nextElementSibling.value;
		$("#remark").css("display","block");
		$("#r1").val(id)
		$("#mRemark").val(re);
	}


	//修改药品信息
	function bac() {
		$("#mainContent").css("display","none");
	}
	function abb(obj) {
		var mmid=obj.nextElementSibling.value;
		$.ajax({
			url:"${pageContext.request.contextPath}/selectMedicine?mmid="+mmid,
			type:"GET",
			dataType:"json",
			success:function(asc) {
				$("#mainContent").css("display","block");
				for (var key in asc)
				{
					if(key=="mMedicineid"){
						$("#mMedicineid").attr("value",asc[key]);
					}else if(key=="mName"){
						$("#mName").attr("value",asc[key]);
					}else if(key=="mClassify"){
						$("#mClassify").attr("value",asc[key]);
					}else if(key=="mPrice"){
						$("#mPrice").attr("value",asc[key]);
					}
				}
			}
		})
	}
	//删除该药品
	function acc(obj) {
		var mMedicineid=obj.previousElementSibling.value;
		flag = window.confirm("确定要删除该信息？");
		if(flag==false){ return false }
		window.location="${pageContext.request.contextPath}/deleteMedicine?mMedicineid="+mMedicineid;

	}

	//搜索药品
	function ac() {
		var mn=$("#ssk").val();
		window.location="${pageContext.request.contextPath}/selectM?mn="+mn;

	}


	$('.table-sort').dataTable({
		"aaSorting": [[ 0, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
			{"orderable":false,"aTargets":[1,2,6,7]}// 制定列不参与排序
		]
	});
	/*/!*产品-添加*!/
	function product_add(title,url){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}
	/!*产品-查看*!/
	function product_show(title,url,id){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}

	/!*产品-下架*!/
	function product_stop(obj,id){
		layer.confirm('确认要下架吗？',function(index){
			$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
			$(obj).remove();
			layer.msg('已下架!',{icon: 5,time:1000});
		});
	}

	/!*产品-编辑*!/
	function product_edit(title,url,id){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}

	/!*产品-删除*!/
	function product_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});
		});
	}*/
</script> 
</body>
</html>