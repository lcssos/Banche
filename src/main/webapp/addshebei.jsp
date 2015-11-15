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
    <s:param name="test">addshebei</s:param>
</s:include>

<div class="admin">
    <form action="addshebei.action" method="post">
        设备ID：<input type="text" id="addsheibeiid" name="addsheibeiid"/>
        <br/>
        手机号：<input type="text" id="addshebeishoujihao" name="addshebeishoujihao"/>
        <br/>
        设备状态：<select id="myselect">
        <option value="1">启用</option>
        <option value="0">停止</option>
    </select>
        <input type="hidden" id="addshebeizhuangtai" name="addshebeizhuangtai"/>
        <input type="submit" value="保存" onclick="getSltValue()"/>
        <script type="text/javascript">
            function getSltValue() {
                document.getElementById("addshebeizhuangtai").value = document.getElementById("myselect").value;
            }
        </script>
    </form>
</div>

</body>
</html>
