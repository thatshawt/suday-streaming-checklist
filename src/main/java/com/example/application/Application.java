package com.example.application;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        try {
            URL applicationProp = Application.class.getClassLoader()
                                    .getResource("application.properties");
            //before we start the application we must append the password into the application.properties file
            String propFileContent = Files.readString(Paths.get(applicationProp.toURI()));
            if (propFileContent.contains("vaadin.productionMode=true")) { //cus lmao
                String content = Files.readString(Path.of("/var/password/certpass.txt"));
                String password = content.strip();//idk just incase

                //apparently spring boot supports properties this way
                //thanks https://www.baeldung.com/properties-with-spring
                System.setProperty("server.ssl.key-store-password", password);//finally
                System.setProperty("server.ssl.enabled", "true");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        SpringApplication.run(Application.class, args);
    }

}
