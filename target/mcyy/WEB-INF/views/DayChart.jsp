<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/echarts/echarts.min.js"></script>
</head>
<body>

<select value="切换日期" id="changetime" onclick="changetime()">
    <%--    <option value="all">选择要查看的日销售量日期：</option>--%>
    <c:forEach items="${seltime}" var="SaleTime">
        <option value="${SaleTime}">${SaleTime}</option>
    </c:forEach>
</select>

<div style="width: 100%;height: 100%" id="chartmain" style="width: 100%;height:630px;"></div>

<script type="text/javascript">

    $(function(){
        ajaxtest();
        changetime();
    });

    function changetime(){

        var change = $("#changetime").val();
        if(change === undefined ){
            alert(change);
            change = "2019-09-01"
        }
        ajaxtest(change);

    }


    function ajaxtest(change) {
        $.ajax({
            async:false,
            url:'${pageContext.request.contextPath}/charts/daychart?changetime='+change,
            type:'POST',
            dataType : 'json',//后台@ResponseBody返回的json数据是一个纯String类型的对象,dataType属性设置为text
            success:function (data) {//data是形参，随便取名，data表示的就是服务器返回的json格式的数据
                initChart(data);
            }
        });
    }
    function formatData(data) {

        var xAxis = [];
        var serData =[];

        for(var i = 0 ; i < data.length ; i++){
            xAxis.push(data[i].name);
            console.log(xAxis);
            serData.push(data[i].sell);
            console.log(serData);
        }
        return {
            xAxis : xAxis,
            serData : serData,
        };
    }

    function initChart(data) {
        var dom = document.getElementById("chartmain");
        var myChart = echarts.init(dom);
        var change = $("#changetime").val();

        var option = {
            title: {
                text: change+'日销售各时间段销售额情况',
                // subtext: '纯属虚构',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: data,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        myChart.setOption(option, true);

    };


</script>

</body>
</html>
