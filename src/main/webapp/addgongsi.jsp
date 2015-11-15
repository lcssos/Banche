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
</head>

<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">addgongsi</s:param>
</s:include>
<div class="admin">
    <form action="addcompany.action" method="post">
        公司名称：<input type="text" id="addcomdetname" name="addcomdetname"/>
        <br/>
        公司简介：<input type="text" id="addcomdetjianjie" name="addcomdetjianjie"/>
        <br/>
        公司地址：<input type="text" id="addcomdetaddress" name="addcomdetaddress"/>
        <br/>
        公司联系人：<input type="text" id="addcompanylxname" name="addcompanylxname"/>
        <br/>
        联系电话：<input type="text" id="addcompanylxtele" name="addcompanylxtele"/>
        <br/>
        用户名：<input type="text" id="addcompanyname" name="addcompanyname"/>
        <br/>
        密码：<input type="text" id="addcompanypass" name="addcompanypass"/>
        <br/>
        <input type="submit" value="提交"/>
    </form>
</div>

</body>
</html>
