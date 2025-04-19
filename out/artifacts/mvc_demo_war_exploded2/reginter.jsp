<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/reginter.css">
  <title>注册页面</title>
</head>
<body>
<div id="inter">
  <div class="container">
    <h2>注册</h2>
    <form id="registrationForm" method="post" action="reginter">
      <div class="form-group">
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="role">用户身份:</label>
        <select id="role" name="role" required>
          <option value="0">管理员</option>
          <option value="1">读者</option>
        </select>
      </div>
      <div class="form-group">
        <label for="email">电子邮件:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="phone">手机:</label>
        <input type="phone" id="phone" name="phone" required>
      </div>
      <div class="form-group">
        <label for="address">地址:</label>
        <input type="address" id="address" name="address" required>
      </div>
      <div class="form-group">
        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>
      </div>
      <div class="form-group">
        <label for="confirmPassword">确认密码:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
      </div>
      <button type="submit">注册</button>
      <a href="home.jsp">返回</a>
    </form>
    <div id="message" class="message">
      <%= request.getAttribute("registerMessage") != null ? request.getAttribute("registerMessage") : "" %>
    </div>
  </div>
</div>
</body>
</html>
