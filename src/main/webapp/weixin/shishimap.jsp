<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
//    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String xiugaibancheid = request.getParameter("xiugaibancheid");//用request得到
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?f1a41121ab2caeaa7034b233b3d2a88a";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>实时地图</title>
    <script type="application/javascript" src="../js/jquery-2.1.4.min.js"></script>
    <%--<script type="text/javascript"--%>
            <%--src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>--%>
    <%--<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>--%>
    <script type="text/javascript" src="http://api.map.baidu.com/api?type=quick&v=1.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW"></script>
    <script type="application/javascript" src="../js/xianluajax.js"></script>
    <style type="text/css">
        body {
            padding: 0;
            margin: 0
        }
        .head_top {
            background-color: #40403e;
            font-size: 22px;
            width: 100%;
            height: 63px;
            line-height: 22px;
        }

        .head_left {
            width: 15%;
            padding-left: 10%;
            display: inline-block;
            vertical-align: middle;
        }

        .head_right {
            width: 50%;
            text-align: center;
            display: inline-block;
            text-align: center;
        }
    </style>
</head>
<body style="background: #d8dbe0;">
<input type="hidden" id="xiugaibancheid" name="xiugaibancheid" value="<%=xiugaibancheid%>"/>
<div class="contant">
    <div style="">
        <div class="head_top">
            <div class="head_left"  style="float: left;padding-top: 20px;">
                <img src="../images/fanhui.png" onclick="window.history.back()"/>
            </div>
            <div class="head_right" style="float: left;padding-top: 20px;margin:0 auto;text-align: center;">
                <font color="#FFFFFF" >实时地图</font>
            </div>
        </div>
<div id="showText"
     style="margin-left:15px;background: #e7e7e7;margin-right: 15px"></div>
        <div id="allmap"
             style="width: 94%;height: 500px;margin-left: 3%;margin-right: 3%;margin-top: 5px;margin-bottom: 5px;border: 1px solid #c0c0c0;"></div>
</body>
</html>

<script type="text/javascript">
//    alert(document.getElementById("allmap").style.height);
//        document.getElementById("allmap").style.height = window.screen.height +"px";
    var map;
    var int;
    var opts = {
        width: 250,     // 信息窗口宽度
        height: 100,     // 信息窗口高度
        title: "信息", // 信息窗口标题
        enableMessage: true//设置允许信息窗发送短息
    };
    var tjd = document.getElementsByName("tjingdu");
    var twd = document.getElementsByName("tweidu");
    var tnm = document.getElementsByName("tname");
    var tms = document.getElementsByName("tmiaoshu");
    var tyc = document.getElementsByName("tyincang");

    var tclnm = document.getElementsByName("tclname");
    var tclsb = document.getElementsByName("tclshebei");
    var tcldz = document.getElementsByName("tcldaozhan");

    var tsbsb = document.getElementsByName("tsbshebei");
    var tsbjd = document.getElementsByName("tsbjd");
    var tsbwd = document.getElementsByName("tsbwd");
    var thebancheid = 20;
    var loadceshu = 0;
    var infoWindow;
    function loadJScript(xianluid) {
        thebancheid  = xianluid;
        if (loadceshu == 0) {
            var script = document.createElement("script");
            script.type = "text/javascript";
//        script.src = "http://api.map.baidu.com/api?v=2.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW&callback=init(" + xianluid + ",'" +xianluname + "')";
            script.src = "http://api.map.baidu.com/api?type=quick&v=1.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW&callback=init(" + xianluid + ")";
            document.body.appendChild(script);
            loadceshu++;
        }
    }
    function init(xianluid) {


        var zuishang = 1;
        var zuixia = 1;
        var zuizuo = 1;
        var zuiyou = 1;
        var maxjingdu = 116.00;
        var minjingdu = 117.00;
        var maxweidu = 39.00;
        var minweidu = 40.00;
        for (var i = 0; i < tjd.length; i++) {
            if (tjd[i].value > maxjingdu) {
                maxjingdu = tjd[i].value;
                zuiyou = i;
            }
            if (tjd[i].value < minjingdu) {
                minjingdu = tjd[i].value;
                zuizuo = i;
            }
            if (twd[i].value > maxweidu) {
                maxweidu = twd[i].value;
                zuishang = i;
            }
            if (twd[i].value < minweidu) {
                minweidu = twd[i].value;
                zuixia = i;
            }
        }

        var pointshang = new BMap.Point(tjd[zuishang].value, twd[zuishang].value);
        var pointxia = new BMap.Point(tjd[zuixia].value, twd[zuixia].value);
        var pointzuo = new BMap.Point(tjd[zuizuo].value, twd[zuizuo].value);
        var pointyou = new BMap.Point(tjd[zuiyou].value, twd[zuiyou].value);
        map = new BMap.Map("allmap");// 创建Map实例
        var point = new BMap.Point((parseFloat(tjd[zuishang].value) + parseFloat(tjd[zuixia].value)) / 2, (parseFloat(twd[zuishang].value) + parseFloat(twd[zuixia].value)) / 2); // 创建点坐标
        map.centerAndZoom(point, 15);
        map.setViewport([pointshang, pointxia, pointzuo, pointyou]);
        map.addControl(new BMap.ZoomControl());
        //TODO 定位事件，极速版没有
//        var geolocationControl = new BMap.GeolocationControl();
//        geolocationControl.addEventListener("locationSuccess", function(e){
        // 定位成功事件
//            var address = '';
//            address += e.addressComponent.province;
//            address += e.addressComponent.city;
//            address += e.addressComponent.district;
//            address += e.addressComponent.street;
//            address += e.addressComponent.streetNumber;
//            alert("当前定位地址为：" + address);
//        });
//        geolocationControl.addEventListener("locationError",function(e){
        // 定位失败事件
//            alert(e.message);
//        });
//        map.addControl(geolocationControl);
        refsh();

    }
