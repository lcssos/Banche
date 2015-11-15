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
    <s:param name="test">changshebei</s:param>
</s:include>
<div class="admin">
    <s:if test="cuowumessage == null">
        <form action="changshebei.action?searchshebei=1" method="post">
            设备ID：<input type="text" id="searchsheibeiid" name="searchsheibeiid"/>
            <br/>
            设备状态：<select id="myselect">
            <option value="1">启用</option>
            <option value="0">停止</option>
        </select>
            <input type="hidden" id="searchshebeizhuangtai" name="searchshebeizhuangtai"/>
            <input type="submit" value="搜索" onclick="getSltValue()"/>
            <script type="text/javascript">
                function getSltValue() {
                    document.getElementById("searchshebeizhuangtai").value = document.getElementById("myselect").value;
                }
            </script>
        </form>
        <s:iterator value="shebeis">
            设备ID：<s:property value="shebeishuxingShebeiid"></s:property>
            <%--设备经度：<s:property value="shebeiJingdu"></s:property>--%>
            <%--设备纬度：<s:property value="shebeiWeidu"></s:property>--%>
            <s:if test="shebeishuxingShebeistatus == 1">
                开启
            </s:if>
            <s:else>
                关闭
            </s:else>
            设备手机号：<s:property value="shebeishuxingShoujihao"></s:property>
            <%--<input type="button" value="删除" onclick="document.location='changshebei.action?deleteshebeiid=<s:property--%>
            <%--value="shebeiId"></s:property>&searchshebei=2'"/>--%>
            <input type="button" value="修改状态" onclick="document.location='changshebei.action?deleteshebeiid=<s:property
                    value="shebeishuxingShebeiid"></s:property>&searchshebei=3&updatestatus=<s:property
                    value="shebeishuxingShebeistatus"></s:property>'"/>
            <br/>

        </s:iterator>
    </s:if>
    <s:else>
        <s:property value="cuowumessage"></s:property>
        <br/>
        <input type="button" name="button" value="返回修改"
               onclick="location.href='changshebei.jsp'"/>
    </s:else>
</div>

</body>
</html>
