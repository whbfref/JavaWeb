<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改图书</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin: 15px 0;
        }
        .form-group label {
            display: block;
            color: #555;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn {
            background-color: #5cb85c;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>修改图书信息</h1>
    <form action="update" method="post">
        <input type="hidden" name="bookId" value="${book.id}">

        <div class="form-group">
            <label for="bookname">书名</label>
            <input type="text" id="bookname" name="bookname" value="${book.bookname}" required>
        </div>

        <div class="form-group">
            <label for="author">作者</label>
            <input type="text" id="author" name="author" value="${book.author}" required>
        </div>

        <div class="form-group">
            <label for="publisher">出版社</label>
            <input type="text" id="publisher" name="publisher" value="${book.publisher}" required>
        </div>

        <div class="form-group">
            <label for="category_id">类别 ID</label>
            <input type="number" id="category_id" name="category_id" value="${book.categoryId}" required>
        </div>

        <div class="form-group">
            <label for="translator">库存</label>
            <input type="number" id="translator" name="translator" value="${book.translator}" required>
        </div>

        <div class="form-group">
            <label for="price">价格</label>
            <input type="number" step="0.01" id="price" name="price" value="${book.price}" required>
        </div>

        <div class="form-group">
            <label for="description">描述</label>
            <input type="text" id="description" name="description" value="${book.description}" required>
        </div>

        <div class="form-group">
            <label for="comment_count">评论数量</label>
            <input type="number" id="comment_count" name="comment_count" value="${book.comment_count}" required>
        </div>

        <div class="form-group">
            <label for="create_userid">创建用户 ID</label>
            <input type="number" id="create_userid" name="create_userid" value="${book.create_userid}" required>
        </div>

        <div class="form-group">
            <label for="modify_userid">修改用户 ID</label>
            <input type="number" id="modify_userid" name="modify_userid" value="${book.modify_userid}" required>
        </div>

        <div class="form-group">
            <label for="publish_time">出版时间</label>
            <input type="date" id="publish_time" name="publish_time" value="${book.publish_time}" required>
        </div>
        <button type="submit" class="btn">提交修改</button>
    </form>
</div>

</body>
</html>
