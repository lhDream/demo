package io.github.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        primaryStage.setScene(new Scene(new TestPane()));
        primaryStage.show();
    }

}
