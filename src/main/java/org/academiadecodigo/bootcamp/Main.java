package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main extends Application {

    HibernateSessionManager hibernateSessionManager;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation navigation;

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig/spring-config.xml");
        navigation = applicationContext.getBean(Navigation.class);

        hibernateSessionManager = applicationContext.getBean("hibernateSessionManager",HibernateSessionManager.class);

        navigation.setStage(primaryStage);
        navigation.loadScreen("LoginController");


    }

    @Override
    public void stop() throws Exception {
        hibernateSessionManager.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
