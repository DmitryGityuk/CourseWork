package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BillsController {

    @FXML
    private TextField addBalanceBills;

    @FXML
    private Button goBack;

    @FXML
    private Button save;

    @FXML
    void initialize() {
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToWallet();
        });
    }
}
