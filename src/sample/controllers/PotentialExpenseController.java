package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileWriter;

public class PotentialExpenseController {

    @FXML
    private TextField addNameExpense;

    @FXML
    private Button goBack;

    @FXML
    private TextField addCostExpense;

    @FXML
    private TextField addPriorityExpense;

    @FXML
    void saveToFile(ActionEvent event) {
        try {
            String newLine = "\n";
            FileWriter fileWriter = new FileWriter("src/files/potentialExpense.txt", true);
            fileWriter.write("Name expense: " + addNameExpense.getText());
            fileWriter.write(", price expense: " + addCostExpense.getText());
            fileWriter.write(", priority expense: " + addPriorityExpense.getText() + newLine);
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });
    }
}
