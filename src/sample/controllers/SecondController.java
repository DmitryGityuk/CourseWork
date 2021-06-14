package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondController {

    @FXML
    private Button addWallet;

    @FXML
    private Button addCard;

    @FXML
    private ImageView pictureWallet;

    @FXML
    private ImageView pictureCard;

    @FXML
    private Button addCurrentExpenses;

    @FXML
    private Button addPotentialIncome;

    @FXML
    private Button addPotentialExpenses;


    @FXML
    void initialize() {
        addWallet.setOnMouseClicked(event -> {
            addWallet.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent rootSecond = null;
            try {
                rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/wallet.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("BudgetCoin");
            stage.setScene(new Scene(rootSecond, 700, 400));
            stage.show();
        });

        addCard.setOnMouseClicked(event -> {
            addCard.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent rootSecond = null;
            try {
                rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/cards.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("BudgetCoin");
            stage.setScene(new Scene(rootSecond, 700, 400));
            stage.show();
        });

        addCurrentExpenses.setOnAction(event -> {
            addCurrentExpenses.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent rootSecond = null;
            try {
                rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/currentExpenses.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("BudgetCoin");
            stage.setScene(new Scene(rootSecond, 700, 400));
            stage.show();
        });

        addPotentialExpenses.setOnMouseClicked(event -> {
            addCurrentExpenses.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent rootSecond = null;
            try {
                rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/potentialExpenses.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("BudgetCoin");
            stage.setScene(new Scene(rootSecond, 700, 400));
            stage.show();
        });

        addPotentialIncome.setOnMouseClicked(event -> {
            addCurrentExpenses.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent rootSecond = null;
            try {
                rootSecond = FXMLLoader.load(getClass().getResource("/sample/fxml/potentialIncome.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("BudgetCoin");
            stage.setScene(new Scene(rootSecond, 700, 400));
            stage.show();
        });
    }
}
