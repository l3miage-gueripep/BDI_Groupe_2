package fr.uga.miage.m1;

import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EntityScan(basePackages = "fr.uga.miage.m1.entities")
public class MyApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(MyApplication.class, args);
    }
}
