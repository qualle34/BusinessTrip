package com.qualle.trip.config;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.qualle.trip")
@ComponentScan("com.qualle.trip")
@EntityScan("com.qualle.trip.model.entity")
public class Application extends AbstractJavaFxSupport {

    @Value("${ui.title}")
    private String windowTitle;

    @Qualifier("mainView")
    @Autowired
    private ControllerConfig.ViewHolder mainView;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(mainView.getView()));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }
}
