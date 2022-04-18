package sample.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeWindow {

    void changeWindowToSecond() {
        Stage stage = new Stage();
        Parent rootSecond = null;
        try {
            rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/secondWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("BudgetCoin");
        stage.setScene(new Scene(rootSecond, 900, 600));
        stage.show();
    }
}
