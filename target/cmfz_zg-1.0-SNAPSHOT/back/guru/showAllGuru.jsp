<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function () {
        $("#showDg").datagrid({
                url:"${pageContext.request.contextPath}/guru/showAll",
                height:300,
                striped:true,
                pagination:true,
                pageSize:2,
                pageList:[2,3,4],
                toolbar:[
                {
                        text:'添加',
                        iconCls:'icon-add',
                       handler:addDialog,
                }, {
                        text:'批量删除',
                        iconCls:'icon-remove',
                       handler:batchDelete,
                    }
                ],
                columns:[[
                        {title:"id",field:"id",width:120,hidden:true},
                        {title:"checkbox",field:"checkbox",width:120,checkbox:true},
                        {title:"名字",field:"name",width:120,},
                        {title:"头像",field:"headPic",width:120,},
                        {title:"性别",field:"gender",width:120,},
                        {title:"状态",field:"status",width:120,},
                        {title:"操作",field:'options',width:220,
                        formatter:function(value,row,index){
                            return "<a href='javascript:;' class='del' onclick=\"del('"+row.id+"')\">删除</a>&nbsp;&nbsp;<a href='javascript:;' class='upd' onclick=\"updateDialog('"+row.id+"')\">修改</a>";
                        }

                    }
                ]],
            onLoadSuccess:function () {
                $(".del").linkbutton({iconCls:'icon-remove'});
                $(".upd").linkbutton({iconCls:'icon-edit'});
            },
            view: detailview,
            detailFormatter: function(index, row){
                return "<table><tr>" +
                    "<td rowspan=2 style='border:0'><img src='${pageContext.request.contextPath}" + row.headPic + "' style='height:100px;'></td>" +
                    "<td style='border:0'>" +
                    "<p>姓名: " + row.name + "</p>" +
                    "<p>性别: " + row.gender + "</p>" +
                    "<p>状态: " + row.status + "</p>" +

                    "</td>" +
                    "</tr></table>";
            },


        });

        });

function batchDelete() {

    var rows = $("#showDg").datagrid('getSelections');
    console.log("-----------"+rows);
    if(rows.length<=0){
        $.messager.show({title:'message',msg:"未选中行"});
    }else{
        var arr = [];
        for (var i=0;i<rows.length;i++){
            arr.push(rows[i].id);
        }
        $.ajax({
            traditional:true,
            data:{ids:arr},
            Type:"POST",
           url:"${pageContext.request.contextPath}/guru/batchDelete",
            success:function(){
                $.messager.show({title:'message',msg:"OK"});
                $("#showDg").datagrid('reload');
            }
        })
    }

}
    function addDialog() {
        $("#addGuru").dialog({
         draggable:false,
         href:"${pageContext.request.contextPath}/back/guru/addGuru.jsp",
           buttons:[{
               text:"保存",
               iconCls:"icon-save",
               handler:function () {
                   $("#addGuruForm").form('submit',{
                       url:"${pageContext.request.contextPath}/guru/addGuru",
                       success:function (result) {
                           var p = $.parseJSON(result);
                           if(p.addGuruSuccess){
                               $.messager.show({title:"提示：",msg:"成功"});
                           }else{
                               $.messager.show({title:"提示：",msg:"失败"});
                           }
                           $("#addGuru").dialog('close');
                           $("#showDg").datagrid("reload");
                       },
                   });
               }
           },{
               text:"取消",
               iconCls:"icon-cancel",
               handler:function () {
                   $("#addGuru").dialog('close');
               }
        }]
        });
    }
    function updateDialog(id) {
        $("#editGuru").dialog({
            draggable:false,
            href:'${pageContext.request.contextPath}/back/guru/editGuru.jsp?id='+id,
            buttons:[{
                text:"保存",
                iconCls:"icon-save",
                handler:function(){
                    $("#editGuruForm").form('submit',{
                        url:'${pageContext.request.contextPath}/guru/motifyGuru',
                        success:function (result) {
                            var data = $.parseJSON(result);
                            if(data.motifyGuruSuccess){
                                $.messager.show({title:'message',msg:"OK"});
                            }else{
                                $.messager.show({title:'message',msg:"失败"});
                            }

                            $("#editGuru").dialog('close');
                            $("#showDg").datagrid('reload');

                        }
                    });
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function () {
                    $("#editGuru").dialog('close')
                }
            }]
        });
    }
    function del(id) {
        $.post("${pageContext.request.contextPath}/guru/removeById","id="+id,function(){
             $.messager.show({title:'message',msg:"OK"});
             $("#showDg").datagrid('reload');
        })
    }

 </script>
<table id="showDg" class="easyui-datagrid" data-options="fit:true">
</table>
<div id="addGuru" data-options="width:300,height:250,iconCls:'icon-add',title:'添加'"></div>
<div id="editGuru" data-options="width:300,height:250,iconCls:'icon-edit',title:'修改'"></div>
<div id="delGuru" data-options="width:300,height:250,iconCls:'icon-edit',title:'删除'"></div>


