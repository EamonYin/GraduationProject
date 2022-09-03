<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>我的学习总结</title>
    <link rel="stylesheet" href="/static/login-ui/css/auth.css">

    <%--轮播效果--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>

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

    <!--选项卡字体样式-->
    <style>
        /** {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        body {
            font-size: 12px;
            color: #666;
            text-align: left;
        }*/

        h1 {
            text-align: center;
        }

        .tabbox {
            width: 650px;
            height: 77%;
            margin: 50px auto;
            background: #f0f0f0;
            font-family: '微软雅黑';
        }

        .tabbox .tab {
            overflow: hidden;
            background: #ccc;
        }

        .tabbox .tab a {
            display: block;
            padding: 10px 20px;
            float: left;
            text-decoration: none;
            color: #333;
        }

        .tabbox .tab a:hover {
            background: #E64E3F;
            color: #fff;
            text-decoration: none;
        }

        .tabbox .tab a.on {
            background: #E64E3F;
            color: #fff;
            text-decoration: none;
        }

        .tabbox .content {
            overflow: hidden;
            width: 650px;
            height: 1000px;
            position: relative;
        }

        .tabbox .content ul {
            position: absolute;
            left: 0;
            top: 0;
            height: 1000px;
        }

        .tabbox .content li {
            width: 650px;
            height: 1000px;
            float: left;
        }

        .tabbox .content li p {
            padding: 10px;
        }

        .content ul {
            font-size: 20px;
        }

    </style>
</head>
<body>
<div class="lowin" style="z-index: 199 ; position: fixed;
    top: 0px;
    left: 0px;
    right: 0px;
    bottom: 0px;
    margin: auto;  height: 600px"><%--ackground-color: #0e90d2 ;--%>
    <!-- Tab Begin -->
    <div class="tabbox">
        <div class="tab">
            <a href="javascript:;" class="on">自我介绍</a>
            <a href="javascript:;">学习总结</a>
            <a href="javascript:;">做过的项目</a>
        </div>
        <div class="content">
            <ul>

                <li style="text-align: left">
                <p style="text-align: center">
                    欢迎来到 小名同学 的空间<br>
                    小名励志成为一名合格的 Java后端开发工程师！<br>
                    一只 2020届 的仔~<br>
                </p>
                    <b>&nbsp;掌握框架：</b>SSM、SpringBoot。<br><br>
                    <b>&nbsp;前端掌握：</b>JSP、JDBC、JSTL、jQuery、Javascript、Ajax、EL表达式等主流技术。<br><br>
                    <b>&nbsp;后端掌握：</b>JavaSE并熟练搭建 Java开发环境。<br><br>
                    <b>&nbsp;熟悉技术：</b>MySQL、Oracle数据库的操作、部署Linux服务器、Redis、Nginx。<br><br>
                    <b>&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</b>xiaominglovejava@163.com<br>
                </li>
                <li style="text-align:center">
                    <p style="margin-top: 25%">学习总结在CSDN上</p>
                    <a href="https://blog.csdn.net/Tianc666">点击移步到我的博客</a>
                </li>
                <li style="text-align: left">
                    <p style="text-align: center"><b>在校项目：</b></p>
                    &nbsp;1.&nbsp;基于Spingboot+VUE的 学生信息 管理系统<br><br>
                    &nbsp;2.&nbsp;<a href="http://www.xiaoming100.club/login">基于SSM技术的药房管理系统</a><br><br>
                    &nbsp;3.&nbsp;基于SSM的 咖啡商城+微信订阅号<br><br>
                    <p style="text-align: center"><b>实习内容：</b></p>
                    &nbsp;1.&nbsp;通过CAS单点登录，将现有项目对接到统一教育平台<br><br>
                    &nbsp;2.&nbsp;跟进教育项目组
                </li>
            </ul>
        </div>
    </div>
</div>


