<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/login-ui/css/auth.css">

    <%--轮播效果--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />

    <!--默认样式-->
    <link rel="stylesheet" href="static/Rotation/css/reset.css">

    <!--响应式框架-->
    <link rel="stylesheet" type="text/css" href="static/Rotation/css/bootstrap.css">

    <!--css3动画库-->
    <link rel="stylesheet" href="static/Rotation/css/animate.css">

    <!--banner大图基础样式-->
    <link rel="stylesheet" href="static/Rotation/css/slick.css">

    <!--图片和滚屏样式-->
    <link rel="stylesheet" href="static/Rotation/css/index.css">
</head>

<body>

<div class="lowin" style="z-index: 999 ; position: fixed;
    top: 8%;
    left: 0px;
    right: 0px;
    bottom: 0px;
    margin: auto;">
    <div class="lowin-brand ">
        <img src="${pageContext.request.contextPath}/static/login-ui/img/mc.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper" >
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form>
                    <a href="${pageContext.request.contextPath}/changeLocal?request_locale=zh_CN">中文</a> |
                    <a href="${pageContext.request.contextPath}/changeLocal?request_locale=en_US">English</a>

                    <p><spring:message code="memberlog"/>

                    </p>
                    <div class="lowin-group">
                        <label><spring:message code="uname"/> <a href="#" class="login-back-link">登录</a></label>
                        <input type="text" autocomplete="text" name="uname" value="" class="lowin-input loginname">
                    </div>
                    <div class="lowin-group password-group">
                        <label><spring:message code="upwd"/> <a href="#" class="forgot-link"><%--忘记密码?--%></a></label>
                        <input type="password" name="password" autocomplete="current-password" class="lowin-input pws">
                    </div>

                    <button  class="lowin-btn login-btn"  type="submit" onclick="return login()">
                        <spring:message code="title"/>
                    </button>
                    <div class="text-foot">
                        <spring:message code="noaccount"/> <a href="" class="register-link"><spring:message code="register1"/></a>
                    </div>
                </form>

            </div>
        </div>

        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <form>
                    <p> <spring:message code="createaccount"/></p>
                    <div class="lowin-group">
                        <label><spring:message code="uname"/></label>
                        <input type="text" name="name" autocomplete="name" class="lowin-input rname">
                    </div>

                    <div class="lowin-group">
                        <label><spring:message code="upwd"/></label>
                        <input type="password" name="password" autocomplete="current-password" class="lowin-input rpwd">
                    </div>

                    <div class="lowin-group">
                        <label><spring:message code="confirm1"/></label>
                        <input type="password" autocomplete="current-password" name="Repassword" class="lowin-input Repwd">
                    </div>

                    <button class="lowin-btn" id="haha">
                        <spring:message code="logregister"/>
                    </button>

                    <div class="text-foot">
                        <spring:message code="alreadyaccount"/> <a href="" class="login-link"><spring:message code="title"/></a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <footer class="lowin-footer">

    </footer>

</div>

<!-- 背景轮播图 -->
<div id="index_main" class="index_main" style="z-index: -100 ; position: fixed">
    <!--导航-->
    <div class="section section1">
        <div class="index_banner">
            <div class="item">
                <div class="items scaleBg" style="background-image: url('/static/Rotation/image/1.jpg');"></div>

            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('/static/Rotation/image/2.png');"></div>

            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('/static/Rotation/image/3.png');"></div>

            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('/static/Rotation/image/4.jpg');"></div>

            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('/static/Rotation/image/5.jpg');"></div>

            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/login-ui/js/auth.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script language="JavaScript">

    $(".login-btn").click(function () {
        var uname = $(".loginname").val();
        var password = $(".pws").val();

        document.write("<form action='/opinionUser' method='post' name=form1 style='display:none'>");
        document.write("<input type=hidden name=name value='" + uname + "'/>");
        document.write("<input type=hidden name=password value='" + password + "'/>");
        document.write("</form>");
        document.form1.submit();

    });
        $("#haha").click(function () {

            var rname = $(".rname").val();
            var pwd = $(".rpwd").val();
            var Repwd = $(".Repwd").val();
            if(Repwd == pwd){
                document.write("<form action='/registerUser' method='post' name=form2 style='display:none'>");
                document.write("<input type=hidden name=rname value='" + rname + "'/>");
                document.write("<input type=hidden name=rpassword value='" + pwd + "'/>");
                document.write("<input type=hidden name=Repwd value='" + Repwd + "'/>");
                document.write("</form>");
                document.form2.submit();
            }
            else{
                alert("两次密码输入不同，请重新输入");
                document.write("<form action='/registerUser' method='post' name=form3 style='display:none'>");
                document.write("<input type=hidden name=rname value='" + rname + "'/>");
                document.write("<input type=hidden name=rpassword value='" + pwd + "'/>");
                document.write("<input type=hidden name=Repwd value='" + Repwd + "'/>");
                document.write("</form>");
                document.form3.submit();
            }
        });

</script>
<script>
    Auth.init({
        login_url: '#login',
        forgot_url: '#forgot'
    });
</script>

<script src="static/Rotation/js/jquery.min.js"></script>
<script src="static/Rotation/js/jquery.fullPage.min.js"></script>
<script src="static/Rotation/js/index_slick.js"></script>
<script src="static/Rotation/js/index.js"></script>

</body>
</html>