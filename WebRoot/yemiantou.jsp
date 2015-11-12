<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("myparam", request.getParameter("test")); %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="righter nav-navicon" id="admin-nav">
    <div class="mainer">
        <div class="admin-navbar">
            <span class="float-right">
            	<a class="button button-little bg-main" href="#" target="_blank">前台首页</a>
                <a class="button button-little bg-yellow" href="denglu.action?tuichu=1">注销登录</a>
            </span>
            <ul class="nav nav-inline admin-nav">
                <s:if test="#attr.myparam.equals('kaishi')">
                    <li class="active"><a href="index.jsp" class="icon-home"> 开始</a>
                        <ul>
                            <li class="active"><a href="addbanche.jsp">班车管理</a></li>
                            <li><a href="addcheliang.jsp">车辆管理</a></li>
                            <li><a href="changzhandian.jsp">站点管理</a></li>
                            <li><a href="addshebei.jsp">设备管理</a></li>
                            <li><a href="addgongsi.jsp">公司管理</a></li>
                        </ul>
                    </li>
                </s:if>
                <s:else>
                <li><a href="index.jsp" class="icon-home"> 开始</a>
                    </s:else>
                    <s:if test="#attr.myparam.equals('addbanche')">
                <li class="active"><a href="addbanche.jsp" class="icon-cog"> 班车管理</a>
                    <ul>
                        <li class="active"><a href="addbanche.jsp">新增班车</a></li>
                        <li><a href="changbanche.jsp">修改班车</a></li>
                    </ul>
                </li>
                </s:if>
                <s:elseif test="#attr.myparam.equals('changbanche')">
                    <li class="active"><a href="addbanche.jsp" class="icon-cog"> 班车管理</a>
                        <ul>
                            <li><a href="addbanche.jsp">新增班车</a></li>
                            <li class="active"><a href="changbanche.jsp">修改班车</a></li>
                        </ul>
                    </li>
                </s:elseif>
                <s:else>
                    <li><a href="addbanche.jsp" class="icon-cog"> 班车管理</a>
                    </li>
                </s:else>

                <s:if test="#attr.myparam.equals('addcheliang')">
                    <li class="active"><a href="addcheliang.jsp" class="icon-file-text"> 车辆管理</a>
                        <ul>
                            <li class="active"><a href="addcheliang.jsp">新增车辆</a></li>
                            <li><a href="changcheliang.jsp">修改车辆</a></li>
                        </ul>
                    </li>
                </s:if>
                <s:elseif test="#attr.myparam.equals('changcheliang')">
                    <li class="active"><a href="addcheliang.jsp" class="icon-file-text"> 车辆管理</a>
                        <ul>
                            <li><a href="addcheliang.jsp">新增车辆</a></li>
                            <li class="active"><a href="changcheliang.jsp">修改车辆</a></li>
                        </ul>
                    </li>
                </s:elseif>
                <s:else>
                    <li><a href="addcheliang.jsp" class="icon-file-text"> 车辆管理</a>
                    </li>
                </s:else>

                <s:if test="#attr.myparam.equals('zhandian')">
                    <li class="active"><a href="changzhandian.jsp" class="icon-shopping-cart"> 站点管理</a>
                        <ul>
                            <li class="active"><a href="changzhandian.jsp">修改站点</a></li>
                        </ul>
                    </li>
                </s:if>
                <s:else>
                    <li><a href="changzhandian.jsp" class="icon-shopping-cart"> 站点管理</a>

                    </li>
                </s:else>

                <s:if test="#attr.myparam.equals('addshebei')">
                    <li class="active"><a href="addshebei.jsp" class="icon-shopping-cart"> 设备管理 </a>
                        <ul>
                            <li class="active"><a href="addshebei.jsp">新增设备</a></li>
                            <li><a href="changshebei.jsp">修改设备</a></li>
                        </ul>
                    </li>
                </s:if>
                <s:elseif test="#attr.myparam.equals('changshebei')">
                    <li class="active"><a href="addshebei.jsp" class="icon-shopping-cart"> 设备管理 </a>
                        <ul>
                            <li><a href="addshebei.jsp">新增设备</a></li>
                            <li class="active"><a href="changshebei.jsp">修改设备</a></li>
                        </ul>
                    </li>
                </s:elseif>
                <s:else>
                    <li><a href="addshebei.jsp" class="icon-shopping-cart"> 设备管理 </a>
                    </li>
                </s:else>

                <s:if test="#attr.myparam.equals('addgongsi')">
                    <li class="active"><a href="addgongsi.jsp" class="icon-shopping-cart"> 公司管理 </a>
                        <ul>
                            <li class="active"><a href="addgongsi.jsp">新增公司</a></li>
                            <li><a href="changcompany.jsp">修改公司</a></li>
                        </ul>
                    </li>
                </s:if>
                <s:elseif test="#attr.myparam.equals('changgongsi')">
                    <li class="active"><a href="addgongsi.jsp" class="icon-shopping-cart"> 公司管理 </a>
                        <ul>
                            <li><a href="addgongsi.jsp">新增公司</a></li>
                            <li class="active"><a href="changcompany.jsp">修改公司</a></li>
                        </ul>
                    </li>
                </s:elseif>
                <s:else>
                    <li><a href="addgongsi.jsp" class="icon-shopping-cart"> 公司管理 </a>
                    </li>
                </s:else>

            </ul>
        </div>
        <div class="admin-bread">
            <span>您好，<%=request.getSession().getAttribute("username")%>，欢迎您的光临。</span>
            <ul class="bread">
                <li><a href="index.jsp" class="icon-home"> 开始</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
