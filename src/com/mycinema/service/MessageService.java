package com.mycinema.service;

import com.mycinema.dao.BaseDao;
import com.mycinema.model.Message;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
    private BaseDao baseDao;

    public MessageService() {
        this.baseDao = new BaseDao();
    }

    // 获取所有公告
    public List<Message> getAllMessages() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM message ORDER BY created_time DESC";
        List<Message> messages = new ArrayList<>();
        try {
            baseDao.openConnection();
            ResultSet resultSet = baseDao.executeQuery(sql);
            while (resultSet.next()) {
                int messageId = resultSet.getInt("message_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                int userId = resultSet.getInt("user_id");
                Timestamp createdTime = resultSet.getTimestamp("created_time");
                messages.add(new Message(messageId, title,content,userId,createdTime));
            }
        } finally {
            baseDao.closeResource();
        }
        return messages;
    }

    // 添加公告
    public int addMessage(String title, String content, int userId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO message (title, content, user_id, created_time) VALUES (?, ?, ?, NOW())";
        return baseDao.executeUpdate(sql, title, content, userId);
    }
}
