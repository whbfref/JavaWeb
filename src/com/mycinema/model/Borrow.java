package com.mycinema.model;

import java.sql.Timestamp;
public class Borrow {
    private int recordId;
    private int userId;
    private int bookId;
    private Timestamp borrowTime;
    private Timestamp returnTime;
    private String status;

    public Borrow() {
    }

    public Borrow(int recordId, int userId, int bookId, Timestamp borrowTime, Timestamp returnTime, String status) {
        this.recordId = recordId;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.status = status;
    }

    public Borrow(int userId, int bookId, Timestamp borrowTime, Object o, String 借阅中) {
    }

    // Getter 和 Setter 方法
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
