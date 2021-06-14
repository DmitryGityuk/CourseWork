package sample.controllers;

import domain.Expense;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import java.text.ParseException;

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
    void initialize() throws ParseException {
        Expense expense = new Expense();
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });
        expense.setName(addNameExpense.getText());
        //expense.setPrice(addCostExpense.getText());
        addNameExpense.getText();


    }
}
