package com.mediscreen_gui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, Response response) {
    if (response.status() == 403) {
      return new IsForbiddenException("The patient already exists.");
    }
    return defaultErrorDecoder.decode(methodKey, response);
  }

}
