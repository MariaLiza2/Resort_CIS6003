package com.oceanview.dao;

import com.oceanview.model.User;
import com.oceanview.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User getUserByUsername(String username) {

        User user = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public User validateUser(String username, String password) {
        User user = getUserByUsername(username);

        // Check if user exists and if the password matches
        if (user != null && com.oceanview.util.PasswordUtil.verifyPassword(password, user.getPassword())) {
            return user;
        }

        return null; // Return null if authentication fails
    }
}
