<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<script>
    function toggleDropdown() {
        const dropdown = document.getElementById("dropdown");
        dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
    }

    function logout() {

        window.location.href = "login.html";
    }

    function switchAccount() {
        alert("切换账号的功能尚未实现。");
    }
    window.onclick = function(event) {
        if (!event.target.matches('.avatar')) {
            const dropdown = document.getElementById("dropdown");
            if (dropdown.style.display === "block") {
                dropdown.style.display = "none";
            }
        }
    }
</script>
<body>
<div class="container">
    <header class="header">
        <div class="user-info">
            <img src="imgs/logo.jpg" alt="用户头像" class="avatar" onclick="toggleDropdown()">
            <div class="dropdown" id="dropdown">
                <span class="dropdown-item" ><a href="login">退出登录</a></span><br>
                <span class="dropdown-item" onclick="switchAccount()"><a href="#">切换账号</a></span>
            </div>
        </div>
    </header>
    <div class="main">
        <nav class="sidebar">
            <ul>
                <li><a href="home.jsp" target="contentFrame">系统首页</a></li>
                <li><a href="borrowRecords.jsp" target="contentFrame">借阅信息</a></li>
                <li><a href="announcements.jsp" target="contentFrame">公告信息</a></li>
                <li><a href="userManagement.jsp" target="contentFrame">用户管理</a></li>
                <li><a href="bookList.jsp" target="contentFrame">图书信息</a></li>
                <li><a href="category.jsp" target="contentFrame">分类信息</a></li>
                <li><a href="bookinfo.jsp" target="contentFrame">图书管理</a></li>
            </ul>
        </nav>
        <div class="content">
            <iframe src="home.jsp" name="contentFrame" style="width:100%; height:500px; border:none;"></iframe>
        </div>
    </div>
</div>
</body>
</body>
</html>