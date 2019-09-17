package com.roma.mainproject;

import com.roma.mainproject.service.StorageService;
import com.roma.mainproject.serviceImplement.storage.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MainprojectApplication {

    @PostConstruct
    void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MainprojectApplication.class, args);
    }
    CommandLineRunner init(StorageService storageService){
        return (args -> {
            storageService.deleteAll();
            storageService.init();
        });
    }

}
