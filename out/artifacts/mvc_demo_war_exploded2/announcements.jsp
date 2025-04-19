<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.mycinema.dao.BaseDao" %>
<%
  String sqlSelect = "SELECT * FROM message ORDER BY created_time DESC";
  String sqlInsert = "INSERT INTO message (title, content, user_id, created_time) VALUES (?, ?, ?, NOW())";

  BaseDao baseDao = new BaseDao();
  List<String> announcements = new ArrayList<String>();
  try {
    baseDao.openConnection();
    ResultSet resultSet = baseDao.executeQuery(sqlSelect);
    while (resultSet.next()) {
      String title = resultSet.getString("title");
      String content = resultSet.getString("content");
      announcements.add(title + ": " + content);
    }

    baseDao.closeResource();
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  } catch (SQLException e) {
    e.printStackTrace();
  }
%>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>图书管理系统公告栏</title>
  <link rel="stylesheet" href="./css/announcements.css">
  <script>
    function addAnnouncement() {
      let titleInput = document.getElementById('announcement-title');
      let contentInput = document.getElementById('new-announcement');

      if (titleInput.value.trim() === '' || contentInput.value.trim() === '') {
        alert('标题和内容不能为空！');
        return;
      }
      let xhr = new XMLHttpRequest();
      xhr.open('POST', 'addAnnouncement.jsp', true);
      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          alert('公告添加成功！');
          location.reload(); // 刷新页面以显示新公告
        }
      };
      xhr.send('title=' + encodeURIComponent(titleInput.value) + '&content=' + encodeURIComponent(contentInput.value));
    }
  </script>
</head>
<body>
<div class="announcement-bar">
  <h2>公告栏</h2>
  <ul class="announcements" id="announcements-list">
    <%
      for (String announcement : announcements) {
    %>
    <li><%= announcement %></li>
    <%
      }
    %>
  </ul>

  <div id="admin-interface">
    <h3>管理公告</h3>
    <input type="text" id="announcement-title" placeholder="公告标题"/><br>
    <textarea id="new-announcement" placeholder="输入新公告内容..."></textarea><br>
    <button onclick="addAnnouncement()">添加公告</button>
  </div>
</div>
</body>
</html>
