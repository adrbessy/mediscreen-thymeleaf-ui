package com.mediscreen_gui;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEncryptableProperties
@SpringBootApplication
@EnableFeignClients("com.mediscreen_gui")
public class Mediscreen_gui_Application {

  public static void main(String[] args) {
    SpringApplication.run(Mediscreen_gui_Application.class, args);
  }
}
