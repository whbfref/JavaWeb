package com.mycinema.model;

import java.util.Date;

public class Book {
    private int id;
    public Book(int id, String bookname, String author, String publisher, int categoryId, Date publish_time, int translator, float price, String description, int comment_count, int create_userid, int modify_userid) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.publisher = publisher;
        this.categoryId = categoryId;
        this.publish_time = publish_time;
        this.translator = translator;
        this.price = price;
        this.description = description;
        this.comment_count = comment_count;
        this.create_userid = create_userid;
        this.modify_userid = modify_userid;
    }

    public Book()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public int getTranslator() {
        return translator;
    }

    public void setTranslator(int translator) {
        this.translator = translator;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getCreate_userid() {
        return create_userid;
    }

    public void setCreate_userid(int create_userid) {
        this.create_userid = create_userid;
    }

    public int getModify_userid() {
        return modify_userid;
    }

    public void setModify_userid(int modify_userid) {
        this.modify_userid = modify_userid;
    }

    private String bookname;
    private String author;
    private String publisher;
    private int categoryId;
    private Date publish_time;
    private int translator;
    private float price;
    private String description;
    private int comment_count;
    private int create_userid;
    private int modify_userid;

}
