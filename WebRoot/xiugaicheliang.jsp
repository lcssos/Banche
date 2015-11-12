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
    <script type="text/javascript"
            src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>

</head>
<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">changcheliang</s:param>
</s:include>
<div class="admin">
    <form action="changcheliang.action" method="post" enctype="multipart/form-data">
        <s:iterator value="cheliangs">
            <input type="hidden" id="searchcheliang" name="searchcheliang" value="3"/>
            <input type="hidden" id="xiugaicheliangid" name="xiugaicheliangid"
                   value="<s:property value="cheliangId"></s:property>"/>
            车牌号：<input type="text" id="xiugaichepai" name="xiugaichepai"
            value="<s:property value="cheliangChepai"></s:property>"/>
            <br/>
            车型：<input type="text" id="xiugaichexing" name="xiugaichexing"
            value="<s:property value="cheliangChexing"></s:property>"/>
            <br/>
            车龄：<input type="text" id="xiugaicheling" name="xiugaicheling"
            value="<s:property value="cheliangCheling"></s:property>"/>
            <br/>
            座位数：<input type="text" id="xiugaizuoweishu" name="xiugaizuoweishu"
            value="<s:property value="cheliangZuoweishu"></s:property>"/>
            <br/>
            驾驶员姓名：<input type="text" id="xiugaijiashiyuan" name="xiugaijiashiyuan"
            value="<s:property value="cheliangJiashiyuan"></s:property>"/>
            <br/>
            驾驶员联系方式：<input type="text" id="xiugaicltele" name="xiugaicltele"
            value="<s:property value="cheliangTele"></s:property>"/>
            <br/>
            车辆照片：<input type="file" name="upload" id="upload"/>
            <input type="hidden" id="clfilename" name="clfilename"/>
            <br/>
            车上设备：<input type="text" id="xiugaiclshebeiid" name="xiugaiclshebeiid"
            value="<s:property value="shebeiId"></s:property>"/>
            <br/>
            <input type="hidden" id="xiugaiclbancheid" name="xiugaiclbancheid"
            />
            所属线路：<s:select list="banches" listValue="bancheName" listKey="bancheId" value="bancheId" id="myselect"></s:select>
            <input type="submit" value="保存" onclick="getname()"/>
        </s:iterator>
    </form>
    <script type="application/javascript">
        function getname() {
            document.getElementById("clfilename").value = document.getElementById("upload").value;
                    document.getElementById("xiugaiclbancheid").value = document.getElementById("myselect").value;
                }
    </script>
</div>

</body>
</html>