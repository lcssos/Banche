<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML >
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
<meta name="apple-mobile-web-app-capable" content="yes">
    <title>驾校列表</title>
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
        text-align: center;
        background-color: #40403e;
        font-size: 22px;
        color: #FFF;
        height: 60px;
        line-height: 60px;
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
<body>
<div>

    <div class="head_top">
        <span>驾校列表</span>
    </div>
    <div class="sousuo">
        <input type="text" class="input"
               style="border-radius:15px; width:70%; margin-top:13px; height:32px; border:none; margin-left:-8%;"
               placeholder="如：远方驾校"><input type="button"
                                          style="background-image:url(images/sousuo_xianlu.png); width:20px;;height:20px;margin-left:-14%; background-color:#FFF; border:none; line-height:20px; vertical-align:middle;" />
    </div>
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
    </script>

</div>


</body>
</html>
