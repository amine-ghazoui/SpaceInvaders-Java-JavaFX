package com.example.controller;


import com.example.dao.PlayerImpl;
import com.example.entities.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable {
    private PlayerImpl playerImp = new PlayerImpl();
    @FXML
    private TableColumn<Player, String> player;

    @FXML
    private TableColumn<Player, Integer> score;

    @FXML
    private TableView<Player> staticsTable;
    ObservableList<Player> players = FXCollections.observableArrayList(
            playerImp.findAll()
    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player.setCellValueFactory(new PropertyValueFactory<>("nomPrenom"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        centerColumnText(player);
        centerColumnText(score);
        staticsTable.setItems(players);
    }
    private <T> void centerColumnText(TableColumn<Player, T> column) {
        column.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Player, T> call(TableColumn<Player, T> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(T item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.toString());
                        }
                        setStyle("-fx-alignment: CENTER;"); // Center align text
                    }
                };
            }
        });
    }
}
