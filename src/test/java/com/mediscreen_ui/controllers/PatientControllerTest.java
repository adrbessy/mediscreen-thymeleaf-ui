package com.mediscreen_ui.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen_ui.model.Patient;
import com.mediscreen_ui.proxies.PatientProxy;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PatientProxy patientProxyMock;


  @Test
  public void testHome() throws Exception {
    Patient patient = new Patient();
    patient.setGiven("adrien");
    patient.setFamily("Gaiveron");
    patient.setDob("2004-06-18");
    patient.setSex("M");
    List<Patient> patients = new ArrayList<>();
    patients.add(patient);

    when(patientProxyMock.getPatients()).thenReturn(patients);

    mockMvc.perform(get("/patient/list"))
        .andExpect(status().isOk()).andExpect(view().name("patient/list"));
  }

  @Test
  public void testShowAddPatientForm() throws Exception {
    mockMvc.perform(get("/patient/add"))
        .andExpect(status().isOk()).andExpect(view().name("patient/add"));
  }

  @Test
  public void testValidate() throws Exception {
    Patient patient = new Patient();
    patient.setGiven("adrien");
    patient.setFamily("Gaiveron");
    patient.setDob("2004-06-18");
    patient.setSex("M");
    List<Patient> patients = new ArrayList<>();
    patients.add(patient);

    when(patientProxyMock.createPatient(patient)).thenReturn(true);
    when(patientProxyMock.getPatients()).thenReturn(patients);

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/patient/validate")
        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
        .content(new ObjectMapper().writeValueAsString(patient));
    this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testShowUpdateForm() throws Exception {
    Patient patient = new Patient();
    patient.setId(1);
    patient.setGiven("adrien");
    patient.setFamily("Gaiveron");
    patient.setDob("2004-06-18");
    patient.setSex("M");

    when(patientProxyMock.getPatient(1)).thenReturn(patient);

    mockMvc.perform(get("/patient/update/{id}", "1"))
        .andExpect(status().isOk()).andExpect(view().name("patient/update"));
  }

  @Test
  public void testUpdatePatient() throws Exception {
    Patient patient = new Patient();
    patient.setId(1);
    patient.setGiven("adrien");
    patient.setFamily("Gaiveron");
    patient.setDob("2004-06-18");
    patient.setSex("M");
    List<Patient> patients = new ArrayList<>();
    patients.add(patient);

    doNothing().when(patientProxyMock).updatePatient(1, patient);
    when(patientProxyMock.getPatients()).thenReturn(patients);

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/patient/update/{id}", "1")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
        .content(new ObjectMapper().writeValueAsString(patient));
    this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
  }



}
