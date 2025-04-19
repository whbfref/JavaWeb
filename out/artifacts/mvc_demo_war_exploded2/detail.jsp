<%@ page import="com.mycinema.model.Book" %>
<%@ page import="com.mycinema.dao.BookDao" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/detail.css">
    <title>图书详情</title>
    <style>
        /* 这里是新增的样式 */
        .rating {
            font-size: 1.5em;
            color: #FFD700; /* 金色 */
            display: flex;
        }

        .rating span {
            cursor: pointer; /* 鼠标悬停时变为手型 */
        }

        .comments-section {
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 10px;
        }

        .comment {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        .comment-box {
            margin-top: 10px;
        }

        .comment-box textarea {
            width: 100%;
            height: 80px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 5px;
        }

        .comment-box button {
            margin-top: 10px;
            padding: 10px;
            border: none;
            background-color: #007BFF;
            color: white;
            cursor: pointer;
            border-radius: 5px;
        }

        .comment-box button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
    String idParam = request.getParameter("id");
    int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;
    BookDao bookDao = new BookDao();
    Book book = bookDao.selectByIdI(id); // 方法获取书籍对象
    request.setAttribute("book", book); // 将书籍对象存入请求范围

    // 示例评论数据，实际应用中应从数据库获取
    List<String> comments = (List<String>) request.getAttribute("comments");
%>
<div class="container">
    <div class="book-cover">
        <img src="imgs/${book.id}.jpg" alt="${book.id}">
    </div>
    <div class="book-details">
        <h1 class="book-title">书名：<c:out value='${book.bookname}'/></h1>
        <h2 class="book-author">作者：<c:out value='${book.author}'/></h2>
        <p class="book-description">
            描述：<c:out value='${book.description}'/>
        </p>
        <div class="info">
            <span class="book-publisher">出版社：<c:out value='${book.publisher}'/></span><br />
            <span class="book-price">价格：¥<c:out value='${book.price}'/></span><br />
            <span class="book-publish-date">出版日期：<c:out value='${book.publish_time}'/></span><br/>
            <span class="book-publisher"><a href="home.jsp">返回首页</a></span>
        </div>
        <!-- 添加借阅和购买按钮 -->
        <div class="book-actions">
            <button onclick="borrowBook(${book.id})"><a href="borrowBook?id=${book.id}">借阅</a></button>
            <a href="purchase.jsp?id=${book.id}" class="purchase-button">去购买</a>
        </div>
        <script type="text/javascript">
            function borrowBook(bookId) {
                let userId = <c:out value='${sessionScope.userId}'/>; // 假设用户ID存储在session中
                fetch('borrowBook', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ bookId: bookId, userId: userId })
                })
                    .then(response => {
                        if (response.ok) {
                            alert('借阅成功！');
                            // 更新页面或执行其他操作
                            // 例如，您可以重新加载页面或更新借阅状态
                        } else {
                            return response.json().then(error => {
                                alert('借阅失败: ' + error.message);
                            });
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert('借阅请求失败，请稍后再试。');
                    });
            }
        </script>
        <!-- 添加评分部分 -->
        <div class="rating">
            <span data-value="1">★</span>
            <span data-value="2">★</span>
            <span data-value="3">★</span>
            <span data-value="4">★</span>
            <span data-value="5">★</span>
        </div>

        <!-- 评论部分 -->
        <div class="comments-section">
            <h3>评论</h3>
            <div id="commentsContainer">
                <c:forEach var="comment" items="${comments}">
                    <div class="comment">
                        <c:out value="${comment}"/>
                    </div>
                </c:forEach>
            </div>
            <div class="comment-box">
                <textarea placeholder="添加你的评论..."></textarea>
                <button onclick="submitComment()">提交评论</button>
            </div>
        </div>
    </div>
</div>

<script>
    let selectedRating = 0;

    // 评分功能
    document.querySelectorAll('.rating span').forEach(function(star) {
        star.addEventListener('click', function() {
            selectedRating = this.getAttribute('data-value');
            document.querySelectorAll('.rating span').forEach(s => {
                s.classList.toggle('active', s.getAttribute('data-value') <= selectedRating);
            });
        });
    });

    function submitComment() {
        const commentText = document.querySelector('.comment-box textarea').value;
        const bookId = document.querySelector('.comment-box').getAttribute('data-book-id');

        if (commentText && selectedRating > 0) {
            // 创建表单数据
            const formData = new FormData();
            formData.append('bookId', bookId);
            formData.append('rating', selectedRating);
            formData.append('comment', commentText);

            // 发送 POST 请求到服务器
            fetch('/submit-review', {
                method: 'POST',
                body: new URLSearchParams(formData)
            })
                .then(response => response.text())
                .then(result => {
                    alert(result); // 显示服务器返回的消息
                    // 更新前端显示
                    const commentsContainer = document.getElementById("commentsContainer");
                    const newComment = document.createElement("div");
                    newComment.className = "comment";
                    newComment.textContent = commentText + " (评分: " + selectedRating + ")";
                    commentsContainer.prepend(newComment);

                    // 重置评论框和评分
                    document.querySelector('.comment-box textarea').value = "";
                    selectedRating = 0;
                    document.querySelectorAll('.rating span').forEach(s => s.classList.remove('active'));
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert("提交评论时发生错误");
                });
        } else {
            alert("请填写评论内容并选择评分");
        }
    }
</script>

</body>
</html>
<script>
    fetch('submitCommentServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ bookId: ${book.id}, comment: commentText, rating: selectedRating })
    })
        .then(response => response.json())
        .then(data => {
        })
        .catch(error => {
            console.error('Error:', error);
        });

</script>