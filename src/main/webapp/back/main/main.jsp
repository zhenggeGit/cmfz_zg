<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>

    <script type="text/javascript">
        $(function () {
            $.post("${pageContext.request.contextPath}/Menu/show", function (menu) {
                //遍历一级菜单
                console.log(menu);
                $.each(menu, function (index, m) {
                    //遍历二级菜单
                    var content = "<div style='text-align: 'center'>";
                    $.each(m.menus, function (idx, child) {
                        content += "<a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='width:99.8%;margin:10px 0px; border: 1px #95b8e7 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                    });
                    content += "</div>";
                    $("#menu").accordion('add', {
                        title: m.title,
                        iconCls: m.iconCls,
                        content: content,
                    })
                })
            });
        });
        //点击菜单  添加选项
        function addTabs(title,iconCls,href){
            //添加以前先判断tabs中是否存在这个选项卡
            if(!$("#tt").tabs('exists',title)){
                $("#tt").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    fit:true,
                    href:"${pageContext.request.contextPath}/"+href,
                });
            }else{
                $("#tt").tabs('select',title);
            }

        }
    </script>

<script type="text/javascript">
    function updatePwd(){
    $('#updatePwd').dialog({
        title: '修改密码',
        href:'${pageContext.request.contextPath}/back/admin/updatePwd.jsp',
        width: 350,
        height: 220,
        draggable:false,
        buttons:[{
            iconCls:"icon-save",
            text:"确定",
            handler:function () {
                $("#editFormAdmin").form('submit',{
                    url:"${pageContext.request.contextPath}/admin/updatePWD",
                    success:function (data) {
                        var p = $.parseJSON(data);
                            if(p.updateSuccess){
                                $.messager.show({title:"提示：",msg:"密码修改成功"});
                            }else{
                                $.messager.show({title:"提示：",msg:"输入有误，请重新修改"});
                            }
                        $('#updatePwd').dialog("close");
                    },
                })
            }
        },{
            iconCls:"icon-cancel",
            text:"取消",
            handler:function () {
                $('#updatePwd').dialog("close");
            }
        }],
    })
    };
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.login.name} &nbsp;<a href="javascript:void(0);" onclick="updatePwd()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">

		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>

		</div>  
    </div>
    <div id="updatePwd"></div>

</body> 
</html>