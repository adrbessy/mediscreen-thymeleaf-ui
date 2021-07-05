package com.mediscreen_gui.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTest {

  @Test
  public void simpleEqualsUser() {
    Patient patient = new Patient();
    patient.setAddress("1 road something");
    patient.setPhone("454818048");

    assertThat(patient.getAddress()).isEqualTo("1 road something");
    assertThat(patient.getPhone()).isEqualTo("454818048");
  }



}

