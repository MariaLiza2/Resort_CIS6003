package com.oceanview.service;

import com.oceanview.dao.UserDAO;
import com.oceanview.model.User;
import com.oceanview.util.PasswordUtil;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {
        String hashed = PasswordUtil.hashPassword(password);
        return userDAO.validateUser(username, hashed);
    }
}
