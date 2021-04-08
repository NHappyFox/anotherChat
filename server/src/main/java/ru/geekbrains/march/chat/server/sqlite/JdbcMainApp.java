package ru.geekbrains.march.chat.server.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMainApp {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();

        } finally {
            discconnect();
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
}
