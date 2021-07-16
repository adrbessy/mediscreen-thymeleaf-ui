package com.mediscreen_ui.proxies;

import com.mediscreen_ui.model.Patient;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mediscreen-patient", url = "http://mediscreen-patient:9010")
public interface PatientProxy {

  @GetMapping("/patient")
  Patient getPatient(@RequestParam("id") Integer id);

  @GetMapping("/patients")
  List<Patient> getPatients();

  @PostMapping("/patient")
  boolean createPatient(@RequestBody Patient patient);

  @PutMapping("/patient/{id}")
  void updatePatient(@PathVariable("id") Integer id, @RequestBody Patient patient);

}
