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
    <div action="" method="post" class="form form-horizontal" id="form-article-add">

        <%--0315老版本，选择指定用户，不能创建新用户--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">选择进货药品：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="stockdrug" class="select" id="changestockdrug">
					<option value="all">选择药品</option>
                <c:forEach items="${StockDrugs}" var="StockDrugs">
                    <option id="select" value="${StockDrugs.mId}"
                            onchange="selectdrug(${StockDrugs.mId})">${StockDrugs.mName}</option>
                </c:forEach>
				</select>
				</span>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">处理方式：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <a class="input-text" style="color: red ;width: 100%" id="Approach" ></a>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">进货数量：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="" id="stockcount" placeholder="" value="" class="input-text" style="width:90%">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">药品价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="" id="stockprice" placeholder="" value="" class="input-text" style="width:90%">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">过期时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" autocomplete="off" id="pastdate" placeholder="请输入日期" class="input-text Wdate"
                       style="width:180px;" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
            </div>
        </div>

            <%--获取当前操作员用户名--%>
            <a id="operator" style="display: none">${user.uUsername}</a>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <button onclick="sub()" <%--onClick="article_save_submit();"--%>
                        class="btn btn-primary radius" <%--type="submit"--%>><i
                        class="Hui-iconfont">&#xe632;</i> 保存并提交
                </button>
                <button onClick="layer_close();" class="btn btn-default radius" type="button">
                    &nbsp;&nbsp;取消&nbsp;&nbsp;
                </button>
            </div>
        </div>
    </div>
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

    //获取选中药品id,返回药品解决方案
    $("#changestockdrug").on("change", function () {
        var now = $("option:selected", this).val();
        $.ajax({
            type: "POST",
            dataType: "text",
            async: false,
            data: {
                'Drug_id': now
            },
            url: "${pageContext.request.contextPath}/OptionDrugState",
            success: function (data) {
                $("#Approach").html(data)
            }
        });
    });

    function sub() {

        var changestockdrug = $("#changestockdrug option:selected").val();//药品id
        var stockcount = $("#stockcount").val();//进货数量
        var stockprice = $("#stockprice").val();//药品价格
        var pastdate = $("#pastdate").val();
        var operator = $("#operator").text();

        // alert("药品"+changestockdrug + stockcount + stockprice + pastdate);

       //layui关闭弹出层
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        $.ajax({
            type: "POST",
            dataType: "text",
            //async:false,//异步方式,直到服务器端返回数据后，触发$.ajax里的success方法
            data: {
                'DrugID': changestockdrug,
                'StockCount': stockcount,
                'StockPrice': stockprice,
                'PastDate': pastdate,
                'Operator' : operator,
            },
            url: "${pageContext.request.contextPath}/AddStock",
            success: function (data) {
                parent.layer.close(index);
            },

        });

    }

    function layer_close() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index);
    }

</script>
</body>
</html>