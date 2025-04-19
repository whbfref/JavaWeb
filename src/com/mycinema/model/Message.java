package com.mycinema.model;
import java.sql.Timestamp;
public class Message {
    private int messageId;
    private String title;
    private String content;
    private int userId;
    private Timestamp createdTime;

    // 构造函数
    public Message(int messageId, String title, String content, int userId, Timestamp createdTime) {
        this.messageId = messageId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createdTime = createdTime;
    }

    // Getters 和 Setters
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
}
