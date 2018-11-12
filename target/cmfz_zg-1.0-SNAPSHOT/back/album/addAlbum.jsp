<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center;margin-top:30px">
    <form id="addAlbumForm" method="post" class="easyui-form" enctype="multipart/form-data">

        <div style="margin-top: 40px">
           名字: <input type="text" name="title" class="easyui-textbox" data-options="required:true"/>
        </div>
        <%--<div style="margin-top: 10px">--%>
            <%--发布日期: <input type="text" name="publishDate" class="easyui-textbox"  data-options="required:true"/>--%>
        <%--</div>--%>
        <div style="margin-top: 10px">
            集数: <input type="text" name="count" class="easyui-textbox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            封面: <input type="text" name="file" class="easyui-filebox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            评分: <input type="text" name="star" class="easyui-textbox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            作者: <input type="text" name="author" class="easyui-textbox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            播音: <input type="text" name="broadCast" class="easyui-textbox"  data-options="required:true"/>
        </div>
        <div style="margin-top: 10px">
            简介: <input type="text" name="brief" class="easyui-textbox"  data-options="required:true"/>
        </div>
    </form>
</div>