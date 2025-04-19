package com.mycinema.ui;
import com.mycinema.model.Book;
import com.mycinema.service.BookService;
import com.mycinema.service.ReviewService;

import java.sql.SQLException;
import java.util.ArrayList;
public class MyBookManager {
    public static void main(String[] args) {
//        System.out.println("----------------------");
//        System.out.println("名称    作者     出版社");
//        BookService bookService =new BookService();
//        ArrayList<Book> list= bookService.findAll();
//        for(Book book :list)
//        {
//            System.out.println(book.getBookname()+"    "+ book.getAuthor()+"    "+ book.getPublisher());
//        }
        ReviewService reviewService = new ReviewService();
        int bookId = 1; // 书籍ID
        int score = 5; // 评分
        String reviewContent = "这是一本好书！"; // 评论内容
        int userId = 1; // 用户ID

        try {
            int result = reviewService.addReview(bookId, score, reviewContent, userId);
            if (result > 0) {
                System.out.println("评论添加成功！");
            } else {
                System.out.println("评论添加失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
