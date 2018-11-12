<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function () {
        $("#userDG").datagrid({
                url:"${pageContext.request.contextPath}/user/showAll",
                height:300,
                striped:true,
                pagination:true,
                pageSize:2,
                pageList:[2,3,4],
                columns:[[
                        {title:"id",field:"id",width:120,hidden:true},
                        {title:"checkbox",field:"checkbox",width:120,checkbox:true},
                        {title:"名字",field:"username",width:120,},
                        {title:"头像",field:"headPic",width:120,},
                        {title:"状态",field:"status",width:120,},
                        {title:"时间",field:"date",width:120,},
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
                    "<td rowspan=2 style='border:0'><img src='${pageContext.request.contextPath}/back/user/img/" + row.headPic + "' style='height:100px;'></td>" +
                    "<td style='border:0'>" +
                    "<p>名称: " + row.username + "</p>" +
                    "<p>状态: " + row.status + "</p>" +
                    "<p>图片: " + row.date + "</p>" +
                    "</td>" +
                    "</tr></table>";
            },
        });
 });

    function updateDialog(id) {
        $("#editUser").dialog({
            draggable:false,
            href:'${pageContext.request.contextPath}/back/user/edituser.jsp?id='+id,
            buttons:[{
                text:"保存",
                iconCls:"icon-save",
                handler:function(){

                    $("#editForm").form('submit',{
                        url:'${pageContext.request.contextPath}/user/motifyUser',
                        success:function (result) {
                            var data = $.parseJSON(result);
                            if(data.motifyUserSuccess){
                                $.messager.show({title:'message',msg:"OK"});
                            }else{
                                $.messager.show({title:'message',msg:"失败"});
                            }

                            $("#editUser").dialog('close');
                            $("#userDG").datagrid('reload');
                        }
                    });
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function () {
                    $("#editUser").dialog('close')
                }
            }]
        });
    }
    function del(id) {
        $.post("${pageContext.request.contextPath}/user/removeById","id="+id,function(){
             $.messager.show({title:'message',msg:"OK"});
             $("#userDG").datagrid('reload');
        })
    }

 </script>
<table id="userDG" class="easyui-datagrid" data-options="fit:true">
</table>
<div id="add" data-options="width:300,height:250,iconCls:'icon-add',title:'添加'"></div>
<div id="editUser" data-options="width:300,height:150,iconCls:'icon-add',title:'修改'"></div>


