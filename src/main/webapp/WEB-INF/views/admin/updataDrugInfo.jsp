<%--
  Created by IntelliJ IDEA.
  User: sdl
  Date: 2019/11/30
  Time: 7:06 下午
  To change this template use File | Settings | File Templates.
--%>
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
        <li class="layui-this">修改药品信息</li>

    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" action="updataDrugInfo" method="post" enctype="multipart/form-data"
                  style="width: 90%;padding-top: 20px;">

                <div class="layui-form-item">
                    <label class="layui-form-label">药品ID：</label>
                    <div class="layui-input-block">
                        <input type="text" name="gid" required lay-verify="required" placeholder="请输入ID"
                               autocomplete="off" class="layui-input " value=${DrugInfo.gid}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">药品图片：</label>
                    <div class="layui-input-block">
                        <input type="file" name="gimage" onchange="showPreview(this) " accept="image/png,image/jpeg">
                    </div>
                    <div>
                        <img id="portrait" src="${DrugInfo.gimage}" style="height: 100px;width: 100px" />
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">药品名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="gname" required lay-verify="required" placeholder="请输入药名"
                               autocomplete="off" class="layui-input" value=${DrugInfo.gname}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">药品价格：</label>
                    <div class="layui-input-block">
                        <input type="text" name="gprice" required lay-verify="required"
                               placeholder="请输入价格" autocomplete="off" class="layui-input" value=${DrugInfo.gprice}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">添加数量：</label>
                    <div class="layui-input-block">
                        <input type="text" name="gnum" required lay-verify="required"
                               placeholder="请输入数量" autocomplete="off" class="layui-input" value=${DrugInfo.gnum}>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注：</label>
                    <div class="layui-input-block">
                        <textarea id="gnote" name="gnote" placeholder="请输入内容"
                                  class="layui-textarea"></textarea>
                    </div>
                </div>
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
<script>document.getElementById("gnote").value="${DrugInfo.gnote}"</script>
<script>
    //Demo
    layui.use(['form', 'element'], function () {
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交

    });
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