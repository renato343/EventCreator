package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.Event;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Table;

import java.net.URL;
import java.util.ResourceBundle;

public class LogedController implements Initializable {

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    Navigation navigation;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @FXML
    private Button viewevents;

    @FXML
    private Button controlpanels;

    @FXML
    private Button createevents;

    @FXML
    private Button createnow;

    @FXML
    private SplitMenuButton filterperiod;

    @FXML
    private SplitMenuButton filterlocal;

    @FXML
    private SplitMenuButton filtertype;

    @FXML
    private TableView eventtable;

    @FXML
    private MenuItem logout;

    @FXML
    private MenuItem quit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void createevent(ActionEvent actionEvent) {
        filterperiod.setVisible(true);
        filtertype.setVisible(true);
        filterlocal.setVisible(true);
        createnow.setVisible(true);
        eventtable.setVisible(false);
    }

    public void viewevents(ActionEvent actionEvent) {
        filterperiod.setVisible(true);
        filtertype.setVisible(true);
        filterlocal.setVisible(true);
        eventtable.setVisible(true);
        createnow.setVisible(false);
        Event event = new Event("Football","Morning","Campo1");
        eventtable.getItems().add(event);
    }

    public void controlpanel(ActionEvent actionEvent) {
        navigation.loadScreen("ControlPanel");
    }

    public void filterperiod(ActionEvent actionEvent) {
        //Seletor de periodo temporal
    }

    public void filterlocal(ActionEvent actionEvent) {
        //Seletor de local
    }

    public void filtertype(ActionEvent actionEvent) {
        //Seletor de tipo
    }

    public void createnow(ActionEvent actionEvent) {
        //Inserir evento na base de dados
    }

    public void logout(ActionEvent actionEvent) {
        navigation.loadScreen("LoginController");
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
