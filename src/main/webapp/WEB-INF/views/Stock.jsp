<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>销售记录查询</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 销售信息 <span
        class="c-gray en">&gt;</span> 销售记录查询 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <%--<div class="text-c">

        <form enctype="multipart/form-data" action="/upload" method="post" class="Huiform">
            <input type="file" name="file" class="input-text" style="width:200px">
            <input type="submit" value="上传工作文件" name="导入" onclick="upload_success()" class="upload_success btn btn-primary upload-btn">
        </form>

    </div>--%>
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	
	<%--<select value="切换用户" id="changeuser" onchange="haha()">
  <option value="all">全部</option>
        <c:forEach items="${Saleuname}" var="Saleuname">
  <option id="select" value="${Saleuname.user.uUsername}">${Saleuname.user.uUsername}</option>
        </c:forEach>
    </select>--%>
	<a
      href="javascript:;" onclick="admin_role_add('进货药品信息','${pageContext.request.contextPath}/AddStockPage','800')"
      class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 进货 </a>
	</span></div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th width="100">药品ID</th>
                <th width="100">药品名称</th>
                <th width="80">上货数量</th>
                <th width="200">药品价格</th>
                <th width="200">过期时间</th>
                <th width="100">上货时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Stocks}" var="Stock">
            <tr class="text-c">
                <td>${Stock.sId}</td>
                <td>${Stock.medicine.mName}</td>
                <td>${Stock.sCount}件</td>
                <td>${Stock.sPrice}元</td>
                <td> <fmt:formatDate value="${Stock.sPastdate}" pattern="yyyy年MM月dd日"/> </td>
                <td> <fmt:formatDate value="${Stock.sToday}" pattern="yyyy年MM月dd日"/></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
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
    //弹出层页面
    function admin_role_add(title,url,w,h){
        layer_show(title,url,w,h);
    }

    //提交成功提示
    $(".upload_success").click(function upload_success() {
       alert("文件上传成功！");
    });


    function haha(){
        cuname = $("#changeuser").val();
        alert(cuname);
        $.ajax({
            method: 'GET',
            dataType: 'JSON',
            url:"${pageContext.request.contextPath}/salemessage2?cuname="+cuname,
            success:function() {
                window.location.href="${pageContext.request.contextPath}/salemessage2";
            }
        });
    }

    $('.table-sort').dataTable({
        "aaSorting": [[0 , "asc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            {"orderable": false, "aTargets": [0, 4]}// 制定列不参与排序
        ]
    });
</script>
</body>
</html>