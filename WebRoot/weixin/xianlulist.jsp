<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML >
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
<meta name="apple-mobile-web-app-capable" content="yes">
    <title>线路列表</title>
</head>
<style>
    body {
        padding: 0;
        margin: 0 auto;
        width: 100%;
        text-align: center;
    }

    li {
        list-style: none;
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


    .sousuo {
        height: 60px;
        background-image: url("images/huitiao.png");
        width: 100%;
    }

    #sousuo {
        vertical-align: middle;
        margin-top: 15px;
    }

    .liebiao {
        color: #FFF;
        height: 35px;
        line-height: 33px;
        width: 70%;
        margin-bottom: 6px;
        margin-left: 15%;
    }

    .jiaxiao {
        text-align: center;
    }

    .wenzi {
        text-align: center;
    }
</style>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<body>
<div>

    <div class="head_top">
        <div class="head_left" style="float: left;padding-top: 20px;">
            <%--<img src="images/fanhui.png" onclick="window.history.back();"/>--%>
        </div>
        <div class="head_right" style="float: left;padding-top: 20px;margin:0 auto;text-align: center;">
                <font color="#FFFFFF">线路列表</font>
        </div>
        <s:if test="#session.wxcomid == 1">
        <div style=" display: inline-block;float: right; margin-right: 10%;padding-top: 12px">
        <a href="tel:010-61221393"><img src="images/call.png"></a>
            </div>
        </s:if>
    </div>
    <%--<div class="sousuo">--%>
        <%--<input type="text" class="input"--%>
               <%--style="border-radius:15px; width:70%; margin-top:13px; height:32px; border:none; margin-left:-8%;"--%>
               <%--placeholder="如：大兴线"><input type="button"--%>
                                          <%--style="background-image:url(images/sousuo_xianlu.png); width:20px;;height:20px;margin-left:-14%; background-color:#FFF; border:none; line-height:20px; vertical-align:middle;" />--%>

    <%--</div>--%>
    <form action="wxzhandian.action" method="post" id="wxzhandianform">
    <input type="hidden" id="xiugaibancheid" name="xiugaibancheid" value=""/>
    </form>
    <div class="jiaxiao">
        <ul style="padding-left: 0px;">
<s:iterator value="banches">
            <li  id="<s:property value="bancheId"></s:property>" class="liebiao"
                style="background-color:#e1856c;border-radius:15px;" onclick="tiaozhuan(<s:property value="bancheId"></s:property>)"><span
                    class="wenzi"><s:property value="bancheName"></s:property></span></li>
</s:iterator>
        </ul>
    </div>
    <input id="nonceStr" type="hidden" value="<s:property value="nonceStr"></s:property>"/>
    <input id="timestamp" type="hidden" value="<s:property value="timestamp"></s:property>"/>
    <input id="signature" type="hidden" value="<s:property value="signature"></s:property>"/>
    <script type="application/javascript">
        var id;
        function tiaozhuan(tssid) {
            id = tssid;
//            document.location = 'weixin/wxzhandian.action';
            document.getElementById('xiugaibancheid').value = id;
            document.getElementById('wxzhandianform').submit();
        }
        wx.config({
            debug: false,
            appId: 'wx3d76b0ea7729264d',
            timestamp: document.getElementById('timestamp').value,
            nonceStr: document.getElementById('nonceStr').value,
            signature: document.getElementById('signature').value,
            jsApiList: [
                'openLocation',
                'getLocation',
            ]
        });
        wx.ready(function () {
                    document.querySelector('#getLocation').onclick = function () {
                        wx.getLocation({
                            success: function (res) {
//调用AJAX将数据传回服务器
                                var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                                var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                                var speed = res.speed; // 速度，以米/每秒计
                                var accuracy = res.accuracy; // 位置精度
                                alert(JSON.stringify(res));
                            },
                            cancel: function (res) {
                                alert('用户拒绝授权获取地理位置');
                            }
                        });
                    };
                }
        )
    </script>

</div>


</body>
</html>
