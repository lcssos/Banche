<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>--%>
    <%--<meta name="renderer" content="webkit">--%>
    <title>后台管理-后台管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">

    <link rel="stylesheet" href="css/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="css/easyui/themes/icon.css"/>


    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui/datagrid-cellediting.js"></script>

    <script type="application/javascript">
        $(function(){
            $('#grid_checi').datagrid({
//                title:'全部车次列表',
                width:'100%',
                height:'100%',
                remoteSort:false,
                singleSelect:true,
                nowrap:false,
                fitColumns:true,
                toolbar:[{
                    iconCls: 'icon-add',
                    text:'添加车次',
                    handler: function(){
                        $('#dd').dialog('open');
                    }
                }],
                url:'getcheci.action',
                columns:[[
//                    {field:'id',title:'车次ID',width:'30%'},
                    {field:'banche.bancheName',title:'线路名称',width:'70%',sortable:true,formatter:function(value,row,index){
                        return row.banche.bancheName;
                    }},
                    {field:'fache',title:'发车时间',width:'30%'}
                ]],
                onClickRow:function(index,row) {
                    $('#grid_zc').datagrid('reload', {
                        checiId: row.id
                    });
                }
            });


            $('#grid_zc').datagrid('enableCellEditing');
        });


    </script>
</head>
<s:set name="cuowumessage" value="cuowumessage"></s:set>
<body>
<s:include value="yemiantou.jsp">
    <s:param name="test">addcheci</s:param>
</s:include>
<div class="admin">

    <div class="easyui-layout" style="width:100%;height:100%;">
        <div data-options="region:'west',split:true" style="width:300px;"><table id="grid_checi"></table></div>
        <div data-options="region:'center',iconCls:'icon-ok'">
            <table class="easyui-datagrid" id="grid_zc"
                   data-options="url:'getzhandiancheci.action',method:'get',border:false,singleSelect:true,fit:true,fitColumns:true,cellEdit:true,'gotoCell':{index:0,field:'id'},onEndEdit:function(index,row,changes){
                    <%--console.log(index);console.log(row);console.log(changes);--%>
                        $.post('addzhandiancheci.action',{'zhandianCheci.id':row.id,'zhandianCheci.zhandianYuji':changes.zhandianYuji});
                   }">
                <thead>
                <tr>
                    <th data-options="field:'id'" width="30">ID</th>
                    <th data-options="field:'name',formatter:function(value,row,index){return row.zhandian.zhandianName}" width="120">站点名称</th>
                    <th data-options="field:'zhandianDizhi',formatter:function(value,row,index){return row.zhandian.zhandianDizhi}" width="200">地址</th>
                    <th data-options="field:'zhandianYuji',editor:{type:'timespinner',options:{showSeconds: false}}" width="50">预计到达时间</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>




    <div id="dd" class="easyui-dialog" title="车次管理" style="width:400px;height:200px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
            text:'保存',handler:function(){
                $('#ff').form('submit', {
                    url:'addcheci.action',
                    onSubmit: function(){
                        // return false to prevent submit;
                    },
                    success:function(data){
                        <%--alert(data);--%>
                        $('#grid_checi').datagrid('reload');
                        $('#dd').dialog('close');
                    }
                });
            }
         },{
            text:'关闭',
            handler:function(){
                $('#dd').dialog('close');
            }
         }]">
        <form id="ff" method="post">
            <input type="hidden" name="checi.id"/>
            <div>
                <label for="banche_id">线路ID:</label>
                <input class="easyui-validatebox" type="text" name="checi.banche.bancheId" id="banche_id" data-options="required:true" />
            </div>
            <div>
                <label for="cheliang_id">车辆ID:</label>
                <input class="easyui-validatebox" type="text" name="checi.cheliang.cheliangId" id="cheliang_id" data-options="required:true" />
            </div>
            <div>
                <label for="fache">发车时间:</label>
                <input class="easyui-validatebox" type="text" name="checi.fache" id="fache" data-options="required:true" />
            </div>
        </form>
    </div>
</div>



</body>
</html>
