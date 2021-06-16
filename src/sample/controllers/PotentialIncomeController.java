package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileWriter;

public class PotentialIncomeController {
    @FXML
    private TextField addNameIncome;

    @FXML
    private Button goBack;

    @FXML
    private TextField addValueIncome;

    @FXML
    void saveToFile(ActionEvent event) {
        try {
            String newLine = "\n";
            FileWriter fileWriter = new FileWriter("src/files/potentialIncome.txt", true);
            fileWriter.write("Name income: " + addNameIncome.getText());
            fileWriter.write(", value income: " + addValueIncome.getText() + newLine);
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
