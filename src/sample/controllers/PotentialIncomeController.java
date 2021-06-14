package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PotentialIncomeController {
    @FXML
    private TextField addNameIncome;

    @FXML
    private Button goBack;

    @FXML
    private TextField addValueIncome;

    @FXML
    private Button save;

    @FXML
    void initialize() {
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });
    }
}
