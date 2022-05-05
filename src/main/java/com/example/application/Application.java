package com.example.application;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
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
//@PWA(name = "My Todo", shortName = "My Todo", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
@Theme(value = "mytodo")
//@Theme(themeClass = Lumo.class, variant = Lumo.DARK)
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        try {
            InputStream applicationPropStream = Application.class.getClassLoader()
                    .getResourceAsStream("application.properties");

            DataInputStream inputStream = new DataInputStream(applicationPropStream);
            String propFileContent = new String(inputStream.readAllBytes());

            inputStream.close();
            //before we start the application we must append the password into the application.properties file
            if (propFileContent.contains("vaadin.productionMode=true")) { //cus lmao
                String content = Files.readString(Path.of("/run/secrets/certpass.txt"));
                String password = content.strip();//idk just incase

                //apparently spring boot supports properties this way
                //thanks https://www.baeldung.com/properties-with-spring
                System.setProperty("server.ssl.key-store-password", password);//finally
                System.setProperty("server.ssl.enabled", "true");
                System.setProperty("server.ssl.key-store","/run/secrets/certstore.p12");
                /*
                server.ssl.protocol=TLS
                server.ssl.key-store-type=pkcs12
                server.ssl.key-alias=springboot
                */
                System.setProperty("server.ssl.protocol","TLS");
                System.setProperty("server.ssl.key-store-type","pkcs12");
                System.setProperty("server.ssl.key-alias","springboot");

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        SpringApplication.run(Application.class, args);
    }

}















