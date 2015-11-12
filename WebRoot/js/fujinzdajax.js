// JavaScript Document
var hangbanurl = "wxfujinzhandian.action";
var map;
var opts = {
    width: 250,     // 信息窗口宽度
    height: 120,     // 信息窗口高度
    title: "信息", // 信息窗口标题
    enableMessage: true//设置允许信息窗发送短息
};
var marker;
function fujinzd(openId) {
    $.ajax({
        url: hangbanurl,
        type: 'POST',
        dataType: 'xml',
        data: {
            wxopenId: openId
        },
        error: function () {
            return false;
        },
        success: function (xml) {
            var ass = [];
            $(xml).find('Zhandian').each(function (i) {
                var banchename = $(this).children('Banchename').text();
                var zhandianname = $(this).children('Zhandianname').text();
                var jingdu = $(this).children('Zhandianjingdu').text();
                var weidu = $(this).children('Zhandianweidu').text();
                var dizhi = $(this).children('Zhandiandizhi').text();
                var miaoshu = $(this).children('Zhandianmiaoshu').text();
                var gpsPoint = new BMap.Point(jingdu, weidu);

                ass.push(gpsPoint);

                //var content = "<a href=../login.jsp style='text-decoration:none;color: #22cc77'>" +"站点名称：" + zhandianname + "<br/>"
                //             +"站点地址：" + dizhi + "<br/>"
                //             +"站点描述：" + miaoshu + "<br/>" + "线路名称：" + banchename + "</a>";
                var content ="站点名称：" + zhandianname + "<br/>"
                    +"站点地址：" + dizhi + "<br/>"
                    +"站点描述：" + miaoshu + "<br/>" + "线路名称：" + banchename;
                marker = new BMap.Marker(new BMap.Point(jingdu,weidu));
                map.addOverlay(marker);
                    marker.addEventListener("click", function (e) {
                            var p = e.target;
                            var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                            var infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
                            map.openInfoWindow(infoWindow, point); //开启信息窗口

                        }
                    );
                });
            map.setViewport(ass);
        }//sucess
    })//ajax
}//document

