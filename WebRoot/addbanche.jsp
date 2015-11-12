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
    <script type="application/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>
<link rel="stylesheet" href="css/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="css/easyui/themes/icon.css"/>
    <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>

<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">addbanche</s:param>
</s:include>
<form action="addbanche.action" method="post" id="addbanche" name="addbanche">
    <div class="admin">
        班车名称：<input type="text"  class="easyui-textbox" id="addbanchename" name="addbanchename"/>
        <br/>
        班车简介：<input type="text"  class="easyui-textbox" id="addbanchejianjie" name="addbanchejianjie"/>
        <br/>
        间隔时间：<input type="text"  class="easyui-textbox" id="addbanchejiange" name="addbanchejiange"/>
        <br/>
        全程时间：<input type="text"  class="easyui-textbox" id="addbanchequancheng" name="addbanchequancheng"/>
        <br/>
        运行时间：<input type="text"  class="easyui-textbox" id="addbancheyunxingtime" name="addbancheyunxingtime"/>
        <br/>
        工作时间：<input type="text"  class="easyui-textbox" id="addbanchetime" name="addbanchetime"/>
        <br/>
        班车状态:<select  class="easyui-combobox" id="myselect">
        <option value="1">启用</option>
        <option value="0">停用</option>
    </select>
        <input type="hidden" id="addbanchestatus" name="addbanchestatus"/>

        <div id="showText"></div>
        <input type="hidden" id="checkedsd" name="checkedsd"/>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="CreateInput()">新增站点</a>
        <br/>
        <%--<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="check('aaa')">提交</a>--%>
        <%--<input type="button" onclick="CreateInput()" value="新增站点"/> <br/><br/>--%>
        <input type="button" onclick="check('aaa')" value="提交"/>

        <div id="allmap" style="width:500px;height:320px"></div>
    </div>

</form>

</body>
</html>

<script type="text/javascript">
    var jingdu = "";
    var weidu = "";
    var zhandianshu = 1;
    var map;
    //创建 input 文本框
    function CreateInput() {
        map.clearOverlays();
        jingdu = "";
        weidu = "";
        var input = document.createElement("input");
        input.type = "hidden";
        input.id = "jwz" + zhandianshu;
        input.name = "bbb";
        input.value = jingdu + "," + weidu + "," + zhandianshu;
        document.getElementById("showText").appendChild(input);

        document.getElementById("showText").appendChild(document.createTextNode("站点名称："));
        var input2 = document.createElement("input");
        input2.type = "text";
        input2.name = "ccc";
        input2.placeholder = "请填写站点名称";
        document.getElementById("showText").appendChild(input2);

        document.getElementById("showText").appendChild(document.createTextNode("站点地址："));
        var input3 = document.createElement("input");
        input3.type = "text";
        input3.id = "dizhi" + zhandianshu;
        input3.name = "dizhi";
        input3.placeholder = "请填写站点地址";
        document.getElementById("showText").appendChild(input3);

        document.getElementById("showText").appendChild(document.createTextNode("站点描述："));
        var input4 = document.createElement("input");
        input4.type = "text";
        input4.name = "miaoshu";
        input4.placeholder = "请填写站点描述";
        document.getElementById("showText").appendChild(input4);

        document.getElementById("showText").appendChild(document.createTextNode("预计到站："));
        var input5 = document.createElement("input");
        input5.type = "text";
        input5.name = "daozhan";
        input5.placeholder = "请填写预计到站时间，以逗号分隔";
        document.getElementById("showText").appendChild(input5);

        document.getElementById("showText").appendChild(document.createTextNode("是否隐藏："));
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.name = "aaa";
        document.getElementById("showText").appendChild(checkbox);

        var button = document.createElement("input");
        button.type = "button";
        button.value = "添加站点";
        button.setAttribute("onClick", "dizhizhuanhuan(" + zhandianshu + ")");
        document.getElementById("showText").appendChild(button);

        var br = document.createElement("br");
        document.getElementById("showText").appendChild(br);
        zhandianshu += 1;
    }
    function dizhizhuanhuan(shuzi) {

        var myGeo = new BMap.Geocoder();
        var dizhi = document.getElementById("dizhi" + shuzi).value;
        myGeo.getPoint(dizhi, function (point) {
            if (point) {
                map.centerAndZoom(point, 16);
                var marker = new BMap.Marker(point)
                map.addOverlay(marker);
                marker.enableDragging();
                var p = marker.getPosition();
                jingdu = p.lng;
                weidu = p.lat;
                document.getElementById("jwz" + shuzi).value = jingdu + "," + weidu + "," + shuzi;
                marker.addEventListener("dragend", function (e) {
                    p = marker.getPosition();
                    jingdu = p.lng;
                    weidu = p.lat;
                    document.getElementById("jwz" + shuzi).value = jingdu + "," + weidu + "," + shuzi;
                })
            } else {
                alert("您选择地址没有解析到结果!");
            }
        }, "北京市");
    }

    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW&callback=init";
        document.body.appendChild(script);
    }
    function init() {
        map = new BMap.Map("allmap");            // 创建Map实例
        var point = new BMap.Point(116.404, 39.915); // 创建点坐标
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

//        map.addEventListener("click", function (e) {
//            var marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat)); // 创建点
//            map.clearOverlays();
//            map.addOverlay(marker);
//            marker.enableDragging();
//            jingdu = e.point.lng;
//            weidu = e.point.lat;
//
//        });
    }
    function check(obj) {
        var ssf = "";
        for (i = 0; i < document.getElementsByName("aaa").length; i++) {
            if (!document.getElementsByName("aaa").item(i).checked) {
//                alert("第"+(i+1)+"个没有选择")
                ssf = ssf + "1,";
            }
            else {
                ssf = ssf + "0,"
            }
        }
        document.getElementById("addbanchestatus").value = document.getElementById("myselect").value;
        document.getElementById("checkedsd").value = ssf.substring(0, ssf.length - 1);
        document.getElementById("addbanche").submit();
    }
    window.onload = loadJScript;  //异步加载地图
</script>
