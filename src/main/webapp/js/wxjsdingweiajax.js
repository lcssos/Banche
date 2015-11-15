// JavaScript Document
var hangbanurl = "wxdingwei.action";
function dingwei(jingdu,weidu) {
    $.ajax({
        url: hangbanurl,
        type: 'POST',
        dataType: 'xml',
        data: {
            wxjsjingdu: jingdu,
            wxjsweidu: weidu
        },
        error: function () {
            return false;
        },
        success: function (xml) {
            $(xml).find('Message').each(function (i) {
                var xx = $(this).children('error').text();
                alert(xx);
            });
        }//sucess
    })//ajax
}//document

