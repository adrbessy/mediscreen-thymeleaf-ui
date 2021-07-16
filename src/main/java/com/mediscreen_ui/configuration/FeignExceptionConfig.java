package com.mediscreen_ui.configuration;

import com.mediscreen_ui.exceptions.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignExceptionConfig {

  @Bean
  public CustomErrorDecoder mCustomErrorDecoder() {
    return new CustomErrorDecoder();
  }

}
