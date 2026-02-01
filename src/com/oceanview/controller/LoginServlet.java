package com.oceanview.controller;

import com.oceanview.dao.UserDAO;
import com.oceanview.model.User;
import com.oceanview.util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Debugging: See what is coming from the form
        System.out.println("Login Attempt - Username: " + username);

        UserDAO userDao = new UserDAO();
        User user = userDao.getUserByUsername(username);

        // Debugging: See if the user was found in the DB
        if (user == null) {
            System.out.println("Auth Failed: User not found in database.");
        } else {
            System.out.println("User found: " + user.getUsername());
            System.out.println("Stored Password Hash/Value: " + user.getPassword());
        }

        // Logic check
        if (user != null && PasswordUtil.verifyPassword(password, user.getPassword())) {
            System.out.println("Login Success!");
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);
            session.setAttribute("role", user.getRole());

            resp.sendRedirect("dashboard.jsp");
        } else {
            System.out.println("Login Failed: Password mismatch or null user.");
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}