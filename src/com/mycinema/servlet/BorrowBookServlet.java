package com.mycinema.servlet;
import com.mycinema.model.Borrow;
import com.mycinema.service.BorrowService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/borrowBook")
public class BorrowBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("borrow.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int recordId=Integer.parseInt(request.getParameter("recordId"));
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        String borrowTime= request.getParameter("borrowTime");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Timestamp time=null;
        try {
            time = (Timestamp) sdf.parse(borrowTime);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        String returnTime=request.getParameter("returnTime");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Timestamp time1=null;
        try {
            time1 = (Timestamp) sdf1.parse(returnTime);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        String status=request.getParameter("status");
        BorrowService borrowService = new BorrowService();
        Borrow borrow = new Borrow(recordId,userId,bookId,time,time1,status);
        int count= borrowService.insertBorrow(borrow);
        if(count>0)
        {
            response.sendRedirect("home.jsp");
        }
        else
        {
            request.setAttribute("errorMessage", "借阅失败， 请稍后重试。");
            request.getRequestDispatcher("borrow.jsp").forward(request, response);
        }
    }
}
