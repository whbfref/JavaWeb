<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>借阅记录</title>
  <link rel="stylesheet" href="css/borrow.css" >
</head>
<body>
<h1>借阅书籍</h1>
<form action="borrowBook" method="post">
  <label for="recordId">借阅号:</label>
  <input type="text" id="recordId" name="recordId" required><br>
  <label for="userId">用户ID:</label>
  <input type="text" id="userId" name="userId" required><br>
  <label for="bookId">书籍ID:</label>
  <input type="text" id="bookId" name="bookId" required ><br>
  <label for="borrowTime">借阅时间:</label>
  <input type="datetime-local" id="borrowTime" name="borrowTime" required><br>
  <label for="returnTime">还书时间:</label>
  <input type="datetime-local" id="returnTime" name="returnTime" required><br>
  <label for="status">状态:</label>
  <select id="status" name="status">
    <option value="borrowed">借出</option>
    <option value="returned">归还</option>
  </select><br>
  <input type="submit" value="提交借阅记录">
</form>
</body>
</html>
