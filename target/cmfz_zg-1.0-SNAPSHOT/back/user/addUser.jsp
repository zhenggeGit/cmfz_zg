<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center;margin-top:30px">
    <form id="addUserForm" method="post" class="easyui-form" enctype="multipart/form-data">
        <div style="margin-top: 40px">
            手机: <input type="text" name="phoneNum" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div style="margin-top: 40px">
           名字: <input type="text" name="username" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div style="margin-top: 40px">
            密码: <input type="text" name="password" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div style="margin-top: 40px">
            地址: <input type="text" name="address" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            法号: <input type="text" name="nickName" class="easyui-textbox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 40px">
            性别: <input type="text" name="gender" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div style="margin-top: 40px">
            备注: <input type="text" name="sign" class="easyui-textbox" data-options="required:true"/>
        </div>
        <div style="margin-top: 40px">
            头像: <input type="text" name="headPic" class="easyui-textbox" data-options="required:true"/>
        </div>
    </form>
</div>