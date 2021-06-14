package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CardController {

    @FXML
    private TextField addNameCard;

    @FXML
    private TextField addRequisitesCard;

    @FXML
    private TextField addBalanceCard;

    @FXML
    private Button goBack;

    @FXML
    private Button save;

    @FXML
    private ListView<?> listCards;

    @FXML
    private CheckBox typeCurrency;

    @FXML
    void initialize(){
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });

    }
}
