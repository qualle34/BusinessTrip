package com.qualle.trip.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("application")
public class ApplicationProperties {

    private String folderName;
    private ReportProperties report;
}
