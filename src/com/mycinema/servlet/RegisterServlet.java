package com.mycinema.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycinema.model.User;
import com.mycinema.service.UserService;

@WebServlet("/reginter")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("reginter.jsp").forward(request, response);
    }

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        int role = Integer.parseInt(request.getParameter("role"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String confirmPassword = request.getParameter("confirmPassword");
        String address=request.getParameter("address");
        User user = new User();
        user.setUsername(username);
        user.setRole(role);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);// 注意：实际应用中需要对密码进行加密处理
user.setAddress(address);
        UserService userService = new UserService();
        String message;

        try {
            int isRegistered = userService.register(user, confirmPassword);
            if (isRegistered!=0) {
                message = "注册成功！";
            } else {
                message = "注册失败！";
            }
        } catch (IllegalArgumentException e) {
            message = e.getMessage(); // 捕获业务逻辑中的异常
        }

        request.setAttribute("registerMessage", message);
        request.getRequestDispatcher("reginter.jsp").forward(request, response); // 转发到注册页面
    }
}

