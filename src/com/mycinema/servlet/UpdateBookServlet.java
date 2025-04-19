package com.mycinema.servlet;

import com.mycinema.dao.BookDao;
import com.mycinema.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int movieId = Integer.parseInt(request.getParameter("id"));
        BookDao bookDao = new BookDao();
        Book book = bookDao.selectByIdI(movieId);

        if (book != null) {
            request.setAttribute("book", book);
            RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
            dispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookname=request.getParameter("bookname");
        String author=request.getParameter("author");
        String publisher=request.getParameter("publisher");
        int category_id=Integer.parseInt(request.getParameter("category_id"));
        int translator=Integer.parseInt(request.getParameter("translator"));
        float price=Float.parseFloat(request.getParameter("price"));
        String description=request.getParameter("description");
        int comment_count=Integer.parseInt(request.getParameter("comment_count"));
        int create_userid=Integer.parseInt(request.getParameter("create_userid"));
        int modify_userid=Integer.parseInt(request.getParameter("modify_userid"));
        String publishtime = request.getParameter("publish_time");
        Date publish_time = null;

        if (publishtime != null && !publishtime.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate = sdf.parse(publishtime);
                publish_time = new Date(utilDate.getTime());
            } catch (ParseException e) {
                return;
            }
        }
        Book book = new Book();
                book.setId(bookId);
                book.setBookname(bookname);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setCategoryId(category_id);
                book.setPublish_time(publish_time);
                book.setPrice(price);
                book.setTranslator(translator);
                book.setDescription(description);
                book.setComment_count(comment_count);
                book.setCreate_userid(create_userid);
                book.setModify_userid(modify_userid);
        BookDao bookDao = new BookDao();
        int result = bookDao.updateBook(book);
        if (result > 0) {
            response.sendRedirect("home.jsp");
        }
    }
}

