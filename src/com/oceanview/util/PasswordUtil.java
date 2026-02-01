package com.oceanview.util;

import java.security.MessageDigest;

public class PasswordUtil {

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean verifyPassword(String plainPassword, String storedPassword) {
        // If you are using plain text (not recommended for production)
        return plainPassword.equals(storedPassword);

        // If you are using BCrypt (recommended)
        // return BCrypt.checkpw(plainPassword, storedPassword);
    }
}
