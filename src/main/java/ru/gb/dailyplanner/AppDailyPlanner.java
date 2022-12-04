package ru.gb.dailyplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppDailyPlanner extends Application {

    public static void main(String[] args) { launch(); }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AppDailyPlanner.class.getResource("dailyPlanner.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Еженедельник");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
