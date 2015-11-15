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
<s:set name="cuowumessage" value="cuowumessage"></s:set>
<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">addcheci</s:param>
</s:include>
<div class="admin">
    <s:if test="cuowumessage == null">
        <form action="addcheci.action" method="post">
            线路ID：<input type="text" id="bancheId" name="bancheId"/>
            <br/>
            车辆ID：<input type="text" id="cheliangId" name="cheliangId"/>
            <br/>
            <input type="submit" value="保存"/>
        </form>
    </s:if>
    <s:else>
        <s:property value="cuowumessage"></s:property>
        <br/>
        <input type="button" name="button" value="返回添加"
               onclick="location.href='addcheci.jsp'"/>
    </s:else>
</div>
</body>
</html>
