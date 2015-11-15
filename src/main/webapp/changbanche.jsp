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
    <s:param name="test">changbanche</s:param>
</s:include>
<div class="admin">
    <form action="changbanche.action?searchbanche=1" method="post">
        班车名称：<input type="text" id="searchbanchename" name="searchbanchename"/>
        <br/>
        班车状态：<select id="myselect">
        <option selected="selected" value="1">启用</option>
        <option value="0">停用</option>
    </select>
        <input type="hidden" id="searchbanchezhuangtai" name="searchbanchezhuangtai"/>
        <input type="hidden" id="searchform" name="searchform" value="1"/>
        <%--<input type="hidden" id="searchbanche" name="searchbanche" value="1"/>--%>
        <input type="submit" value="搜索" onclick="getSltValue()"/>
        <br/>
        <script type="text/javascript">
            function getSltValue() {
                document.getElementById("searchbanchezhuangtai").value = document.getElementById("myselect").value;
            }
        </script>
    </form>
    <s:iterator value="banches">
        班车名称：<s:property value="bancheName"></s:property>
        班车简介：<s:property value="bancheJieshao"></s:property>
        间隔时间：<s:property value="bancheJiange"></s:property>
        全程时间：<s:property value="bancheQuancheng"></s:property>
        运行时间：<s:property value="bancheYunxingtime"></s:property>
        工作时间：<s:property value="bancheTime"></s:property>
        <s:if test="bancheStatus == 1">
            班车状态:<select id="myselect1">
            <option selected="selected" value="1">启用</option>
            <option value="0">停用</option>
            </select>
        </s:if>
        <s:else>
            班车状态:<select id="myselect1">
            <option value="1">启用</option>
            <option selected="selected" value="0">停用</option>
            </select>
        </s:else>
        <input type="button" value="删除"
               onclick="document.location='changbanche.action?searchbanche=3&xiugaibancheid=<s:property
                       value="bancheId"></s:property>'"/>
        <input type="button" value="修改状态"
               onclick="document.location='changbanche.action?searchbanche=2&xiugaibanchestatus=<s:property
                       value="bancheStatus"></s:property>&xiugaibancheid=<s:property value="bancheId"></s:property>'"/>
        <input type="button" value="修改"
               onclick="document.location='changbanche.action?searchbanche=4&xiugaibancheid=<s:property
                       value="bancheId"></s:property>'"/>
        </br>
    </s:iterator>
</div>

</body>
</html>