var chushiclmarker;
    function refsh() {
        map.closeInfoWindow();

//        map.clearOverlays();
        var data_info = [];
        var cheliang_info = [];
        for (var k = 0; k < tjd.length; k++) {        //一维长度为i,i为变量，可以根据实际情况改变
            data_info[k] = new Array();    //声明二维，每一个一维数组里面的一个元素都是一个数组；
            for (var j = 0; j < 3; j++) {      //一维数组里面每个元素数组可以包含的数量p，p也是一个变量；
                data_info[k][j] = "";       //这里将变量初始化，我这边统一初始化为空，后面在用所需的值覆盖里面的值
            }
        }
        for (var o = 0; o < tclnm.length; o++) {        //一维长度为i,i为变量，可以根据实际情况改变
            cheliang_info[o] = new Array();    //声明二维，每一个一维数组里面的一个元素都是一个数组；
            for (var p = 0; p < 3; p++) {      //一维数组里面每个元素数组可以包含的数量p，p也是一个变量；
                cheliang_info[o][p] = "";       //这里将变量初始化，我这边统一初始化为空，后面在用所需的值覆盖里面的值
            }
        }
var flag =0;
        if(ass.length > 0){} else{flag = 1}

//        var ass = [];
        for (i = 0; i < tjd.length; i++) {
            var xx = tjd[i].value;
            var yy = twd[i].value;
            if(flag == 1){
            var gpsPoint = new BMap.Point(xx, yy);
            ass.push(gpsPoint);}
        }
        for (i = 0; i < tjd.length; i++) {
            if (tyc[i].value == ("1")) {
                data_info[i][0] = tjd[i].value;
                data_info[i][1] = twd[i].value;
                data_info[i][2] = "班车站点：" + tnm[i].value + "<br/>" + "停靠位置：" + tms[i].value;
            } else {
                data_info[i][0] = 0;
                data_info[i][1] = 0;
                data_info[i][2] = 0;
            }
        }

        for (i = 0; i < tclnm.length; i++) {
            xx = tclsb[i].value;
            for (j = 0; j < tsbsb.length; j++) {
                if (xx == tsbsb[j].value) {
                    cheliang_info[i][0] = tsbjd[j].value;
                    cheliang_info[i][1] = tsbwd[j].value;
                    if (tcldz[i].value == "即将到站") {
                        cheliang_info[i][2] = tclnm[i].value + "<br/>" + tcldz[i].value;
                    } else {
                        cheliang_info[i][2] = tclnm[i].value + "<br/>" + "还有" + tcldz[i].value + "分钟到站";
                    }
                }
            }
        }
        var polyline = new BMap.Polyline(
                ass
                , {strokeColor: "#a3b8eb", strokeWeight: 6, strokeOpacity: 1});   //创建折线
        map.addOverlay(polyline);

        var myzhandianIcon = new BMap.Icon("http://123.57.61.220:80/Banche/images/theding.png", new BMap.Size(45, 45), {imageOffset: new BMap.Size(15, 0)});
        for (var i = 0; i < data_info.length; i++) {
            if (data_info[i][0] == 0) {
            } else {
                var marker = new BMap.Marker(new BMap.Point(data_info[i][0], data_info[i][1]),{icon:myzhandianIcon});  // 创建标注
                var content = data_info[i][2];
                map.addOverlay(marker);               // 将标注添加到地图中
                addClickHandler(content, marker);
            }
        }
        var myIcon = new BMap.Icon("http://123.57.61.220:80/Banche/images/jiache.png", new BMap.Size(30, 80), {imageOffset: new BMap.Size(10, 20)});

        for (i = 0; i < cheliang_info.length; i++) {
            chushiclmarker = new BMap.Marker(new BMap.Point(cheliang_info[i][0], cheliang_info[i][1]), {icon: myIcon});  // 创建标注
//            marker = new BMap.Marker(new BMap.Point(cheliang_info[i][0], cheliang_info[i][1]));  // 创建标注
            content = cheliang_info[i][2];
            map.addOverlay(chushiclmarker);               // 将标注添加到地图中
            addClickHandler(content, chushiclmarker);
        }
//
        function addClickHandler(content, marker) {
            marker.addEventListener("click", function (e) {
                        var p = e.target;
                        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                        infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
                        map.openInfoWindow(infoWindow, point); //开启信息窗口
                    }
            );
        }
    }
