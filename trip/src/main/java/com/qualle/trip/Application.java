package com.qualle.trip;

import com.qualle.trip.config.AbstractJavaFxSupport;
import com.qualle.trip.config.ViewHolder;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.qualle.trip")
@ComponentScan("com.qualle.trip")
@EnableJpaRepositories("com.qualle.trip.repository")
@EntityScan("com.qualle.trip.model.entity")
public class Application extends AbstractJavaFxSupport {

    @Autowired
    private ViewHolder mainView;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Business Trip");
        stage.getIcons().add(new Image("/icon.png"));
        stage.setScene(new Scene(mainView.getView()));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }
}
