<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycinema.dao.BookDao" %>
<%@ page import="com.mycinema.model.Book" %>
<%@ page import="com.mycinema.dao.CategoryDao" %>
<%@ page import="com.mycinema.model.Category" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="css/bookinfo.css">
</head>
<body>
<main>
  <section class="book-table">
    <h2>图书类别</h2>
    <%
      CategoryDao categoryDao = new CategoryDao();
      ArrayList<Category> categorys = categoryDao.selectAll();
      request.setAttribute("categorys", categorys);
    %>

    <c:choose>
      <c:when test="${not empty categorys}">
        <table>
          <thead>
          <tr>
            <th>编号</th>
            <th>分类名</th>
            <th>描述</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="category" items="${categorys}">
            <tr>
              <td>${category.id}</td>
              <td>${category.name}</td>
              <td>${category.description}</td>
              <td>
                <button class="edit-btn">编辑</button>
                <button class="delete-btn">删除</button>
              </td>
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
</body>
</html>