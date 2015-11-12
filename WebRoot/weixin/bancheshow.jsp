<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String xiugaibancheid = request.getParameter("xiugaibancheid");//用request得到
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?f1a41121ab2caeaa7034b233b3d2a88a";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>站点列表</title>
    <style>
        p {
            color: #96420e;
            font-size: 16px;
        }

        li {
            list-style: none;
        }

        .cu {
            font-weight: 100;
        }

        div {
            padding-left: 0px;
        }

        body {
            padding: 0;
            margin: 0 auto;
            background-color: #f5f5f5;
        }

        .orange {
            color: #ea8b51;
        }

        .bai {
            color: #fff;
        }

        .head_top {
            background-color: #40403e;
            font-size: 22px;
            width: 100%;
            height: 63px;
            font-style: #FFFFFF;
            line-height: 22px;
        }

        .head_left {
            width: 15%;
            padding-left: 10%;
            display: inline-block;
            vertical-align: middle;
        }

        .head_right {
            width: 50%;
            text-align: center;
            display: inline-block;
            text-align: center;
        }

        .xiao {
            font-size: 12px;
        }

        .daozhan {
            text-align: center;
            height: 75px;
            line-height: 6px;
            padding-bottom: 10px;
            margin-top: 10px;
            white-space: nowrap;
            overflow: scroll;
            overflow-y: hidden;
        }

        .daozhan p {
            color: #CCC;
            font-size: 14px;
        }

        .qiche {
            margin-left: 5px;
            display: inline-block;
            margin-bottom: 2px;
        }

        .qiche > li {
            float: left;
            margin-right: 9px;
        }

        .tupian, .shijian, .qiche {
            margin-left: -40px;
            text-align: center;
        }

        .tupian > li {
            float: left;
            text-overflow: ellipsis;
        }

        .shijian > li {
            float: left;
            width: 20px;
            font-size: 14px;
            word-wrap: break-word;
            padding-right: 23px;
            margin-top: -30px;
            margin-bottom: 20px;
        }
    </style>
    <script type="application/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="application/javascript" src="js/zdlbajax.js"></script>
    <script src="js/layer.m.js"></script>
    <script src="js/zdshijingajax.js"></script>
</head>


<body>
<input type="hidden" id="xiugaibancheid" name="xiugaibancheid" value="<%=xiugaibancheid%>"/>

<div class="contant">
    <div>
        <div class="head_top">
            <div class="head_left" style="float: left;padding-top: 20px;">
                <img src="images/fanhui.png" onclick="window.history.back();"/>
            </div>
            <div class="head_right" style="float: left;padding-top: 20px;margin:0 auto;text-align: center;">
                <s:iterator value="comdets">
                    <font color="#FFFFFF"><s:property value="comdetName"></s:property></font>
                </s:iterator>
            </div>
            <div style=" display: inline-block;float: right; margin-right: 10%;padding-top: 20px;">
                <input type="button" onclick="function tiaozhuan() {
