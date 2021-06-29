package com.mediscreen_gui.configuration;

import com.mediscreen_gui.exceptions.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignExceptionConfig {

  @Bean
  public CustomErrorDecoder mCustomErrorDecoder() {
    return new CustomErrorDecoder();
  }

}
