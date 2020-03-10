<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
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
    <!--/meta 作为公共模版分离出去-->

    <link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/login-ui/js/need/laydate.css"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/login-ui/js/laydate.js"></script>

</head>
<body>
<div class="page-container">
    <form action="" method="post" class="form form-horizontal" id="form-article-add">

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">选择用户：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="unames" class="select" id="changeuser" >
					<option value="all">选择用户</option>
                <c:forEach items="${users}" var="users">
                    <option id="select" value="${users.uId}">${users.uUsername}</option>
                </c:forEach>
				</select>
				</span></div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">选择药品：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select value="切换药品" id="changemedicine" class="select">
                <option value="all">选择药品</option>
                <c:forEach items="${medicines}" var="medicines">
                    <option id="select" value="${medicines.mMedicineid}">${medicines.mName}</option>
                </c:forEach>
				</select>
				</span></div>
            </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">购买数量：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="" id="count" placeholder="" value="" class="input-text" style="width:90%">
                件
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">销售时间：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" autocomplete="off" id="date" placeholder="请输入日期" class="input-text Wdate"
                               style="width:180px;"   onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                    </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <button onclick="sub()" <%--onClick="article_save_submit();"--%> class="btn btn-primary radius" <%--type="submit"--%>><i
                        class="Hui-iconfont">&#xe632;</i> 保存并提交
                </button>
                <button onClick="layer_close();" class="btn btn-default radius" type="button">
                    &nbsp;&nbsp;取消&nbsp;&nbsp;
                </button>
            </div>
        </div>
    </form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"></script>
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

    function sub(){

        var changeuser = $("#changeuser option:selected").val();  //获取选中的项
        var changemedicine = $("#changemedicine option:selected").val();
        var date = $("#date").val();
        var count = $("#count").val();

        $.ajax({
            type : "POST",
            //async:true,//异步方式,直到服务器端返回数据后，触发$.ajax里的success方法
            data : {
                "UserName_id" : changeuser,
                "DrugName_id" : changemedicine,
                "Purchased" : count,
                "SalesTime" : date,
            },
            url : "${pageContext.request.contextPath}/submitting_add",

        });

        //layui关闭弹出层
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index);

    }
</script>
</body>
</html>