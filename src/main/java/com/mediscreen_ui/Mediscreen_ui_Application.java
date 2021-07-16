package com.mediscreen_ui;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEncryptableProperties
@SpringBootApplication
@EnableFeignClients("com.mediscreen_ui")
public class Mediscreen_ui_Application {

  public static void main(String[] args) {
    SpringApplication.run(Mediscreen_ui_Application.class, args);
  }
}
