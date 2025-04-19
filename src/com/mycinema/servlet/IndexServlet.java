package com.mycinema.servlet;

import com.mycinema.model.Book;
import com.mycinema.model.User;
import com.mycinema.service.BookService;
import com.mycinema.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        BookService bookService =new BookService();
        ArrayList<Book> books = bookService.findAll();
        if (books == null) {
            books = new ArrayList<>(); // 如果为空，确保不为 null
        }
        request.setAttribute("books", books);
        UserService userService =new UserService();
        ArrayList<User> users = userService.findAll();
        if (users == null) {
            users = new ArrayList<>(); // 如果为空，确保不为 null
        }
        request.setAttribute("users", users);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
