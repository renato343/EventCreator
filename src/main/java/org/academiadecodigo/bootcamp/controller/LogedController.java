package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.service.user.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class LogedController implements Initializable{

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

    private UserService userService;

    @FXML
    private MenuItem logout;

    @FXML
    private MenuItem quit;

    @FXML
    void logout(ActionEvent event) {
        navigation.back();

    }

    @FXML
    void quit(ActionEvent event) {
        System.exit(0);

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
