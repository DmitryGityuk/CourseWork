package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelUI.WalletUI;

import java.io.IOException;

public class WalletController {

    @FXML
    private Button addBankCard;

    @FXML
    private TextField addNameWallet;

    @FXML
    private Button goBack;

    @FXML
    private Button addBills;

    @FXML
    private Button save;

    @FXML
    private ListView<?> listWallets;

    @FXML
    void initialize() {
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });

        addBankCard.setOnMouseClicked(event -> {
            addBankCard.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent rootSecond = null;
            try {
                rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/bankCardToWallet.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("BudgetCoin");
            stage.setScene(new Scene(rootSecond, 700, 400));
            stage.show();
        });

        addBills.setOnMouseClicked(event -> {
            addBills.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent rootSecond = null;
            try {
                rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/bills.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("BudgetCoin");
            stage.setScene(new Scene(rootSecond, 700, 400));
            stage.show();
        });

        addNameWallet.setOnAction(event -> {
            WalletUI walletUI = new WalletUI();
            walletUI.addNameWallet();
        });
    }
}