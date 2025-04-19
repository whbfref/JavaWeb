package com.mycinema.servlet;

import com.mycinema.model.User;
import com.mycinema.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        int role=Integer.parseInt(request.getParameter("role"));
        UserService userService=new UserService();

        User user=userService.login(username,password,role);
        if(user!=null)
        {
            request.getSession().setAttribute("user",user);
            response.sendRedirect("home.jsp");
        }
        else
        {
            request.setAttribute("msg","用户名或者密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
