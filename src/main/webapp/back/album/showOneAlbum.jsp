<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function () {
    $("#showOneAlbum").form("load","${pageContext.request.contextPath}/album/findOne?id=${param.id}");
})
</script>
<div style="text-align: center;margin-top:30px">
    <form method="post" id="showOneAlbum" class="easyui-form">
        <div style="margin-top: 20px;display:none" >
            id:<input type="text" name="id" class="easyui-textbox" data-options="readonly:true">
        </div>

        <div style="margin-top: 20px">
            专辑名称:<input type="text" name="title" class="easyui-textbox" data-options="readonly:true">
        </div>
        <div style="margin-top: 20px">
            评分:<input type="text" name="star" class="easyui-textbox" data-options="readonly:true">
        </div>

        <div style="margin-top: 20px">
            作者:<input type="text" name="author" class="easyui-textbox" data-options="readonly:true">
        </div>

        <div style="margin-top: 20px">
            播音:<input type="text" name="broadCast" class="easyui-textbox" data-options="readonly:true">
        </div>

        <div style="margin-top: 20px">
            集数:<input type="text" name="count" class="easyui-textbox" data-options="readonly:true">
        </div>
        <div style="margin-top: 20px">
            简介:<input type="text" name="brief" class="easyui-textbox" data-options="readonly:true">
        </div>

        <div style="margin-top: 20px">
            发布日期:<input type="text" name="publishDate" class="easyui-textbox" data-options="readonly:true">
        </div>
        <div style="margin-top: 20px">
            封面:<input type="text" name="coverImg" class="easyui-textbox" data-options="readonly:true">
        </div>
    </form>
</div>