var aa = document.getElementById('xiugaibancheid').value;
                window.location.href = 'weixin/shishimap.jsp?xiugaibancheid=' + aa;
                }
                tiaozhuan()"
                       style="display:inline-block; background-image:url('images/ditu.png');height:21px; width:21px; background-color:#40403e; border:none;vertical-align:middle;margin-right: 15%;"/>
            </div>
        </div>
        <div>
            <div class="daozhan">
                <s:iterator value="map" var="var" status="status">
                <input type="hidden" name="gogoshijian" value="<s:property value="#var.key"/>" />
                <s:if test="#status.first">
                <div
                        style="width:24%;  margin:0px -2px;display: inline-block;border-style: solid; color: #f5a06d; background-color:#f5a06d; border-width: 1px;border-radius:15px;"
                        onclick="yujishijian(<s:property value="#status.index +1"></s:property>)">
                    <p style="color: #873300">
                        </s:if>
                        <s:else>

                    <div
                            style="width:24%; margin:0px -3px;display: inline-block;border-style: solid; border-color: #dcdcdc;border-width: 1px;border-radius:15px;"
                            onclick="yujishijian(<s:property value="#status.index +1"></s:property>)">
                        <p>
                            </s:else>
                            <s:property value="#var.value"/></p>

                        <s:if test="#status.first">
                        <img src="images/baiyan.png" style="margin-top: -9px;"/>

                        <p style="color: #873300;margin-top: 7px;">
                            </s:if>
                            <s:else>
                            <img src="images/huiyan.png" style="margin-top: -9px;"/>

                        <p style="margin-top: 7px;">
                            </s:else>
                            <s:property value="#var.key"/>发车</p>
                    </div>
                    </s:iterator>
                </div>

            </div>
        </div>
        <div
                style="clear:both; overflow:scroll; padding-bottom: -20px; overflow-y:hidden;" id="gundong">

            <div class="a" style="width:1150px; margin-top:-20px;" id="zongchang">
                <div style="clear:both; overflow:hidden; margin-left: 10px ">
                    <ul class="qiche">
                        <s:iterator value="strs">
                            <input type="hidden" value="<s:property />" name="kaishijieshu"/>
                        </s:iterator>
                        <%--<li id="xiaocheleft" style=" margin-left:15px;margin-top: 5px;">--%>
                            <%--<!-- 对话框 margin-top: 35px;--> <span--%>
                                <%--style="height:15px; width:50px; color: #797979;font-size: 13px;"><s:property--%>
                                <%--value="zhandiancha"></s:property>站<s:property--%>
                                <%--value="dzshijian"></s:property>分钟</span><img--%>
                                <%--style="margin-bottom: -4px; margin-left:0px;"--%>
                                <%--src="images/xiaoche.png"/>--%>
                        <%--</li>--%>
                        <%--<script>--%>
                            <%--if (document.getElementsByName('kaishijieshu').item(0).value == document.getElementsByName('kaishijieshu').item(1).value) {--%>
                            <%--document.getElementById('xiaocheleft').style.marginLeft = document.getElementsByName('kaishijieshu').item(0).value * 43  -43 + 'px';--%>
                            <%--} else {--%>
                                <%--document.getElementById('xiaocheleft').style.marginLeft =document.getElementsByName('kaishijieshu').item(0).value * 43 -43 + 20 + 'px';--%>
                            <%--}--%>

                        <%--</script>--%>
                        <!-- 对话框 <img style="float: left;" src="images/duihuakuang_03.png" /> -->
                    </ul>
                </div>

                <div
                        style="clear:both; overflow:hidden; margin-top: -15px;white-space:nowrap; ">
                    <ul class="tupian">
                        <li><img style=" width:75px; height:10px;"
                                 src="images/lvtiao.png"/></li>
                        <s:iterator value="zhandians" status="status">
                            <s:if test="zhandianXuhao ==1">
                                <input type="hidden" value="<s:property value="userzhandian"></s:property>" id="userzd"/>
                                <script>
                                    $("#gundong").scrollLeft((document.getElementById("userzd").value - 2) * 43);
