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
    <s:param name="test">zhandian</s:param>
</s:include>
<div class="admin">
    <form action="changzhandian.action?searchzhandian=2" method="post">
        <s:iterator value="zhandians">
            站点名称：<s:property value="zhandianName"></s:property>
            站点经度：<s:property value="zhandianJingdu"></s:property>
            站点维度：<s:property value="zhandianWeidu"></s:property>
            <s:if test="zhandianYincang == 1">
                是否隐藏：显示
            </s:if>
            <s:else>
                是否隐藏：隐藏
            </s:else>
            站点序号：<s:property value="zhandianXuhao"></s:property>
            <s:if test="zhandianStatus == 1">
                站点状态：启用
            </s:if>
            <s:else>
                站点状态：停用
            </s:else>
            <input type="button" value="删除"
                   onclick="document.location='changzhandian.action?searchzhandian=4&deletezhandianid=<s:property
                           value="zhandianId"></s:property>'"/>
            <input type="button" value="修改站点"
                   onclick="document.location='changzhandian.action?searchzhandian=2&xiugaizhandianid=<s:property
                           value="zhandianId"></s:property>'"/>
            <br/>
        </s:iterator>
    </form>
</div>

</body>
</html>
