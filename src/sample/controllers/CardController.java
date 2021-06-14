package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

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
    void initialize(){
        goBack.setOnMouseClicked(event -> {
            goBack.getScene().getWindow().hide();
            ChangeWindow changeWindow = new ChangeWindow();
            changeWindow.changeWindowToSecond();
        });

    }
}
