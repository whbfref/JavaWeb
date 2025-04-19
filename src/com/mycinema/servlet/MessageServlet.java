package com.mycinema.servlet;

import com.mycinema.model.Message;
import com.mycinema.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/messages")
public class MessageServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        messageService = new MessageService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            List<Message> messages = messageService.getAllMessages();
            request.setAttribute("messages",messages );
            request.getRequestDispatcher("announcements.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to retrieve messages.");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int userId = 1;

        try {
            int result = messageService.addMessage(title, content, userId);
            if (result > 0) {
                response.sendRedirect("messages"); // 使用重定向返回消息列表
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to add message.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request.");
        }
    }

}

