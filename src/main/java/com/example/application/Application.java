package com.example.application;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "mytodo")
//@PWA(name = "My Todo", shortName = "My Todo", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        //before we start the application we must append the password into the application.properties file
        String production = System.getProperty("vaadin.productionMode");
        if(production.equals("true")) {
            try {
                String content = Files.readString(Path.of("/var/password/certpass.txt"));
                String password = content.strip();//idk just incase
                System.setProperty("server.ssl.key-store-password", password);//finally

                System.setProperty("server.ssl.enabled", "true");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SpringApplication.run(Application.class, args);
    }

}
