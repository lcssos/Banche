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
    <s:param name="test">changbanche</s:param>
</s:include>
<div class="admin">
    <form action="changbanche.action?searchbanche=5" method="post" enctype="multipart/form-data">
        <s:iterator value="banches">
            班车名称：<input type="text" id="xiugaibanchename" name="xiugaibanchename" value="<s:property
                value="bancheName"></s:property>" />
            <br/>
            班车简介：<input type="text" id="xiugaibanchejianjie" name="xiugaibanchejianjie" value="<s:property
                value="bancheJieshao"></s:property>" />
            <br/>
            间隔时间：<input type="text" id="xiugaibanchejiange" name="xiugaibanchejiange" value="<s:property
                value="bancheJiange"></s:property>" />
            <br/>
            全程时间：<input type="text" id="xiugaibanchequancheng" name="xiugaibanchequancheng" value="<s:property
                value="bancheQuancheng"></s:property>" />
            <br/>
            运行时间：<input type="text" id="xiugaibancheyunxing" name="xiugaibancheyunxing" value="<s:property
                value="bancheYunxingtime"></s:property>" />
            <br/>
            工作时间：<input type="text" id="xiugaibanchetime" name="xiugaibanchetime" value="<s:property
                value="bancheTime"></s:property>" />
            <br/>
            <s:if test="bancheStatus == 1">
                班车状态:<select id="myselect">
                <option selected="selected" value="1">启用</option>
                <option value="0">停用</option>
                </select>
            </s:if>
            <s:else>
                班车状态:<select id="myselect">
                <option value="1">启用</option>
                <option selected="selected" value="0">停用</option>
                </select>
            </s:else>
            <br/>
            实际路线开始日期：<input type="text" id="xiugaibcstartday" name="xiugaibcstartday" value="<s:property value="bancheStartday"></s:property>"/>
            实际路线开始时间：<input type="text" id="xiugaibcstarttime" name="xiugaibcstarttime" value="<s:property value="bancheStarttime"></s:property>"/>
            实际路线停止日期：<input type="text" id="xiugaibcendday" name="xiugaibcendday" value="<s:property value="bancheEndday"></s:property>"/>
            实际路线停止时间：<input type="text" id="xiugaibcendtime" name="xiugaibcendtime" value="<s:property value="bancheEndtime"></s:property>"/>
            <input type="hidden" id="xiugaibczhuangtai" name="xiugaibczhuangtai"/>
            <input type="hidden" id="xiugaibancheid" name="xiugaibancheid"
                   value="<s:property value="bancheId"></s:property>"/>
            <input type="submit" value="保存" onclick="getSltValue()"/>
            <script type="text/javascript">
                function getSltValue() {
                    document.getElementById("xiugaibczhuangtai").value = document.getElementById("myselect").value;
                }
            </script>
            </br>
        </s:iterator>
    </form>
</div>

</body>
</html>
