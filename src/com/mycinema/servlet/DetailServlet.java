package com.mycinema.servlet;

import com.mycinema.dao.BookDao;
import com.mycinema.model.Book;
import com.mycinema.service.BookService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        BookService bookService =new BookService();
        Book book = bookService.findById(id);
        request.setAttribute("book", book);
        if (book == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "书籍未找到");
            return;
        }
        request.getRequestDispatcher("detail.jsp").forward(request,response);
    }
}
