<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>--%>
    <%--<meta name="renderer" content="webkit">--%>
    <title>后台管理-后台管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>

</head>

<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">zhandian</s:param>
</s:include>
<div class="admin">
    <s:iterator value="zhandians">
        <form action="changzhandian.action?searchzhandian=3&xiugaizhandianid=<s:property value="zhandianId"></s:property>"
              method="post" enctype="multipart/form-data">
            <input type="hidden" id="xiugaizhandianbancheid" name="xiugaizhandianbancheid"
                   value="<s:property value="bancheId"></s:property>"/>
            站点名称：<input type="text" id="xiugaizhandianname" name="xiugaizhandianname"
                        value="<s:property value="zhandianName"></s:property>"/>
            <br/>
            <s:if test="zhandianYincang == 1">
                是否隐藏：<select id="myselect">
                <option selected="selected" value="1">显示</option>
                <option value="0">隐藏</option>
                </select>
            </s:if>
            <s:else>
                是否隐藏：<select id="myselect">
                <option value="1">显示</option>
                <option selected="selected" value="0">隐藏</option>
                </select>
            </s:else>
            <input type="hidden" id="xiugaizhandianyincang" name="xiugaizhandianyincang"/>
            <br/>
                <%--班车ID：<input type="text" id="xiugaizdbancheid" name="xiugaizdbancheid"/>--%>
                <%--<br/>--%>
            站点序列号：<input type="text" id="xiugaizhandianxuhao" name="xiugaizhandianxuhao"
                         value="<s:property value="zhandianXuhao"></s:property>"/>
            <br/>
            <s:if test="zhandianStatus == 1">
                站点状态：<select id="myselect2">
                <option selected="selected" value="1">启用</option>
                <option value="0">停用</option>
                </select>
            </s:if>
            <s:else>
                站点状态：<select id="myselect2">
                <option value="1">启用</option>
                <option selected="selected" value="0">停用</option>
                </select>
            </s:else>
            <input type="hidden" id="xiugaizhandianstatus" name="xiugaizhandianstatus"/>
            <br/>
            站点图片：<input type="file" id="upload" name="upload"/>
            <input type="hidden" id="zdfilename" name="zdfilename"/>
            <br/>
            预计到站时间：<input type="text" id="xiugaizhandianyuji" name="xiugaizhandianyuji" value="<s:property value="zhandianYuji"></s:property>"/>
            <br/>
            <div id="allmap" style="width:500px;height:320px"></div>
            </br>
            <input type="hidden" id="xiugaizhandianjingdu" name="xiugaizhandianjingdu"
                   value="<s:property value="zhandianJingdu"></s:property>"/>
            <input type="hidden" id="xiugaizhandianweidu" name="xiugaizhandianweidu"
                   value="<s:property value="zhandianWeidu"></s:property>"/>
            <input type="submit" value="保存" onclick="getSltValue()"/>
        </form>
    </s:iterator>
</div>

</body>
</html>
<script type="text/javascript">

    var jingdu = document.getElementById("xiugaizhandianjingdu").value;
    var weidu = document.getElementById("xiugaizhandianweidu").value;
    var marker;
    function getSltValue() {
        document.getElementById("zdfilename").value = document.getElementById("upload").value;

        document.getElementById("xiugaizhandianyincang").value = document.getElementById("myselect").value;
        document.getElementById("xiugaizhandianstatus").value = document.getElementById("myselect2").value;
        var p = marker.getPosition();  //获取marker的位置

        document.getElementById("xiugaizhandianjingdu").value = p.lng;
        document.getElementById("xiugaizhandianweidu").value = p.lat;
    }
    //百度地图API功能
    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW&callback=init";
        document.body.appendChild(script);
    }
    function init() {
        var map = new BMap.Map("allmap");            // 创建Map实例
        var point = new BMap.Point(jingdu, weidu); // 创建点坐标
        map.centerAndZoom(point, 15);
        map.enableScrollWheelZoom();                 //启用滚轮放大缩小
        var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
        var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
        var top_right_navigation = new BMap.NavigationControl({
            anchor: BMAP_ANCHOR_TOP_RIGHT,
            type: BMAP_NAVIGATION_CONTROL_SMALL
        }); //右上角，仅包含平移和缩放按钮
        /*缩放控件type有四种类型:
         BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGATION_CONTROL_ZOOM：仅包含缩放按钮*/

        //添加控件和比例尺
        map.addControl(top_left_control);
        map.addControl(top_left_navigation);
        map.addControl(top_right_navigation);
        marker = new BMap.Marker(new BMap.Point(jingdu, weidu)); // 创建点
        map.clearOverlays();
        map.addOverlay(marker);
        marker.enableDragging();
        map.addEventListener("click", function (e) {
//            alert(e.point.lng + "," + e.point.lat);
            marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat)); // 创建点
            map.clearOverlays();
            map.addOverlay(marker);
            marker.enableDragging();
            document.getElementById("xiugaizhandianjingdu").value = e.point.lng;
            document.getElementById("xiugaizhandianweidu").value = e.point.lat;
        });


        var drawingManager = new BMapLib.DrawingManager(map, {
            isOpen: false, //是否开启绘制模式
            enableDrawingTool: true, //是否显示工具栏
            drawingToolOptions: {
                anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
                offset: new BMap.Size(5, 5), //偏离值
                drawingModes: [
                    BMAP_DRAWING_CIRCLE
                ]
            },
        });
    }

    window.onload = loadJScript;  //异步加载地图
</script>