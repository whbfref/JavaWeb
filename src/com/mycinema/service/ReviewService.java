package com.mycinema.service;

import com.mycinema.model.Review;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    /**
     * 添加评论
     *
     * @param bookId        书籍ID
     * @param score         评分
     * @param reviewContent 评论内容
     * @param userId        用户ID
     * @return 插入的行数（1 表示成功，0 表示失败）
     * @throws SQLException 如果数据库操作失败
     */
    public int addReview(int bookId, int score, String reviewContent, int userId) throws SQLException {
        String sql = "INSERT INTO review (book_id, rating, comment, user_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 设置 SQL 参数
            stmt.setInt(1, bookId);
            stmt.setInt(2, score);
            stmt.setString(3, reviewContent);
            stmt.setInt(4, userId);

            // 执行插入操作
            return stmt.executeUpdate();
        }
    }

    /**
     * 根据书籍ID获取所有评论
     *
     * @param bookId 书籍ID
     * @return 评论列表
     * @throws SQLException 如果数据库操作失败
     */
    public List<Review> getReviewsByBookId(int bookId) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review WHERE book_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Review review = new Review();
                    review.setId(rs.getInt("id"));
                    review.setBookId(rs.getInt("book_id"));
                    review.setRating(rs.getInt("rating"));
                    review.setComment(rs.getString("comment"));
                    review.setUserId(rs.getInt("user_id"));
                    review.setCreatedAt(rs.getTimestamp("created_at"));
                    reviews.add(review);
                }
            }
        }
        return reviews;
    }
}
