
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>微信JS-SDK Demo</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
  <link rel="stylesheet" href="http://203.195.235.76/jssdk/css/style.css">
  <script type="application/javascript" src="http://203.195.235.76/jssdk/js/zepto.min.js"></script>
  <script src="http://203.195.235.76/jssdk/js/demo.js" type="application/javascript"></script>
</head>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<body ontouchstart="">
<div class="wxapi_container">
  <div class="wxapi_index_container">
    <ul class="label_box lbox_close wxapi_index_list">
      <li class="label_item wxapi_index_item"><a class="label_inner" href="#menu-location">地理位置接口</a></li>
    </ul>
  </div>
  <div class="lbox_close wxapi_form">
    <h3 id="menu-location">地理位置接口</h3>
    <span class="desc">使用微信内置地图查看位置接口</span>
    <button class="btn btn_primary" id="openLocation">openLocation</button>
    <span class="desc">获取地理位置接口</span>
    <button class="btn btn_primary" id="getLocation">getLocation</button>
  </div>
</div>

</body>

<script>
  /*
   * 注意：
   * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
   * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
   * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
   *
   * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
   * 邮箱地址：weixin-open@qq.com
   * 邮件主题：【微信JS-SDK反馈】具体问题
   * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
   */
  wx.config({
    debug: true,
    appId: 'wx3d76b0ea7729264d',
    timestamp: 1441955736,
    nonceStr: '3ac0ab02-139b-49be-953a-a558820cb6c2',
    signature: '14cd0a0d169e7e50ce0c5756f04d47d27e56af5e',
    jsApiList: [
      'openLocation',
      'getLocation',
    ]
  });
</script>
</html>
