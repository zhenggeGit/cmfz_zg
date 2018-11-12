<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center;margin-top:30px">
    <form id="addGuruForm" method="post" class="easyui-form" enctype="multipart/form-data">

        <div style="margin-top: 40px">
           名字: <input type="text" name="name" class="easyui-textbox" data-options="required:true"/>
        </div>

        <div style="margin-top: 10px">
            头像: <input  name="Gurufile" class="easyui-filebox"/>
        </div>

        <div style="margin-top: 10px">
            性别: <input type="text" name="gender" class="easyui-textbox" data-options="required:true"/>
        </div>

        <div style="margin-top: 10px">
            状态: <input type="text" name="status" class="easyui-textbox"  data-options="required:true"/>
        </div>


    </form>
</div>