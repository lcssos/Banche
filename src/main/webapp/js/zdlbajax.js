// JavaScript Document
var hangbanurl = "wxzhandian.action";
function onld() {

    var zuijin = 0;
    var shijiancha = 100000;
    var shijianheji = document.getElementsByName("gogoshijian");
    if (shijianheji.length > 1) {

        for (var i = 0; i < shijianheji.length; i++) {
            var mydate = new Date();
            var smiao = parseInt(shijianheji.item(i).value.substring(0, 2) * 60) + parseInt(shijianheji.item(i).value.substring(3, 5));
            var nmiao = mydate.getHours() * 60 + mydate.getMinutes();
            if (Math.abs(nmiao - smiao) < shijiancha) {
                shijiancha = Math.abs(nmiao - smiao);
                zuijin = i;
            }
if(parseInt(shijianheji.item(zuijin).value.substring(0, 2)) < mydate.getHours()) {
                if(zuijin +1< shijianheji.length) {
                    zuijin = zuijin+1;
                } 
            }else if(parseInt(shijianheji.item(zuijin).value.substring(0, 2)) == mydate.getHours()) {
                if(parseInt(shijianheji.item(zuijin).value.substring(3, 5)) < mydate.getMinutes()) {
                    if(zuijin +1< shijianheji.length) {
                        zuijin = zuijin+1;
                    }
                }
            }
        }
    } else {
        zuijin = 0;
    }
    $('.daozhan').scrollLeft(zuijin * 70);
    yujishijian(zuijin + 1);
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
            $('.daozhan > div:eq(' + (checi - 1) + ')').css("background-color", "#f5a06d");
            $('.daozhan > div:eq(' + (checi - 1) + ')').css("color", "#f5a06d");
            $('.daozhan > div:eq(' + (checi - 1) + ')').css("border-color", "");
            $('.daozhan > div:eq(' + (checi - 1) + ') > p').css("color", "#873300");
            $('.daozhan > div:eq(' + (checi - 1) + ') > img').attr("src", "images/baiyan.png");
            $(xml).find('Message').each(function (i) {
                var xx = $(this).children('Yuji').text();
                var shijian = xx.split(",");
                for (var i = 1; i < shijian.length; i++) {
                    var sj = shijian[i - 1];
                    //if (sj.length == 4) {
                    //    sj = "0" + sj;
                    //}
                    //document.getElementById('tm_'+i).innerText = sj;
                    $('#tm_'+i).text(sj);
                    console.log(sj);
                }
            });
        }//sucess
    })//ajax
}//document

