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
    <s:param name="test">changgongsi</s:param>
</s:include>
<div class="admin">
    <form action="changcompany.action?searchcompany=1" method="post">
        公司名称：<input type="text" id="searchcomdetname" name="searchcomdetname"/>
        <br/>
        <input type="submit" value="搜索"/>

    </form>
    <s:iterator value="comdets">
        公司名称：<s:property value="comdetName"></s:property>
        公司地址：<s:property value="comdetDizhi"></s:property>
        公司联系人：<s:property value="comdetLianxiren"></s:property>
        联系电话：<s:property value="comdetLianxitele"></s:property>
        <input type="button" value="删除"
               onclick="document.location='changcompany.action?searchcompany=2&xiugaicomdetid=<s:property
                       value="comdetId"></s:property>'"/>
        <input type="button" value="修改"
               onclick="document.location='changcompany.action?searchcompany=3&xiugaicomdetid=<s:property
                       value="comdetId"></s:property>'"/>
    </s:iterator>
</div>

</body>
</html>
