package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.academiadecodigo.bootcamp.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Rui on 07-04-2017.
 */
public class PanelController implements Initializable {

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
}
