<%--
  Created by IntelliJ IDEA.
  User: sdl
  Date: 2019/12/8
  Time: 10:39 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
        <li class="layui-this">查看诊断</li>
    </ul>
    <div class="layui-tab-content">
        <form style="width:80%;" class="layui-form" action="seeResult"
              method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">选择宠物名：</label>
                <div class="layui-inline">
                    <div id="demo1" class="xm-select-demo"></div>
                </div>
                <button class="layui-btn layui-btn-normal" lay-submit="search">搜索来查看诊断</button>
            </div>
        </form>
        <div class="layui-tab-item layui-show">
            <div class="layui-form-item">
                <label class="layui-form-label">单号:</label>
                <div class="layui-input-block">
                    <input type="text" required lay-verify="required"
                           autocomplete="off" class="layui-input " >
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">时间:</label>
                <div class="layui-input-block">
                    <input type="text" required lay-verify="required"
                           autocomplete="off" class="layui-input " >
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">宠物姓名：</label>
                <div class="layui-input-block">
                    <input type="text" required lay-verify="required"
                           autocomplete="off" class="layui-input " >
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">病情描述：</label>
                <div class="layui-input-block">
                    <textarea id="description.description" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">诊断结果：</label>
                <div class="layui-input-block">
                    <textarea id="description.result" class="layui-textarea"></textarea>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="static/xm-select.js" type="text/javascript" charset="utf-8"></script>
<script>document.getElementById("description.description").value = "${description.description}"</script>
<script>document.getElementById("description.result").value = "${description.result}"</script>
<script>
    //Demo
    layui.use(['form', 'element'], function () {
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交
    });
</script>
<script>
    var demo1 = xmSelect.render({
        el: '#demo1',
        language: 'zn',
        radio: true,
        style: {
            width: '200px',

        },
        name: 'petid',
        data: ${SelectPetlist}
    })
</script>
</body>
</html></html>
