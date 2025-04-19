<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div class="login-container">
    <div class="login-box">
        <h2>登录</h2>
        <form id="loginForm" action="login" method="post">
            <div class="input-group">
                <label for="identity">身份：</label>
                <select id="identity" name="role" required>
                    <option value="" disabled selected>请选择身份</option>
                    <option value="0">管理员</option>
                    <option value="1">学生</option>
                </select>
            </div>
            <div class="input-group">
                <label for="username">用户名：</label>
                <input type="text" id="username" name="username" required placeholder="请输入用户名">
            </div>
            <div class="input-group">
                <label for="password">密码：</label>
                <input type="password" id="password" name="password" required placeholder="请输入密码">
            </div>
            <div class="button-group">
                <button type="submit">登录</button>
                <a href="reginter">还没有账号，立即去注册</a>
            </div>
            <div class="error-message" id="error-message"></div>
        </form>
        <h3 style="color: red">${msg}</h3>
    </div>
</div>
</body>
</html>
