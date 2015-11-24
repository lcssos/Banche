// JavaScript Document
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

var hangbanurl = "wxzhandian.action";
function onld() {

    var s = new Date().Format("hh:mm");
    var $g = $('.daozhan > div[fache]');
    //console.log($g.size());
    if($g.size() > 1){
        var index = 0;
        $g.each(function(i,g){
            //console.log(s + '  '+ g.attr('fache'));
            if(s > $(g).attr('fache')){
                index = $(g).attr('checi');
            }
        });
        if(index > 0){
            yujishijian(index);
        }
    }

}

function yujishijian(checi) {

    $.ajax({
        url: hangbanurl,
        type: 'POST',
        dataType: 'xml',
        data: {
            checi: checi
        },
        error: function () {
            return false;
        },
        success: function (xml) {
            $('.daozhan > div').css("background-color", "");
            $('.daozhan > div').css("color", "");
            $('.daozhan > div').css("border-color", "#dcdcdc");
            $('.daozhan > div > p').css("color", "#9C9999");
            $('.daozhan > div > img').attr("src", "images/huiyan.png");
            $(xml).find('Message').each(function (i) {
                var xx = $(this).children('Yuji').text();
                var shijian = xx.split(",");
                for (var i = 1; i < shijian.length; i++) {
                    var sj = shijian[i - 1];
                    $('#tm_' + i).text(sj);
                }
            });
            $('.daozhan > div[checi=' + checi + ']').css("background-color", "#f5a06d");
            $('.daozhan > div[checi=' + checi + ']').css("color", "#f5a06d");
            $('.daozhan > div[checi=' + checi + ']').css("border-color", "");
            $('.daozhan > div[checi=' + checi + '] > p').css("color", "#873300");
            $('.daozhan > div[checi=' + checi + '] > img').attr("src", "images/baiyan.png");

        }//sucess
    })//ajax
}//document

