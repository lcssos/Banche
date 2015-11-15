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
    <s:param name="test">zhandian</s:param>
</s:include>
<div class="admin">
    <s:if test="cuowumessage == null">
        <form action="changbanche.action?searchbanche=1" method="post">
            班车名称：<input type="text" id="searchbanchename" name="searchbanchename"/>
            <br/>
            班车状态：<select id="myselect">
            <option selected="selected" value="1">启用</option>
            <option value="0">停用</option>
        </select>
            <input type="hidden" id="searchbanchezhuangtai" name="searchbanchezhuangtai"/>
            <input type="submit" value="搜索" onclick="getSltValue()"/>
            <script type="text/javascript">
                function getSltValue() {
                    document.getElementById("searchbanchezhuangtai").value = document.getElementById("myselect").value;
                }
            </script>
        </form>
        <s:iterator value="banches">
            班车名称：<s:property value="bancheName"></s:property>
            运营时间：<s:property value="bancheYunxingtime"></s:property>
            间隔时间：<s:property value="bancheJiange"></s:property>
            全程时间：<s:property value="bancheQuancheng"></s:property>
            工作时间：<s:property value="bancheTime"></s:property>
            <s:if test="bancheStatus == 1">
                启用
                <input type="button" value="修改站点"
                       onclick="document.location='changzhandian.action?searchzhandian=1&xiugaibancheid=<s:property
                               value="bancheId"></s:property>'"/>
                <br/>
            </s:if>
            <s:else>
                停用
                <input type="button" value="修改站点"
                       onclick="document.location='changzhandian.action?searchzhandian=1&xiugaibancheid=<s:property
                               value="bancheId"></s:property>'"/>
                <br/>
            </s:else>
        </s:iterator>
    </s:if>
    <s:else>
        <s:property value="cuowumessage"></s:property>
        <br/>
        <input type="button" name="button" value="返回添加"
               onclick="location.href='changzhandian.jsp'"/>
    </s:else>
</div>

</body>
</html>
