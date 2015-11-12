<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML >
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>--%>
    <%--<meta name="renderer" content="webkit">--%>
    <title>微信用户——注册</title>
</head>
<body>
<form action="wxzhuce.action" method="post" enctype="multipart/form-data">
    用户名：<input type="text" id="wxusername" name="wxusername" placeholder="请输入邮箱名" onblur="checkusername()"/>
    <br/>
    密码：<input type="text" id="wxuserpassword" name="wxuserpassword" placeholder="请输入至少6位密码" onblur="checkpassword()"/>
    <br/>
    确认密码：<input type="text" id="wxuserconpass" name="wxuserconpass" placeholder="请再次输入密码" onblur="checkconpass()"/>
    <br/>
    手机号：<input type="text" id="wxusertele" name="wxusertele" placeholder="请输入您的手机号" onblur="checktele()"/>
    <br/>
    个人头像：<input type="file" id="upload" name="upload"></inputfile>
    <input type="hidden" id="wxfilename" name="wxfilename"/>
    <%--<input type="file" id="upload" name="upload"/>--%>
    <br/>
    <input type="submit" value="注册" onclick="getname()"/>
</form>
<script type="application/javascript">
    function getname() {
        document.getElementById("wxfilename").value = document.getElementById("upload").value;
    }
    function checkusername() {
        var temp = document.getElementById("wxusername");
        //对电子邮件的验证
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if (!myreg.test(temp.value)) {
            alert('提示\n\n请输入有效的E_mail！');
            temp.focus();
            return false;
        }
    }
    function checkpassword() {
        var temp = document.getElementById("wxuserpassword");
        if (temp.value.length < 6) {
            alert('提示\n\n请输入至少6位数字或字母的密码！')
            temp.focus();
            return false;
        }
    }
    function checkconpass() {
        var temp = document.getElementById("wxuserpassword");
        var temp1 = document.getElementById("wxuserconpass");
        if (temp.value == temp1.value) {
        } else {
            alert('提示\n\n请输入相同的密码！');
            temp1.focus();
            return false;
        }
    }
    function checktele() {
        var temp = document.getElementById("wxusertele");
        var mobile = /^((1[3,5,7,8][0-9]{1})|159|153)+\d{8}$/;
        if (!mobile.test(temp.value)) {
            alert('提示\n\n请输入有效的手机号！');
            temp.focus();
            return false;
        }
    }
</script>
</body>
</html>