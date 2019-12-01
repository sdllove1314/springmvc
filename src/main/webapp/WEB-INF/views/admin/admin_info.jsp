<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>网站后台管理模版</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css"/>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">修改资料</li>
        <li>修改密码</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" action="updateUserInfo" method="post"
                  style="width: 90%;padding-top: 20px;">

                <div class="layui-form-item">
                    <label class="layui-form-label">ID：</label>
                    <div class="layui-input-block">
                        <input type="text" name="userid"  autocomplete="off"
                               class="layui-input layui-disabled" value=${LoginUserInfo.userid}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="userInfo.userName" required autocomplete="off"
                               class="layui-input layui-disabled" value=${loginUser.username}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别：</label>
                    <c:if test="${LoginUserInfo.usersex=='女'}">
                        <div class="layui-input-block">
                            <input type="radio" name="usersex" value="男" title="男">
                            <input type="radio" name="usersex" value="女" title="女" checked="">
                        </div>
                    </c:if>
                    <c:if test="${LoginUserInfo.usersex=='男'}">
                        <div class="layui-input-block">
                            <input type="radio" name="usersex" value="男" title="男"  checked="">
                            <input type="radio" name="usersex" value="女" title="女">
                        </div>
                    </c:if>
                    <c:if test="${LoginUserInfo.usersex==null}">
                        <div class="layui-input-block">
                            <input type="radio" name="usersex" value="男" title="男">
                            <input type="radio" name="usersex" value="女" title="女">
                        </div>
                    </c:if>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">电话：</label>
                    <div class="layui-input-block">
                        <input type="text" name="usertel" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input" value=${LoginUserInfo.usertel}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ：</label>
                    <div class="layui-input-block">
                        <input type="text" name="userqq" required  lay-verify="required" placeholder="请输入QQ" autocomplete="off" class="layui-input" value="${LoginUserInfo.userqq}">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注：</label>
                    <div class="layui-input-block">
                        <textarea id="userInfo.userNote" name="usernote" placeholder="请输入内容" class="layui-textarea" ></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-tab-item">
            <form class="layui-form" action="updateUserPassword" method="post"
                  style="width: 90%;padding-top: 20px;">
                <input name="userid" style="display: none" value=${loginUser.userid}>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名"
                               autocomplete="off" class="layui-input" value=${loginUser.username}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="Password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">重复密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="userpassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminPassword">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>document.getElementById("userInfo.userNote").value="${LoginUserInfo.usernote}"</script>
<script>
    //Demo
    layui.use(['form','element'], function(){
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交

    });
</script>

</body>
</html>