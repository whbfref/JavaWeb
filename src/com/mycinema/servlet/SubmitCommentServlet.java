package com.mycinema.servlet;

import com.mycinema.model.Review;
import com.mycinema.service.ReviewService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/submitCommentServlet")
public class SubmitCommentServlet extends HttpServlet {
    private ReviewService reviewService;

    @Override
    public void init() throws ServletException {
        reviewService = new ReviewService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应的编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取表单数据
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int score = Integer.parseInt(request.getParameter("score"));
        String reviewContent = request.getParameter("review_content");
        int userId = 1; // 假设当前用户 ID 为 1

        try {
            // 添加评论
            int result = reviewService.addReview(bookId, score, reviewContent, userId);
            if (result > 0) {
                // 添加成功，获取所有评论并重定向到书籍详情页面
                List<Review> reviews = reviewService.getReviewsByBookId(bookId);
                request.setAttribute("reviews", reviews); // 将评论列表存入请求范围
                request.getRequestDispatcher("detail.jsp?id=" + bookId).forward(request, response);
            } else {
                // 添加失败，返回错误信息
                response.getWriter().write("提交评论失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("请求处理失败");
        }
    }
}