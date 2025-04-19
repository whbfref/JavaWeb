<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mycinema.model.Borrow"%>
<%@ page import="com.mycinema.service.BorrowService"%>
<%
    BorrowService borrowService = new BorrowService();
    List<Borrow> borrowList = null;
    try {
        borrowList = borrowService.getAllBorrowRecords();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>借阅记录</title>
    <link rel="stylesheet" type="text/css" href="./css/borrowRecords.css"> <!-- 引入CSS -->
    <script src="script.js"></script>
</head>
<body>
<h1>借阅记录</h1>

<table id="borrowTable">
    <thead>
    <tr>
        <th>借阅号</th>
        <th>学生ID</th>
        <th>书号</th>
        <th>借阅日期</th>
        <th>归还日期</th>
        <th>借阅状态</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (borrowList != null) {
            for (Borrow borrow : borrowList) {
    %>
    <tr>
        <td><%= borrow.getRecordId() %></td>
        <td><%= borrow.getUserId() %></td>
        <td><%= borrow.getBookId() %></td>
        <td><%= borrow.getBorrowTime() %></td>
        <td><%= borrow.getReturnTime() %></td>
        <td><%= borrow.getStatus() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
