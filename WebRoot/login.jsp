<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>班车后台管理-管理员登录</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery-2.1.4.min.js"></script>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?f1a41121ab2caeaa7034b233b3d2a88a";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>

</head>

<body>
<div class="container">
    <div class="line">
        <div class="xs6 xm4 xs3-move xm4-move">
            <br/><br/>
            <%--<div class="media media-y">--%>
            <%--<a href="#" target="_blank"><img src="images/logo.png" class="radius" alt="后台管理系统" /></a>--%>
            <%--</div>--%>
            <br/><br/>

            <form action="denglu.action" method="post">
                <div class="panel">
                    <div class="panel-head"><strong>登录后台管理系统</strong></div>
                    <div class="panel-body" style="padding:30px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input" name="username" placeholder="登录账号"
                                       data-validate="required:请填写账号,length#>=5:账号长度不符合要求"/>
                                <span class="icon icon-user"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input" name="password" placeholder="登录密码"
                                       data-validate="required:请填写密码,length#>=6:密码长度不符合要求"/>
                                <span class="icon icon-key"></span>
                            </div>
                        </div>
                        <%--<div class="form-group">--%>
                        <%--<div class="field">--%>
                        <%--<input type="text" class="input" name="passcode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />--%>
                        <%--<img src="images/passcode.jpg" width="80" height="32" class="passcode" />--%>
                        <%--</div>--%>
                        <%--</div>--%>
                    </div>
                    <div class="panel-foot text-center">
                        <button class="button button-block bg-main text-big">立即登录后台</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>