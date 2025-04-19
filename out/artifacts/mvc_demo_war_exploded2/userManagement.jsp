<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycinema.dao.UserDao" %>
<%@ page import="com.mycinema.model.User" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="css/userManagement.css">
</head>
<body>
<div class="container">
  <header>
    <h1>图书管理系统</h1>
    <h2>用户管理</h2>
  </header>
  <main>
    <section class="user-list">
      <h3>用户列表</h3>
<%
  UserDao userDao = new UserDao();
  ArrayList<User> users = userDao.selectAll();
  request.setAttribute("users",users);
%>
<c:choose>
  <c:when test="${not empty users}">
      <table>
        <thead>
        <tr>
          <th>用户id</th>
          <th>用户名</th>
          <th>地址</th>
          <th>邮箱</th>
          <th>手机</th>
          <th>身份(1-管理员，0-读者)</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.id}</td>
          <td>${user.username}</td>
          <td>${user.address}</td>
          <td>${user.email}</td>
          <td>${user.phone}</td>
          <td>${user.role}</td>
          <td><button class="btn btn-edit">编辑</button> <button class="btn btn-delete">删除</button></td>
        </tr>
    </c:forEach>
        </tbody>
      </table>
  </c:when>
  <c:otherwise>
    <p>暂无图书信息。</p>
  </c:otherwise>
</c:choose>
    </section>
  </main>
</div>

</body>
</html>
