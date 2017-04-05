package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.user.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="cadetTextField"
    private TextField cadetTextField; // Value injected by FXMLLoader

    @FXML // fx:id="emailTextField"
    private TextField emailTextField; // Value injected by FXMLLoader

    @FXML // fx:id="registerLink"
    private Hyperlink registerLink; // Value injected by FXMLLoader

    @FXML // fx:id="emailLabel"
    private Label emailLabel; // Value injected by FXMLLoader

    @FXML // fx:id="verificationText"
    private Label verificationText; // Value injected by FXMLLoader

    private boolean isLogin = true;

    Navigation navigation;

    private UserService userService;

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    public void onLogin(ActionEvent actionEvent) {

        if (isLogin == true) {

            if (userService.findByName(cadetTextField.getText()) == null) {
                verificationText.setText(" USER NOT FOUND");
                verificationText.setVisible(true);


            } else {


                if (!userService.authenticate(cadetTextField.getText(), passwordField.getText())) {
                    verificationText.setText(" WRONG PASSWORD");
                    verificationText.setVisible(true);


                } else {
                    verificationText.setText("WELCOME");
                    verificationText.setVisible(true);
                    navigation.loadScreen("Menu");

                }
            }
        } else {



            if (userService.findByMail(emailTextField.getText()) == null) {

                if(cadetTextField.getText().isEmpty() || passwordField.getText().isEmpty() || emailTextField.getText().isEmpty()){

                    verificationText.setText("All blank spaces, SHALL NOT BE EMPTY");
                    verificationText.setVisible(true);

                }else {

                    userService.addUser(new User(passwordField.getText(), emailTextField.getText(), cadetTextField.getText()));
                    verificationText.setText("Account Sucessfuly created");
                    verificationText.setVisible(true);

                }

            } else {

                verificationText.setText("USER ALREADY EXIST");
                verificationText.setVisible(true);

            }
        }

    }

    @FXML
    void onRegister(ActionEvent event) {

        if (isLogin) {
            verificationText.setVisible(false);
            registerLink.setText("CLOSE");
            emailLabel.setVisible(true);
            emailTextField.setVisible(true);
            loginButton.setText("REGISTER");
            isLogin = false;
        } else {
            registerLink.setText("REGISTER");
            verificationText.setVisible(false);
            emailLabel.setVisible(false);
            emailTextField.setVisible(false);
            loginButton.setText("LOGIN");
            isLogin = true;
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
