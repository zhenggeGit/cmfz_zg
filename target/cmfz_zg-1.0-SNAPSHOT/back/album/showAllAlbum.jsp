<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $('#showAlbum').treegrid({
        url:'${pageContext.request.contextPath}/album/findAll',
        idField:'id',
        treeField:'title',
        columns:[[
            {field:'title',title:'名字',width:180},
            {field:'downPath',title:'下载路径',width:60,align:'right'},
            {field:'size',title:'章节大小',width:80},
            {field:'duration',title:'章节时长',width:80}
        ]],
        toolbar:[
            {
                text:'专辑详情',
                iconCls:'icon-save',
                handler:albumMsg,
            }, {
                text:'添加专辑',
                iconCls:'icon-add',
                handler:addAlbum,
            },
            {
                text:'添加章节',
                iconCls:'icon-add',
                handler:addChapter,
            }, {
                text: '下载音频',
                iconCls: 'icon-download',
                handler: DownloadAudio,

            }
        ]
    });
    /*下载音频*/
    function DownloadAudio() {
        var row=$("#showAlbum").treegrid("getSelected")
        location.href="${pageContext.request.contextPath}/album/downLoad?downPath="+row.downPath;
    }
    function addChapter() {
        var row = $('#showAlbum').treegrid("getSelected");
        if(row.coverImg==null){
            $.messager.show({title:"提示：",msg:"请选择专辑"});
        }else{
            var f_id=row.id;
            $("#addChapter").dialog({
                draggable:false,
                href:"${pageContext.request.contextPath}/back/album/addChapter.jsp?id="+f_id,
                buttons:[{
                    text:"保存",
                    iconCls:"icon-save",
                    handler:function () {
                        $("#addChapterForm").form('submit',{
                            url:"${pageContext.request.contextPath}/album/addChapter",
                            success:function (result) {
                                var p = $.parseJSON(result);
                                if(p.addCSuccess){
                                    $.messager.show({title:"提示：",msg:"成功"});
                                }else{
                                    $.messager.show({title:"提示：",msg:p.addCFile});
                                }
                                $("#addChapter").dialog('close');
                                $('#showAlbum').treegrid("reload");

                            },
                        });
                    }
                },{
                    text:"取消",
                    iconCls:"icon-cancel",
                    handler:function () {
                        $("#addChapter").dialog('close');
                    }
                }]
            })
        }
    }
    function albumMsg() {
        var row = $('#showAlbum').treegrid("getSelected");
        var id = row.id;
        $("#albumMsg").dialog({
            draggable:false,
            href:"${pageContext.request.contextPath}/back/album/showOneAlbum.jsp?id="+id,
        })
    }
    function addAlbum() {
        $("#addAlbum").dialog({
            draggable:false,
            href:"${pageContext.request.contextPath}/back/album/addAlbum.jsp",
            buttons:[{
                text:"保存",
                iconCls:"icon-save",
                handler:function () {
                    $("#addAlbumForm").form('submit',{
                        url:"${pageContext.request.contextPath}/album/addAlbum",
                        success:function (result) {
                            var p = $.parseJSON(result);
                            if(p.addSuccess){
                                $.messager.show({title:"提示：",msg:"成功"});
                            }else{
                                $.messager.show({title:"提示：",msg:p.addFile});
                            }
                            $("#addAlbum").dialog('close');

                        },
                    });
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function () {
                    $("#addAlbum").dialog('close');
                }
            }]
        })
    }

</script>
<table id="showAlbum" style="width:600px;height:400px"></table>
<div id="albumMsg" data-options="width:400,height:400,iconCls:'icon-save',title:'专辑详情'"></div>
<div id="addAlbum" data-options="width:400,height:350,iconCls:'icon-add',title:'添加专辑'"></div>
<div id="addChapter" data-options="width:400,height:350,iconCls:'icon-add',title:'添加章节'"></div>