<!-- 轮播图Begin -->
<div id="index_main" class="index_main" style="z-index: -100 ; position: fixed">
    <!--导航-->
    <div class="section section1">
        <div class="index_banner">
            <div class="item">
                <div class="items scaleBg" style="background-image: url('static/lyimg/ly1.jpg');"></div>
                <div class="inner">
                    <%--<div class="block_txt">
                        <h4> Goodliness,to be continued</h4>
                        <h2>让<span>美好持续</span>发生</h2>
                        <h3>
                            <div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
                                <p>适用浏览器：360、FireFox、Chrome、Opera、傲游、搜狗、世界之窗. 不支持Safari、IE8及以下浏览器。</p>
                                <p>来源：<a href="http://sc.chinaz.com/" target="_blank">站长素材</a></p>
                            </div>
                        </h3>
                    </div>--%>
                </div>
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('static/lyimg/ly2.jpg');"></div>
                <%--<div class="inner">
                    <div class="block_txt">
                        <h4> Goodliness,to be continued</h4>
                        <h2>让<span>美好持续</span>发生</h2>
                        <h3>我们有让美好持续发生的愿望，更有让美好持续发生的能力</h3>
                    </div>
                </div>--%>
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('static/lyimg/ly3.jpg');"></div>
                <div class="inner">
                    <%--<div class="block_txt">
                        <h4> </h4>
                        <h2><span>0-12岁</span><br>可持续发展教育体系</h2>
                        <h3>0-3岁早教  |  3-6岁幼儿园  |  5-12岁成长衔接  |  6-12岁小学</h3>
                    </div>--%>
                </div>
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('static/lyimg/ly4.jpg');"></div>
                <div class="inner">
                    <%--<div class="block_txt">
                        <h4> </h4>
                        <h2>幼儿园园所整体解决方案</h2>
                        <h3>全程支持  |  个性服务</h3>
                    </div>--%>
                </div>
            </div>
            <div class="item">
                <div class="items scaleBg" style="background-image: url('static/lyimg/ly5.jpg');"></div>
                <%--<div class="inner">
                    <div class="block_txt">
                        <h4>  </h4>
                        <h2>成长管理发展测评</h2>
                        <h3>科学量表  |  全面评估  |  教育指导</h3>
                    </div>
                </div>--%>
            </div>
        </div>
        <%--<div class="left slick_txt">
            <div class="prev slick_arrow"></div>
        </div>
        <div class="right slick_txt">
            <div class="next slick_arrow"></div>
        </div>--%>
        <div class="number">
            <div class="inner clearfix">
                <span class="active">01</span>
                <span>02</span>
                <span>03</span>
                <span>04</span>
                <span>05</span>
            </div>
        </div>

    </div>
</div>
<!--备案号-->
<div style="z-index: 299 ; position: fixed;
    left: 0px;
    right: 0px;
    bottom: 2%;
    margin: auto; width: 200px ; background-color: white">
    <a href="http://beian.miit.gov.cn" name="津ICP备19009283号">津ICP备19009283号</a>
</div>
<script src="static/indexjs/jquery-1.8.3.min.js"></script>
<script src="static/Rotation/js/jquery.min.js"></script>
<script src="static/Rotation/js/jquery.fullPage.min.js"></script>
<script src="static/Rotation/js/index_slick.js"></script>
<script src="static/Rotation/js/index.js"></script>
<script>
    $(function () {
        $('.tabbox .content ul').width(650 * $('.tabbox .content li').length + 'px');
        $(".tabbox .tab a").mouseover(function () {
            $(this).addClass('on').siblings().removeClass('on');
            var index = $(this).index();
            number = index;
            var distance = -650 * index;
            $('.tabbox .content ul').stop().animate({
                left: distance
            });
        });

        var auto = 1;  //等于1则自动切换，其他任意数字则不自动切换
        if (auto == 1) {
            var number = 0;
            var maxNumber = $('.tabbox .tab a').length;

           /* function autotab() {
                number++;
                number == maxNumber ? number = 0 : number;
                $('.tabbox .tab a:eq(' + number + ')').addClass('on').siblings().removeClass('on');
                var distance = -500 * number;
                $('.tabbox .content ul').stop().animate({
                    left: distance
                });
            }*/

            var tabChange = setInterval(autotab, 3000);
            //鼠标悬停暂停切换
            $('.tabbox').mouseover(function () {
                clearInterval(tabChange);
            });
            $('.tabbox').mouseout(function () {
                tabChange = setInterval(autotab, 3000);
            });
        }
    });
</script>
</body>
</html>