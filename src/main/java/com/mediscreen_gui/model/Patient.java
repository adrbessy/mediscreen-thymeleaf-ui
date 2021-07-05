package com.mediscreen_gui.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {

  private Integer id;

  @NotBlank(message = "Given name is mandatory")
  private String given;

  @NotBlank(message = "Family Name is mandatory")
  private String family;

  @Pattern(regexp = "^[0-9]{4}(-)[0-9]{2}(-)[0-9]{2}$", message = "The birthdate has to get this format yyyy-mm-dd")
  private String dob;

  @NotBlank(message = "Sex is mandatory")
  private String sex;

  // postal address
  private String address;

  private String phone;

}
