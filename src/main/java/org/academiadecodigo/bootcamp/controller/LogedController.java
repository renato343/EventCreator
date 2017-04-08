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
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.event.EventService;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Table;

import java.net.URL;
import java.util.ResourceBundle;

public class LogedController implements Initializable {

    Navigation navigation;

    private UserService userService;

    private EventService eventService;

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private Label welcomelabel;

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

    @FXML
    private TableColumn localcolumn;

    @FXML
    private TableColumn typecolumn;

    @FXML
    private TableColumn periodcolumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Event> data =
                FXCollections.observableArrayList(
                        new Event("Football", "Morning", "Campo1"),
                        new Event("Football", "Morning", "Campo2")
                );


        localcolumn.setCellValueFactory(new PropertyValueFactory<Event,String>("local"));


        typecolumn.setCellValueFactory(
                new PropertyValueFactory<Event,String>("type")
        );

        periodcolumn.setCellValueFactory(
                new PropertyValueFactory<Event,String>("period")
        );

        eventtable.setItems(data);


        welcomelabel.setText("Welcome "+ userService.getUserAuth());
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

        Event event = new Event();
        event.setLocal(filterlocal.getText());
        event.setPeriod(filterperiod.getText());
        event.setType(filtertype.getText());

        eventService.addEvent(event);

    }

    public void logout(ActionEvent actionEvent) {
        navigation.loadScreen("LoginController");
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
