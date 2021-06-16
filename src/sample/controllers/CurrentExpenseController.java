package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import java.io.*;
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
    private MenuItem Home;

    @FXML
    private MenuItem Sport;

    @FXML
    private MenuItem Transport;

    @FXML
    private MenuItem Entertainment;

    @FXML
    private MenuItem Food;

    @FXML
    private MenuItem Travel;

    @FXML
    void initialize() throws ParseException {
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });
    }

    @FXML
    void innFile(ActionEvent event) {
        try {
            String newLine = "\n";
            FileWriter fileWriter = new FileWriter("src/files/currentExpense.txt", true);
            fileWriter.write("Name expense: " + addNameExpense.getText());
            fileWriter.write(", cost of expense: " + addCostExpense.getText());
            fileWriter.write(", date expense: " + addDateExpense.getText());
            fileWriter.write(", category expense: " + choiceCategory.getText() + newLine);
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
