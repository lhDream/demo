package io.github.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class TestPane extends AnchorPane {

    public TestPane() throws IOException {
        String fxmlName = "testPane.fxml";
        URL url = this.getClass().getResource(fxmlName);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }

    public void clickTest(){
        System.out.println("click test button");
    }

}
