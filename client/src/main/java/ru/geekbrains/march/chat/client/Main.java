package ru.geekbrains.march.chat.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/window.fxml"));
        primaryStage.setTitle("March Chat");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
//hdfhftyhturtujrtu
//nbjhhjjbv
    public static void main(String[] args) {
        launch(args);
    }
}
