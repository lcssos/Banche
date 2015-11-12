<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>--%>
    <%--<meta name="renderer" content="webkit">--%>
    <title>拼图后台管理-后台管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery-2.1.4.min.js"></script>
</head>

<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">kaishi</s:param>
</s:include>

<div class="admin">
    <input type="button" value="启动GPS接收" onclick="document.location='gpsservice.action'"/>
    <br/>
    <input type="button" value="查看目前提供线路" onclick="location='./weixin/zhanshi2.jsp'"/>
    <br/>
    <input type="button" value="参看轨迹" onclick="location='searchlujing.jsp'"/>
</div>
</body>
</html>


