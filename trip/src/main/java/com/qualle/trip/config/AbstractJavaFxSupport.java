package com.qualle.trip.config;

import javafx.application.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class AbstractJavaFxSupport extends javafx.application.Application {

    private static String[] savedArgs;

    protected ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(getClass());
        builder.headless(false);
        context = builder.run(savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    protected static void launchApp(Class<? extends AbstractJavaFxSupport> appClass, String[] args) {
        AbstractJavaFxSupport.savedArgs = args;
        Application.launch(appClass, args);
    }
}
