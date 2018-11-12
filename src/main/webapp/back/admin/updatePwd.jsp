<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align: center;margin-top:30px">
    <form id="editFormAdmin" method="post" class="easyui-form">
        <div style="display: none">
            <input type="hidden" name="id"  value="${sessionScope.login.id}" class="easyui-textbox"  required="true"/>
        </div>
        <div>
            &nbsp;&nbsp;&nbsp;原密码: <input type="password" name="pwd" class="easyui-textbox"  required="true"/>
        </div>
        <div style="margin-top: 10px">
            &nbsp;&nbsp;&nbsp;新密码: <input type="password" name="newpwd1" class="easyui-textbox"  required="true"/>
        </div>
        <div style="margin-top: 10px">
                             确认密码: <input type="password" name="newpwd2" class="easyui-textbox" required="true"/>
        </div>

    </form>
</div>