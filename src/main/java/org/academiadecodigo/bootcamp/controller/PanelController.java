package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.Event;
import org.academiadecodigo.bootcamp.service.event.EventService;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Rui on 07-04-2017.
 */
public class PanelController implements Initializable {

    @FXML
    private TableView enlistedtable;

    @FXML
    private TableColumn localcolumn;

    @FXML
    private TableColumn typecolumn;

    @FXML
    private TableColumn periodcolumn;

    @FXML
    private TableColumn nplayerscolumn;

    @FXML
    private Button on;

    @FXML
    private Label labelusername;

    @FXML
    private Label labelpassword;

    @FXML
    private TextField username;

    @FXML
    private TextField password;


    private EventService eventService;

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    Navigation navigation;

    public void logout(ActionEvent actionEvent) {
        navigation.loadScreen("LoginController");
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void back(ActionEvent actionEvent) {
        navigation.loadScreen("Menu");
    }

    public void viewenlisted(ActionEvent actionEvent) {

        enlistedtable.setVisible(true);

        List<Event> eventstotal = eventService.findAll();

        ObservableList<Event> data = FXCollections.observableArrayList();

        for (Event el : eventstotal) {
            data.add(el);
        }

        localcolumn.setCellValueFactory(new PropertyValueFactory<Event, String>("local"));


        typecolumn.setCellValueFactory(
                new PropertyValueFactory<Event, String>("type")
        );

        periodcolumn.setCellValueFactory(
                new PropertyValueFactory<Event, String>("period")
        );

        nplayerscolumn.setCellValueFactory(
                new PropertyValueFactory<Event, Integer>("numberOfPlayers")
        );

        enlistedtable.setItems(data);

    }

    public void modifyuserinfo(ActionEvent actionEvent) {

        on.setVisible(true);
        labelusername.setVisible(true);
        labelpassword.setVisible(true);
        username.setVisible(true);
        password.setVisible(true);
    }

    public void on(ActionEvent actionEvent){


        on.setVisible(false);
        labelusername.setVisible(false);
        labelpassword.setVisible(false);
        username.setVisible(false);
        password.setVisible(false);
    }

}

