package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;

public class SecondController {

    ObservableList<String> currentExpenseList = FXCollections.observableArrayList();
    ObservableList<String> potentialIncomeList = FXCollections.observableArrayList();
    ObservableList<String> potentialExpenseList = FXCollections.observableArrayList();

    File currentExpenseObject = new File("src/files/currentExpense.txt");
    File incomeObject = new File("src/files/potentialIncome.txt");
    File potentialExpenseObject = new File("src/files/potentialExpense.txt");


    @FXML
    private Button addWallet;

    @FXML
    private Button addCard;

    @FXML
    private ImageView pictureWallet;

    @FXML
    private ImageView pictureCard;

    @FXML
    private ListView<String> currentExpense;

    @FXML
    private ListView<String> potentialIncome;

    @FXML
    private ListView<String> potentialExpense;

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
            stage.setScene(new Scene(rootSecond, 900, 600));
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
            stage.setScene(new Scene(rootSecond, 900, 600));
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
            stage.setScene(new Scene(rootSecond, 900, 600));
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
            stage.setScene(new Scene(rootSecond, 900, 600));
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
            stage.setScene(new Scene(rootSecond, 900, 600));
            stage.show();
        });
    }

    @FXML
    void showCurrentExpense(MouseEvent event) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(currentExpenseObject), "UTF8"));
            String line = reader.readLine();
            currentExpenseList.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    currentExpenseList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentExpense.setItems(currentExpenseList);
    }

    @FXML
    void showPotentialExpense(MouseEvent event) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(potentialExpenseObject), "UTF8"));
            String line = reader.readLine();
            potentialExpenseList.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    potentialExpenseList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        potentialExpense.setItems(potentialExpenseList);
    }

    @FXML
    void showPotentialIncome(MouseEvent event) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(incomeObject), "UTF8"));
            String line = reader.readLine();
            potentialIncomeList.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    potentialIncomeList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        potentialIncome.setItems(potentialIncomeList);
    }
}
