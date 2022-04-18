package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;

public class CardController {

    ObservableList<String> rowList = FXCollections.observableArrayList();

    File fileObject = new File("src/files/creditCards.txt");

    @FXML
    private TextField addNameCard;

    @FXML
    private TextField addRequisitesCard;

    @FXML
    private TextField addBalanceCard;

    @FXML
    private Button goBack;

    @FXML
    private ListView<String> listCards;

    @FXML
    private CheckBox typeCurrency;


    @FXML
    void initialize() {
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });
    }

    @FXML
    void saveToFile(ActionEvent event) {
        try {
            String newLine = "\n";
            FileWriter fileWriter = new FileWriter("src/files/creditCards.txt", true);
            fileWriter.write(newLine + "Name Card: " + addNameCard.getText());
            fileWriter.write(", Balance Card: " + addBalanceCard.getText());
            fileWriter.write(", Requisites card: " + addRequisitesCard.getText());
            fileWriter.write(", Type currency: RUB" + newLine);
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void innFile(ActionEvent event) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileObject), "UTF8"));
            String line = reader.readLine();
            rowList.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    rowList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listCards.setItems(rowList);
    }
}

