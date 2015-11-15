<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String openId = request.getParameter("openId");//用request得到
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>后台管理-后台管理</title>
    <script type="application/javascript" src="../js/jquery-2.1.4.min.js"></script>
    <script type="application/javascript" src="../js/fujinzdajax.js"></script>
</head>
<body style="background: #d8dbe0;">
        <%--<input type="hidden" id="wxopenId" name="wxopenId" value="<%=openId%>"/>--%>
        <input type="hidden" id="wxopenId" name="wxopenId" value="ol-XJwr-LwhyQcHFnfxQQkyl4v5o"/>
        <div id="showText"></div>
        <div id="allmap" style="height:300px;"></div>
</body>
</html>

<script type="text/javascript">
    var map;
    function loadJScript() {
            var script = document.createElement("script");
            script.type = "text/javascript";
//        script.src = "http://api.map.baidu.com/api?v=2.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW&callback=init(" + xianluid + ",'" +xianluname + "')";
            script.src = "http://api.map.baidu.com/api?type=quick&v=1.0&ak=RMhB2Fq8pYX0K2R2H84bGyEW&callback=init()";
            document.body.appendChild(script);
    }
    function init() {
        map = new BMap.Map("allmap");
//        map.centerAndZoom("北京", 13);
        map.addControl(new BMap.ZoomControl());
fujinzd(request('openId'));
    }
    window.onload = loadJScript;
    function request(strParame) {
        var args = new Object( );
        var query = location.search.substring(1);

        var pairs = query.split("&"); // Break at ampersand
        for(var i = 0; i < pairs.length; i++) {
            var pos = pairs[i].indexOf('=');
            if (pos == -1) continue;
            var argname = pairs[i].substring(0,pos);
            var value = pairs[i].substring(pos+1);
            value = decodeURIComponent(value);
            args[argname] = value;
        }
        return args[strParame];
    }
</script>
