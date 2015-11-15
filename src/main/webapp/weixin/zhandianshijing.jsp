<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>站点列表</title>
    <style>
        body {
            padding: 0;
            margin: 0 auto;
            background-color: #f5f5f5;
        }
        .head_top {
            background-color: #40403e;
            font-size: 22px;
            width: 100%;
            height: 63px;
            line-height: 22px;
        }
        .head_left {
            line-height: 80px;
            padding-left: 10%;
            padding-top: -10px;
            display: inline-block;
            vertical-align: middle;
        }

        .head_right {
            display: inline-block;
            margin-left: 25%;
            padding-top: 20px;
        }
    </style>

</head>
<meta name="viewport"
      content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<meta name="apple-mobile-web-app-capable" content="yes">

<body>

<div class="head_top">
    <div class="head_left">
        <img src="../images/fanhui.png" onclick="window.history.back();"/>
    </div>
    <div class="head_right">
            <font color="#FFFFFF">实景地图</font>
    </div>
    </div>
<s:iterator value="zhandians">
    <s:if test="zhandianImage != null">
    <img style="width: 100%" src="<s:property value="zhandianImage"></s:property>" alt="sdf"/>
    </s:if>
    <s:property value="zhandianMiaoshu"></s:property>
</s:iterator>
</body>
</html>
