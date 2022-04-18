package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;

public class WalletController {

    ObservableList<String> rowList = FXCollections.observableArrayList();

    File fileObject = new File("src/files/wallets.txt");

    @FXML
    private TextField addNameWallet;

    @FXML
    private ListView<String> listWallets;

    @FXML
    private Button goBack;

    @FXML
    private TextField addValueCard;

    @FXML
    private TextField addBills;

    @FXML
    private TextField addNameBankCard;

    @FXML
    void initialize() {
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });
    }

    @FXML
    void showFile(ActionEvent event) {
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
    }

    @FXML
    void innFile(ActionEvent event) {
        listWallets.setItems(rowList);
        try {
            String newLine = "\n";
            FileWriter fileWriter = new FileWriter("src/files/wallets.txt", true);
            fileWriter.write(newLine + "Name wallet: " + addNameWallet.getText() + newLine);
            fileWriter.write("Name card in wallet: " + addNameBankCard.getText() + newLine);
            fileWriter.write("Balance card in wallet: " + addValueCard.getText() + newLine);
            fileWriter.write("Bills on the wallet: " + addBills.getText() + newLine);
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}