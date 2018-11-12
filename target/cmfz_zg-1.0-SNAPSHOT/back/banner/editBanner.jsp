<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function () {
    $("#editBannerForm").form("load","${pageContext.request.contextPath}/banner/findOne?id=${param.id}");
})

</script>
<div style="text-align: center;margin-top:30px">
    <form id="editBannerForm" method="post" class="easyui-form">
        <div style="margin-top: 10px;display:none">
            ID : <input type="text" name="id" class="easyui-textbox" data-options="required:true"/>
        </div>

        <div style="margin-top: 40px">
            名字: <input type="text" name="title" class="easyui-textbox" />
        </div>
        <div style="margin-top: 10px">
            路径: <input type="text" name="imgPath" class="easyui-textbox" />
        </div>
        <div style="margin-top: 10px">
            状态: <input type="text" name="status" class="easyui-textbox"/>
        </div>



    </form>
</div>