<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    var f_id = "<%=request.getParameter("id")%>";
    $("#fid").val(f_id);
</script>
<div style="text-align: center;margin-top:30px">
    <form id="addChapterForm" method="post" class="easyui-form" enctype="multipart/form-data">
        <div style="display: none">
            专辑ID: <input type="text" id="fid" name="album_id"  class="easyui-textbox" data-options="required:true"/>
        </div>
        <div style="margin-top: 40px">
           名字: <input type="text" name="title" class="easyui-textbox" data-options="required:true"/>
        </div>

        <div style="margin-top: 10px">
            大小: <input type="text" name="size" class="easyui-textbox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            时长: <input type="text" name="duration" class="easyui-textbox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            地址: <input type="text" name="chapFile" class="easyui-filebox"  data-options="required:true"/>
        </div>

    </form>
</div>