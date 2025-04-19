<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.mycinema.dao.BaseDao" %>
<%
  String title = request.getParameter("title");
  String content = request.getParameter("content");
  String sqlInsert = "INSERT INTO message (title, content, user_id, created_time) VALUES (?, ?, ?, NOW())";

  BaseDao baseDao = new BaseDao();
  try {
    // 打开数据库连接
    baseDao.openConnection();

    // 假设 user_id 为 1，你可以根据实际情况调整
    int userId = 1;

    // 插入新公告
    int result = baseDao.executeUpdate(sqlInsert, title, content, userId);
    if(result > 0) {
      out.print("公告添加成功！");
    } else {
      out.print("公告添加失败！");
    }

    // 关闭资源
    baseDao.closeResource();
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  } catch (SQLException e) {
    e.printStackTrace();
  }
  %>