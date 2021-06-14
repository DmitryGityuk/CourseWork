package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class CurrentExpenseController {

    @FXML
    private TextField addNameExpense;

    @FXML
    private Button goBack;

    @FXML
    private TextField addCostExpense;

    @FXML
    private TextField addDateExpense;

    @FXML
    private SplitMenuButton choiceCategory;

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
