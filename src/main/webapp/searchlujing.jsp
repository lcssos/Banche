<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>后台管理-后台管理</title>
    <link rel="stylesheet" href="css/classic.css"/>
    <link rel="stylesheet" href="css/classic.date.css"/>
    <link rel="stylesheet" href="css/classic.time.css"/>
    <script type="application/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="application/javascript" src="js/picker.js"></script>
    <script type="application/javascript" src="js/picker.date.js"></script>
    <script type="application/javascript" src="js/picker.time.js"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>
    <script type="application/javascript" src="js/guijiajax.js"></script>
</head>
<body>
<div style="width: 35%;display: inline;float: left">
    请输入查看轨迹车辆车牌：<input type="text" id="guijichepai" name="guijichepai" placeholder="车牌号"/>
    <br/>
    请选择查看轨迹开始日期：<input type="text" class="datepicker"/>
    <br/>
    请选择查看轨迹开始时间：<input type="time" class="timepicker"/>
    <br/>

    <div id="container" style="position:relative"></div>
    请选择查看轨迹结束日期：<input type="text" class="datepicker"/>
    <br/>
    请选择查看轨迹结束时间：<input type="time" class="timepicker"/>
    <br/>
    <input type="button" value="提交" onclick="subajax()"/>
    <input type="button" value="开始" onclick="kaishi()"/>
    <input type="button" value="停止" onclick="tingzhi()"/>
    <input type="button" value="重置" onclick="chongzhi()"/>
</div>
<div style="width: 65%;height: 1024px;display: inline;float: left" id="allmap">
</div>
</body>
</html>

<script type="text/javascript">

    var $input = $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: true,
        formatSubmit: 'yyyy:mm:dd',
        containerHidden: '#container',
        closeOnSelect: true,
        closeOnClear: true,
        monthsFull: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        monthsShort: ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十', '十一', '十二'],
        weekdaysFull: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        weekdaysShort: ['日', '一', '二', '三', '四', '五', '六'],
        today: '今日',
        clear: '清除',
        close: '关闭',
        format: 'yyyy 年 mm 月 dd 日',
        min: -7,
        max: true
    });
    var $timeinput = $('.timepicker').pickatime({
        interval: 60,
        formatSubmit: 'HH',
        formatLabel: 'HH'
    });
    var int;
    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW&callback=init()";
        document.body.appendChild(script);

    }
    function subajax() {

        var startday = document.getElementsByName("_submit")[1].value;
        var starttime = document.getElementsByName("_submit")[0].value;
        var endday = document.getElementsByName("_submit")[2].value;
        var endtime = document.getElementsByName("_submit")[3].value;
        var chepai = document.getElementById("guijichepai").value;
        loadJScript();
        guiji(startday, starttime, endday, endtime, chepai);
    }
    function kaishi() {
        int = self.setInterval("yidong()", 1000);
    }
    function tingzhi() {
        window.clearInterval(int);
    }
    function chongzhi() {
        window.clearInterval(int);
        time = 0;
    }
</script>