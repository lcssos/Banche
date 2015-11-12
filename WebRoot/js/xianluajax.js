// JavaScript Document
var hangbanurl = "fujinxianlu.action";
var ass = [];
function test(xianluid) {

    int = self.setInterval("refreshcheliang(thebancheid)", 10000);
    $.ajax({
        url: hangbanurl,
        type: 'POST',
        dataType: 'xml',
        data: {
            fujinxianlu: 2,
            xianluid: xianluid,
        },
        error: function () {
            return false;
        },
        success: function (xml) {

            map = new BMap.Map("allmap");

            $(xml).find('Biaodian').each(function (i) {
                var gpsPoint = new BMap.Point($(this).children('Jingdu').text(), $(this).children('Weidu').text());
                ass.push(gpsPoint);
            });
            //var polyline = new BMap.Polyline(
            //    ass
            //    , {strokeColor: "#a3b8eb", strokeWeight: 6, strokeOpacity: 1});   //创建折线
            //map.addOverlay(polyline);
            document.getElementById("showText").innerHTML = "";
            var tableji = 0;
            $(xml).find('Zhandian').each(function (i) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "tjingdu";
                input.value = $(this).children('Zhandianjingdu').text();
                document.getElementById("showText").appendChild(input);

                var input2 = document.createElement("input");
                input2.type = "hidden";
                input2.name = "tweidu";
                input2.value = $(this).children('Zhandianweidu').text();
                document.getElementById("showText").appendChild(input2);

                var input3 = document.createElement("input");
                input3.type = "hidden";
                input3.name = "tname";
                input3.value = $(this).children('Zhandianname').text();
                document.getElementById("showText").appendChild(input3);

                var input4 = document.createElement("input");
                input4.type = "hidden";
                input4.name = "tmiaoshu";
                input4.value = $(this).children('Zhandianmiaoshu').text();
                document.getElementById("showText").appendChild(input4);

                var input5 = document.createElement("input");
                input5.type = "hidden";
                input5.name = "tyincang";
                input5.value = $(this).children('Zhandianyincang').text();
                document.getElementById("showText").appendChild(input5);
            });
            $(xml).find('Cheliang').each(function (i) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "tclname";
                input.value = $(this).children('Chepai').text();
                document.getElementById("showText").appendChild(input);

                var input2 = document.createElement("input");
                input2.type = "hidden";
                input2.name = "tclshebei";
                input2.value = $(this).children('Shebeiid').text();
                document.getElementById("showText").appendChild(input2);

                var input3 = document.createElement("input");
                input3.type = "hidden";
                input3.name = "tcldaozhan";
                input3.value = $(this).children('Daozhan').text();
                document.getElementById("showText").appendChild(input3);
            });
            $(xml).find('Shebei').each(function (i) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "tsbshebei";
                input.value = $(this).children('Shebeiid').text();
                document.getElementById("showText").appendChild(input);

                var input2 = document.createElement("input");
                input2.type = "hidden";
                input2.name = "tsbjd";
                input2.value = $(this).children('Shebeijingdu').text();
                document.getElementById("showText").appendChild(input2);

                var input3 = document.createElement("input");
                input3.type = "hidden";
                input3.name = "tsbwd";
                input3.value = $(this).children('Shebeiweidu').text();
                document.getElementById("showText").appendChild(input3);
            });
            loadJScript(xianluid);

        }//sucess
    })//ajax
}//document
function refreshcheliang(xianluid) {
//alert(clmarker);
map.removeOverlay(clmarker);
map.removeOverlay(chushiclmarker);
    $.ajax({
        url: hangbanurl,
        type: 'POST',
        dataType: 'xml',
        data: {
            fujinxianlu: 3,
            xianluid: xianluid,
        },
        error: function () {
            return false;
        },
        success: function (xml) {
            var cheliangs = document.getElementsByName("tclname").length;
            var shebeis = document.getElementsByName("tsbshebei").length;
            for (var xs = 0; xs < cheliangs; xs++) {
                document.getElementById("showText").removeChild(document.getElementsByName("tclname")[0]);
                document.getElementById("showText").removeChild(document.getElementsByName("tclshebei")[0]);
                document.getElementById("showText").removeChild(document.getElementsByName("tcldaozhan")[0]);
            }
            for (var sx = 0; sx < shebeis; sx++) {
                document.getElementById("showText").removeChild(document.getElementsByName("tsbshebei")[0]);
                document.getElementById("showText").removeChild(document.getElementsByName("tsbjd")[0]);
                document.getElementById("showText").removeChild(document.getElementsByName("tsbwd")[0]);
            }
            $(xml).find('Cheliang').each(function (i) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "tclname";
                input.value = $(this).children('Chepai').text();
                document.getElementById("showText").appendChild(input);

                var input2 = document.createElement("input");
                input2.type = "hidden";
                input2.name = "tclshebei";
                input2.value = $(this).children('Shebeiid').text();
                document.getElementById("showText").appendChild(input2);

                var input3 = document.createElement("input");
                input3.type = "hidden";
                input3.name = "tcldaozhan";
                input3.value = $(this).children('Daozhan').text();
                document.getElementById("showText").appendChild(input3);
            });
            $(xml).find('Shebei').each(function (i) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "tsbshebei";
                input.value = $(this).children('Shebeiid').text();
                document.getElementById("showText").appendChild(input);

                var input2 = document.createElement("input");
                input2.type = "hidden";
                input2.name = "tsbjd";
                input2.value = $(this).children('Shebeijingdu').text();
                document.getElementById("showText").appendChild(input2);

                var input3 = document.createElement("input");
                input3.type = "hidden";
                input3.name = "tsbwd";
                input3.value = $(this).children('Shebeiweidu').text();
                document.getElementById("showText").appendChild(input3);
            });
            //loadJScript();
            refshcl();
        }//sucess
    })//ajax
}//document