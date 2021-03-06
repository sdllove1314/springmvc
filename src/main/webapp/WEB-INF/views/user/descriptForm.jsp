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
        <li class="layui-this">挂号单</li>
    </ul>

    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" action="descript"
                  method="post"
                  style="width: 90%;padding-top: 20px;">
                <input name="userid" style="display: none" value=${loginUser.userid}>
                <div class="layui-form-item">
                    <label class="layui-form-label">单号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="did" required lay-verify="required"
                               autocomplete="off" class="layui-input " value=<%=new RadomNum().generateRadomnum()%>>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">时间：</label>
                    <div class="layui-input-block">
                        <input type="text" name="descdate" required lay-verify="required"
                               autocomplete="off" class="layui-input " value=<%=new RadomNum().generateTime()%>>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">宠物姓名：</label>
                    <div id="demo1" class="xm-select-demo"></div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">病情描述：</label>
                    <div class="layui-input-block">
                        <textarea name="description" class="layui-textarea"></textarea>
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
<script src="static/xm-select.js" type="text/javascript" charset="utf-8"></script>
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
            marginLeft: '110px',
            width: '200px',
        },
        name: 'petid',
        data: ${selectPet}
    })
</script>
</body>
</html>