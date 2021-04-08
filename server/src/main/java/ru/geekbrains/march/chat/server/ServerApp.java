package ru.geekbrains.march.chat.server;

import static ru.geekbrains.march.chat.server.sqlite.JdbcMainApp.connect;
import static ru.geekbrains.march.chat.server.sqlite.JdbcMainApp.discconnect;

public class ServerApp {
    public static void main(String[] args) {
        new Server(8189);

        try {
            connect();

        } finally {
            discconnect();
        }
    }
}
