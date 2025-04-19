package com.mycinema.servlet;

import com.mycinema.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteMovie")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        BookService bookService =new BookService();
        bookService.remove(id);
        response.sendRedirect("bookinfo.jsp");
    }
}
