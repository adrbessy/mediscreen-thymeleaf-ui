package com.mediscreen_gui.model;

import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Patient {

  private Integer id;

  @NotBlank(message = "First name is mandatory")
  private String firstname;

  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotBlank(message = "Birthdate is mandatory")
  private String birthdate;

  @NotBlank(message = "Genre is mandatory")
  private String genre;

  private String postalAddress;

  private String phoneNumber;

}
