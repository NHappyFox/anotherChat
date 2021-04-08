package ru.geekbrains.march.chat.server;

import java.sql.*;

public class InMemoryAuthenticationProvider implements AuthenticationProvider {
    private static Statement stmt;
    private static Connection connection;

    private class User {
        private String login;
        private String password;
        private String nickname;

        public User(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:newdatabase.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Невозможно подключиться к БД");
        }

    }

    public static void discconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        try {
            ResultSet resultSet = stmt.executeQuery("select nickname from users where login = '" + login + "' and password = '" + password + "';");
            if (resultSet.next()) {
                return resultSet.getString("nickname");
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void changeNickname(String oldNickname, String newNickname) {

    }
}
