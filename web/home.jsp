<%@ page import="com.mycinema.dao.BaseDao" %>
<%@ page import="com.mycinema.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycinema.dao.BookDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书</title>
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/home1.css">
    <style>
        .book1 {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        #container1 {
            display: flex;
            flex-direction: column; /* 设置为垂直方向 */
            gap: 20px; /* 设置 container 之间的间距 */
        }
        .recommendations, .rankings, .book-list {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .book-list {
            display: flex;
            flex-wrap: wrap; /* 支持换行 */
            gap: 20px; /* 设置 gap 控制卡片间距 */
        }
        .book-card {
            border: 1px solid #ccc;
            border-radius: 8px;
            width: calc(25% - 20px); /* 每行四个，减去间距 */
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px; /* 卡片底部间距 */
        }
        .book-card img {
            width: 100%; /* 图像宽度适应 */
            height: auto;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }
        .book-card-body {
            padding: 15px;
        }
        .book-card-title {
            font-size: 1.25em;
            margin: 0;
        }
        .book-card-text {
            margin: 5px 0;
        }
        @media (max-width: 768px) {
            .book-card {
                width: calc(50% - 20px); /* 小屏幕下每行两个 */
            }
        }
        @media (max-width: 480px) {
            .book-card {
                width: 100%; /* 超小屏下每行一个 */
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="recommendations">
        <h2>推荐榜单</h2>
        <ul>
            <li>朝花夕拾</li>
            <li>彷徨</li>
            <li>呐喊</li>
            <li>西游记</li>
            <li>镜花缘</li>
            <li>格列佛游记</li>
            <li>云边有个小卖部</li>
        </ul>
    </div>
    <div id="box" class="carousel">
        <ul class="imglist">
            <li><img src="imgs/l4.jpg" /></li>
            <li><img src="imgs/l1.png" /></li>
            <li><img src="imgs/l2.png" /></li>
            <li><img src="imgs/l3.jpg" /></li>
            <li><img src="imgs/l4.jpg" /></li>
            <li><img src="imgs/l1.png" /></li>
        </ul>
        <span class="left">&lt;</span>
        <span class="right">&gt;</span>
        <ul class="btnlist">
            <li class="current"></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

    <div class="rankings">
        <h2>借阅排行榜</h2>
        <ul>
            <li>安徒生童话</li>
            <li>活着</li>
            <li>四世同堂</li>
            <li>白杨礼赞</li>
            <li>飘</li>
            <li>基督伯爵</li>
            <li>茶花女</li>
        </ul>
    </div>
</div>
<div class="book1">
<div id="container1">
    <h1>图书</h1>
<div class="book-list">

    <%
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.selectAll();
        request.setAttribute("books", books);
    %>

    <c:choose>
        <c:when test="${not empty books}">
            <c:forEach var="book" items="${books}">
                <div class="book-card">
                    <img src="imgs/${book.id}.jpg" lt="${book.id}">
                    <div class="book-card-body">
                        <h5 class="book-card-title">${book.bookname}</h5>
                        <p class="book-card-text">作者: ${book.author}</p>
                        <p class="book-card-text">出版社: ${book.publisher}</p>
                        <p class="book-card-text">价格: ${book.price}</p>
                        <p class="book-card-text">出版时间: ${book.publish_time}</p>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>暂无图书信息。</p>
        </c:otherwise>
    </c:choose>
</div></div></div>
<script src="js/home.js"></script>
</body>
</html>
