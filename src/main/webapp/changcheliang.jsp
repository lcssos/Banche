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
    <s:param name="test">changcheliang</s:param>
</s:include>

<div class="admin">
    <s:if test="cuowumessage == null">
        <form action="changcheliang.action" method="post" id="sdf">
            <input type="hidden" id="searchcheliang" name="searchcheliang" value="1"/>
            车牌号：<input type="text" id="searchclchepai" name="searchclchepai"/>
            <br/>
            设备ID：<input type="text" id="searchclshebeiid" name="searchclshebeiid"/>
            <input type="submit" value="搜索"/>
        </form>
        <s:iterator value="cheliangs">
            车牌号：<s:property value="cheliangChepai"></s:property>
            <input type="button" value="删除"
                   onclick="document.location='changcheliang.action?searchcheliang=4&deletecheliangid=<s:property
                           value="cheliangId"></s:property>'"/>
            <input type="button" value="修改"
                   onclick="document.location='changcheliang.action?searchcheliang=2&xiugaiclchepai=<s:property
                           value="cheliangChepai"></s:property>'"/>
            <br/>
        </s:iterator>
    </s:if>
    <s:else>
        <s:property value="cuowumessage"></s:property>
        <br/>
        <input type="button" name="button" value="返回修改"
               onclick="location.href='changcheliang.jsp'"/>
    </s:else>
</div>

</body>
</html>