//                                    var p1 = document.getElementsByName('kaishijieshu').item(0).value;
//                                    var p2 = document.getElementById("userzd").value;
//                                    if(p1 >p2) {
//                                        $('#xiaocheleft > span').css("display","none");
//                                        if (document.getElementsByName('kaishijieshu').item(0).value == document.getElementsByName('kaishijieshu').item(1).value) {
//                                            document.getElementById('xiaocheleft').style.marginLeft = document.getElementsByName('kaishijieshu').item(0).value * 43  -43 +65+ 'px';
//                                        } else {
//                                            document.getElementById('xiaocheleft').style.marginLeft =document.getElementsByName('kaishijieshu').item(0).value * 43 -43 + 20 +65+ 'px';
//                                        }
//                                    }
                                </script>
                                <li
                                        style="margin-left:-3px; width: 20px;height: 20px;background-color: white;color:#e1856c;text-align: center;border-radius: 100px;border:1px #e1856c solid;">
                                    始
                                </li>
                                <li><img style=" width:25px; height:10px;margin-left:-2px;"
                                         src="images/lvjian.png"/></li>
                            </s:if><s:elseif test="zhandianXuhao < userzhandian">
                            <li
                                    style="margin-left: -2px; width: 20px;height: 20px;background-color: white;color: #e1856c;text-align: center;border-radius: 100px;border:1px #e1856c solid;">
                                <s:property value="zhandianXuhao"></s:property></li>
                            <li><img style=" width:25px; height:10px;margin-left:-2px;"
                                     src="images/lvjian.png"/></li>
                        </s:elseif>

                            <s:elseif test="zhandianXuhao == userzhandian">

                                <s:if test="#status.last ">
                                    <input type="hidden" value="<s:property value="#status.index"></s:property>"
                                           id="yincangstatus"/>
                                    <script>
                                        document.getElementById('zongchang').style.width = 125 + document.getElementById('yincangstatus').value * 43 + 'px';
                                    </script>
                                    <li
                                            style="margin-left: -2px; width: 20px;height: 20px;background-color: white;color: #a4a4a4;text-align: center;border-radius: 100px;border:1px #a4a4a4 solid;">
                                        终
                                    </li>
                                </s:if><s:else>
                                <li
                                        style="margin-left: -2px; width: 20px;height: 20px;background-color: #ed685b;color: #fff;text-align: center;border-radius: 100px;border:1px #ed685b solid;">
                                    <s:property value="zhandianXuhao"></s:property></li>
                                <li><img style="width:25px; height:10px; margin-left:-2px;"
                                         src="images/huijian.png"/></li>
                            </s:else>
                            </s:elseif><s:elseif test="zhandianXuhao >userzhandian">
                            <s:if test="#status.last ">
                                <input type="hidden" value="<s:property value="#status.index"></s:property>"
                                       id="yincangstatus">
                                <script>
                                    document.getElementById('zongchang').style.width = 125 + document.getElementById('yincangstatus').value * 43 + 'px';
                                </script>
                                <li
                                        style="margin-left: -2px; width: 20px;height: 20px;background-color: white;color: #a4a4a4;text-align: center;border-radius: 100px;border:1px #a4a4a4 solid;">
                                    终
                                </li>
                            </s:if><s:else>
                            <li
                                    style="margin-left: -2px; width: 20px;height: 20px;background-color: white;color: #a4a4a4;text-align: center;border-radius: 100px;border:1px #a4a4a4 solid;">
                                <s:property value="zhandianXuhao"></s:property></li>
                            <li><img style="width:25px; height:10px; margin-left:-2px;"
                                     src="images/huijian.png"/></li>
                        </s:else>
                        </s:elseif>

                        </s:iterator>
                        <li style="clear:both;"></li>
                    </ul>
                </div>
                <br/>

                <div style="clear:both; ">
                    <ul class="shijian">
                        <li><p style="color:#e1856c;margin-left:20px;">班车时刻表</p></li>
                        <s:iterator value="zhandians" status="status">
                            <s:if test="zhandianXuhao != userzhandian">
                                <s:if test="#status.first">
                                    <li onclick="shijing(<s:property
                                        value="zhandianId"></s:property>)" style="margin-left: 25px;">
                                </s:if><s:else>
                                <li onclick="shijing(<s:property
                                    value="zhandianId"></s:property>)">
                            </s:else>
                                <div
                                        style=" background-color: #e4e4e4; padding: 1px 24px 15px 7px; border-radius: 10px; ">
                                    <p style="color:#939393;margin-left:1px;"><s:property
                                            value="zhandianName"></s:property></p>
										<span class="orange xiao" id="<s:property value="zhandianXuhao"></s:property>"
                                              style=" white-space:nowrap; margin-left:-7px;">21:30</span>
                                </div>
                                </li>
                            </s:if><s:else>
                            <s:if test="#status.first">
                                <li onclick="shijing(<s:property
                                    value="zhandianId"></s:property>)" style="margin-left: 25px;">
                            </s:if><s:else>
                            <li onclick="shijing(<s:property
                                value="zhandianId"></s:property>)">
                        </s:else>
                                <div
                                        style=" background-color: #ed685b; padding: 1px 24px 15px 7px; border-radius: 10px; ">
                                    <p style="margin-left:1px; color: #fff;"><s:property
                                            value="zhandianName"></s:property></p>
										<span class="bai xiao" id="<s:property value="zhandianXuhao"></s:property>"
                                              style=" white-space:nowrap; margin-left:-7px;">21:30</span>
                                </div>
                            </li>
                        </s:else>
                        </s:iterator>
                        <li style="clear:both;"></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <script>
        onld();

    </script>
</body>
</html>