// JavaScript Document
var hangbanurl = "wxzhandian.action";
function shijing(xiugaizhandianid) {

    $.ajax({
        url: hangbanurl,
        type: 'POST',
        dataType: 'xml',
        data: {
            xiugaizhandianid: xiugaizhandianid,
            searchform:3
        },
        error: function () {
            return false;
        },
        success: function (xml) {
            $(xml).find('Message').each(function (i) {
                var xx = $(this).children('image').text();
                var yy = $(this).children('dizhi').text();
                if(xx == "") {
                    layer.open({
                        type: 1,
                        content: '无实景图</br>' +yy +''
                    })
                } else {
                    layer.open({
                        type: 1,
                        content: '<img src=' + xx + '> ' + yy + ''
                    })
                }
            });
        }//sucess
    })//ajax
}//document

