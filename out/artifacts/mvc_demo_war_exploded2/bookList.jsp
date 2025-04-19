<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycinema.dao.BookDao" %>
<%@ page import="com.mycinema.model.Book" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="./css/bookManagement.css">
</head>
<body>
<div class="container">
    <div class="search-bar">
        <input type="text" id="searchTitle" placeholder="查询书名">
        <input type="text" id="searchAuthor" placeholder="查询作者">
        <button id="searchBtn">查询</button>
    </div>

    <%
        // 从请求参数中获取搜索条件
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        BookDao bookDao = new BookDao();
        ArrayList<Book> books;

        if (title != null || author != null) {
            books = bookDao.searchBooks(title != null ? title : "", author != null ? author : "");
        } else {
            books = bookDao.selectAll();
        }

        request.setAttribute("books", books);
    %>

    <c:choose>
        <c:when test="${not empty books}">
            <table>
                <thead>
                <tr>
                    <th>图书ID</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>分类</th>
                    <th>出版时间</th>
                    <th>数量</th>
                    <th>图书封面</th>
                    <th>详情</th>
                </tr>
                </thead>
                <tbody id="bookList">
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.bookname}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td>${book.categoryId}</td>
                        <td>${book.publish_time}</td>
                        <td>${book.translator}</td>
                        <td><img src="imgs/${book.id}.jpg" alt="${book.id}" style="width: 50px;height: 50px"></td>
                        <td><a href="detail?id=${book.id}">查看详情</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>暂无图书信息。</p>
        </c:otherwise>
    </c:choose>
</div>

<script src="./js/bookManagement.js"></script>
<script>
    document.getElementById('searchBtn').onclick = function () {
        var title = document.getElementById('searchTitle').value;
        var author = document.getElementById('searchAuthor').value;
        // 通过 GET 请求重定向到同一页面，带上查询参数
        window.location.href = "?title=" + encodeURIComponent(title) + "&author=" + encodeURIComponent(author);
    };
</script>
</body>
</html>

</html>