var clmarker;
function refshcl() {
    var cheliang_info = [];
    for (var o = 0; o < tclnm.length; o++) {        //一维长度为i,i为变量，可以根据实际情况改变
        cheliang_info[o] = new Array();    //声明二维，每一个一维数组里面的一个元素都是一个数组；
        for (var p = 0; p < 3; p++) {      //一维数组里面每个元素数组可以包含的数量p，p也是一个变量；
            cheliang_info[o][p] = "";       //这里将变量初始化，我这边统一初始化为空，后面在用所需的值覆盖里面的值
        }
    }
    for (i = 0; i < tclnm.length; i++) {
        var xx = tclsb[i].value;
        for (j = 0; j < tsbsb.length; j++) {
            if (xx == tsbsb[j].value) {
                cheliang_info[i][0] = tsbjd[j].value;
                cheliang_info[i][1] = tsbwd[j].value;
                if (tcldz[i].value == "即将到站") {
                    cheliang_info[i][2] = tclnm[i].value + "<br/>" + tcldz[i].value;
                } else {
                    cheliang_info[i][2] = tclnm[i].value + "<br/>" + "还有" + tcldz[i].value + "分钟到站";
                }
            }
        }
    }
    var myIcon = new BMap.Icon("http://123.57.61.220:80/Banche/images/jiache.png", new BMap.Size(30, 80), {imageOffset: new BMap.Size(10, 20)});

    for (i = 0; i < cheliang_info.length; i++) {
        clmarker = new BMap.Marker(new BMap.Point(cheliang_info[i][0], cheliang_info[i][1]), {icon: myIcon});  // 创建标注
//            marker = new BMap.Marker(new BMap.Point(cheliang_info[i][0], cheliang_info[i][1]));  // 创建标注
        content = cheliang_info[i][2];
        map.addOverlay(clmarker);               // 将标注添加到地图中
        addClickHandler(content, clmarker);
    }
//
    function addClickHandler(content, marker) {
        marker.addEventListener("click", function (e) {
                    var p = e.target;
                    var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                    infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
                    map.openInfoWindow(infoWindow, point); //开启信息窗口
                }
        );
    }

}
    //
var aa = document.getElementById('xiugaibancheid').value;
     window.onload = test(aa);
     //异步加载地图
//    window.onload = loadJScript;
</script>
