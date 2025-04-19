<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycinema.dao.BookDao" %>
<%@ page import="com.mycinema.model.Book" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="css/bookinfo.css">
</head>
<body>
<main>
  <section class="book-table">
    <h2>图书列表</h2><a href="addBook" class="add">添加图书</a>
<%
  BookDao bookDao = new BookDao();
  ArrayList<Book> books = bookDao.selectAll();
  request.setAttribute("books", books);
%>

<c:choose>
  <c:when test="${not empty books}">
    <table>
      <thead>
      <tr>
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>分类</th>
        <th>出版时间</th>
        <th>剩余数量</th>
        <th>价格</th>
        <th>描述</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
    <c:forEach var="book" items="${books}">
      <tr>
        <td>${book.id}</td>
        <td>${book.bookname}</td>
        <td>${book.author}</td>
        <td>${book.publisher}</td>
        <td>${book.categoryId}</td>
        <td>${book.publish_time}</td>
        <td>${book.translator}</td>
        <td>${book.price}</td>
        <td>${book.description}</td>
        <td>
          <button class="edit-btn"><a href="update?id=${book.id}">编辑</a></button>
          <button class="delete-btn"><a href="deleteMovie?id=${book.id}" onclick="return confirm('确定要删除这本书吗？');">删除</a></button>
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
