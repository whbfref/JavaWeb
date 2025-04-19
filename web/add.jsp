<%@ page import="com.mycinema.model.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加图书</title>
    <link rel="stylesheet" href="css/add.css">
</head>
<body>
<div class="container">
    <h1>添加图书</h1>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error-message" style="color:red;"><%= request.getAttribute("errorMessage") %></div>
    <% } %>

    <form action="addBook" method="post">
        <div class="form-group">
            <label for="bookId">编号</label>
            <input type="text" id="bookId" name="bookId" required>
        </div>
        <div class="form-group">
            <label for="bookname">书名</label>
            <input type="text" id="bookname" name="bookname" required>
        </div>
        <div class="form-group">
            <label for="author">作者</label>
            <input type="text" id="author" name="author" required>
        </div>
        <div class="form-group">
            <label for="publisher">出版社</label>
            <input type="text" id="publisher" name="publisher" required>
        </div>
        <div class="form-group">
            <label for="category_id">类别</label>
            <select id="category_id" name="category_id" required>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="translator">库存</label>
            <input type="number" id="translator" name="translator" required>
        </div>
        <div class="form-group">
            <label for="price">价格</label>
            <input type="number" id="price" name="price" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="description">书籍描述</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        <div class="form-group">
            <label for="comment_count">评论数</label>
            <input type="number" id="comment_count" name="comment_count" required>
        </div>
        <div class="form-group">
            <label for="create_userid">创建用户 ID</label>
            <input type="number" id="create_userid" name="create_userid" required>
        </div>
        <div class="form-group">
            <label for="modify_userid">修改用户 ID</label>
            <input type="number" id="modify_userid" name="modify_userid" required>
        </div>
        <div class="form-group">
            <label for="publish_time">出版时间</label>
            <input type="date" id="publish_time" name="publish_time" required>
        </div>
        <button type="submit" class="submit-button">提交图书</button>
    </form>
    <a href="home.jsp">返回主页</a>
</div>
</body>
</html>
