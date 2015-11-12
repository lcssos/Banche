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

</head>

<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">changgongsi</s:param>
</s:include>
<div class="admin">
    <form action="changcompany.action?searchbanche=4" method="post">
        <s:iterator value="comdets">
            公司名称：<input type="text" id="xiugaicomdetname" name="xiugaicomdetname" value="<s:property
                value="comdetName"></s:property>"/>
            <br/>
            公司简介：<input type="text" id="xiugaicomdetjianjie" name="xiugaicomdetjianjie" value="<s:property
                value="comdetJianjie"></s:property>"/>
            <br/>
            公司地址：<input type="text" id="xiugaicomdetxiugairess" name="xiugaicomdetxiugairess" value="<s:property
                value="comdetDizhi"></s:property>"/>
            <br/>
            公司联系人：<input type="text" id="xiugaicompanylxname" name="xiugaicompanylxname" value="<s:property
                value="comdetLianxiren"></s:property>"/>
            <br/>
            联系电话：<input type="text" id="xiugaicompanylxtele" name="xiugaicompanylxtele" value="<s:property
                value="comdetLianxitele"></s:property>"/>
            <br/>
        </s:iterator>
        <s:iterator value="companies">
            用户名：<input type="text" id="xiugaicompanyname" name="xiugaicompanyname" value="<s:property
                value="companyName"></s:property>"/>
            <br/>
            密码：<input type="text" id="xiugaicompanypass" name="xiugaicompanypass" value="<s:property
                value="companyPassword"></s:property>"/>
            <br/>
            <input type="hidden" id="xiugaicomdetid" name="xiugaicomdetid"
                   value="<s:property value="comdetId"></s:property>"/>
            <input type="submit" value="提交"/>
        </s:iterator>
    </form>
</div>

</body>
</html>
