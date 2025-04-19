package com.mycinema.servlet;

import com.mycinema.model.Category;
import com.mycinema.model.Book;
import com.mycinema.service.CategoryService;
import com.mycinema.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        CategoryService categoryService=new CategoryService();
        ArrayList<Category> categories=categoryService.findAll();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        int bookId= Integer.parseInt(request.getParameter("bookId"));
        String bookname=request.getParameter("bookname");
        String author=request.getParameter("author");
        String publisher=request.getParameter("publisher");
        int category_id=Integer.parseInt(request.getParameter("category_id"));
        int translator=Integer.parseInt(request.getParameter("translator"));
        float price=Integer.parseInt(request.getParameter("price"));
        String description=request.getParameter("description");
        int comment_count=Integer.parseInt(request.getParameter("comment_count"));
        int create_userid=Integer.parseInt(request.getParameter("create_userid"));
        int modify_userid=Integer.parseInt(request.getParameter("modify_userid"));
        String publishtime=request.getParameter("publish_time");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date publish_time=null;
        try {
            publish_time = sdf.parse(publishtime);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        BookService bookService =new BookService();
        Book book =new Book(bookId,bookname,author,publisher,category_id,publish_time,translator,price,description,comment_count,create_userid,modify_userid);
        int count= bookService.addBook(book);
        if(count>0)
        {
            response.sendRedirect("home.jsp");
        }
        else
        {
            request.setAttribute("errorMessage", "图书添加失败，请重试。");
            request.getRequestDispatcher("add.jsp").forward(request,response);
        }
    }
}