<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.sdl.utils.RadomNum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>网站后台管理模版</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css"/>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">添加宠物</li>

    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" action="addPet" method="post" enctype="multipart/form-data"
                  style="width: 90%;padding-top: 20px;">
                <input name="petid" style="display: none" value=<%=new RadomNum().generateRadomnum()%>>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物图片：</label>
                    <div class="layui-input-block">
                        <input type="file" name="petimage" onchange="showPreview(this) " accept="image/png,image/jpeg">
                    </div>
                    <div>
                        <img id="portrait" src="" style="display:none;height: 100px;width: 100px" />
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="petname" required lay-verify="required" placeholder="请输入宠物姓名"
                               autocomplete="off" class="layui-input ">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物种类：</label>
                    <div class="layui-input-block">
                        <input type="text" name="petbreed" required lay-verify="required" placeholder="请输入宠物种类"
                               autocomplete="off" class="layui-input ">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物性别：</label>
                    <div class="layui-input-block">
                        <input type="radio" name="petsex" value="公" title="公" checked="">
                        <input type="radio" name="petsex" value="母" title="母">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物年龄：</label>
                    <div class="layui-input-block">
                        <input type="text" name="petage" required lay-verify="required" placeholder="请输入宠物年龄"
                               autocomplete="off" class="layui-input ">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物体重：</label>
                    <div class="layui-input-block">
                        <input type="text" name="petweight" required lay-verify="required"
                               placeholder="请输入体重" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <input name="userid" style="display: none" value=${petUserid}>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>
    //Demo
    layui.use(['form', 'element'], function () {
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交

    });
</script>
<script src="static/admin/layui/lay/modules/layer.js"></script>
<script type="text/javascript">
    var message = "${requestScope.message}";
    if (message != "") {
        alert(message);
    }
</script>
<script type="text/javascript">
    function showPreview(source) {
        var file = source.files[0];
        if(window.FileReader) {
            var fr = new FileReader();
            console.log(fr);
            var portrait = document.getElementById('portrait');
            fr.onloadend = function(e) {
                portrait.src = e.target.result;
            };
            fr.readAsDataURL(file);
            portrait.style.display = 'block';
        }
    }
</script>

</body>
</html>