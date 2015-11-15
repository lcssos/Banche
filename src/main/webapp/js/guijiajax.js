// JavaScript Document
var hangbanurl = "xingcheguiji.action";
var map;
var opts = {
    width: 250,     // 信息窗口宽度
    height: 100,     // 信息窗口高度
    title: "信息", // 信息窗口标题
    enableMessage: true//设置允许信息窗发送短息
};
var ass = [];
var jingdu = [];
var weidu = [];
var sudu = [];
var shijian = [];
var time = 0;
var marker;
function guiji(startday, starttime, endday, endtime, chepai) {
    $.ajax({
        url: hangbanurl,
        type: 'POST',
        dataType: 'xml',
        data: {
            startday: startday,
            starttime: starttime,
            endday: endday,
            endtime: endtime,
            chepai: chepai
        },
        error: function () {
            return false;
        },
        success: function (xml) {
            //map.clearOverlays();
            ass = [];
            jingdu = [];
            weidu = [];
            sudu = [];
            shijian = [];
            $(xml).find('Shebeilishi').each(function (i) {
                var xx = $(this).children('Jingdu').text();
                var yy = $(this).children('Weidu').text();
                var gpsPoint = new BMap.Point(xx, yy);

                ass.push(gpsPoint);
                jingdu.push(xx);
                weidu.push(yy);
                sudu.push($(this).children('Sudu').text());
                shijian.push($(this).children('Shijian').text());
            });
            var polyline = new BMap.Polyline(
                ass
                , {strokeColor: "blue", strokeWeight: 5, strokeOpacity: 2});   //创建折线
            map.addOverlay(polyline);
            map.centerAndZoom(ass[0], 13);
            map.setViewport(ass);
        }//sucess
    })//ajax
}//document
function init() {
    map = new BMap.Map("allmap");
    map.centerAndZoom("北京", 13);
    map.enableScrollWheelZoom();                 //启用滚轮放大缩小
    map.enableDragging();

    var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
    var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
    var top_right_navigation = new BMap.NavigationControl({
        anchor: BMAP_ANCHOR_TOP_RIGHT,
        type: BMAP_NAVIGATION_CONTROL_SMALL
    }); //右上角，仅包含平移和缩放按钮
    /*缩放控件type有四种类型:
     BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGATION_CONTROL_ZOOM：仅包含缩放按钮*/

    //添加控件和比例尺
    map.addControl(top_left_control);
    map.addControl(top_left_navigation);
    map.addControl(top_right_navigation);
}
function yidong() {
    //map.clearOverlays();
    map.removeOverlay(marker);
    var myIcon = new BMap.Icon("http://120.24.92.204:80/Banche/images/jiache.gif", new BMap.Size(30, 80), {imageOffset: new BMap.Size(10, 20)});
    marker = new BMap.Marker(ass[time], {icon: myIcon});
    map.addOverlay(marker);
    var diji = "当前位置是：" + jingdu[time] + "<br/>当前维度是：" + weidu[time] + "<br/>当前速度是：" + sudu[time] + "<br/>当前时间是：" + shijian[time];
    var infoWindow = new BMap.InfoWindow(diji, opts);  // 创建信息窗口对象
    map.openInfoWindow(infoWindow, ass[time]); //开启信息窗口
    time++;
}