package com.mycinema.model;

import java.sql.Timestamp;

public class Review {
    private int id;
    private int bookId;
    private int rating;
    private String comment;
    private int userId;
    private Timestamp createdAt;

    // 构造方法
    public Review() {}

    public Review(int bookId, int rating, String comment, int userId) {
        this.bookId = bookId;
        this.rating = rating;
        this.comment = comment;
        this.userId = userId;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
