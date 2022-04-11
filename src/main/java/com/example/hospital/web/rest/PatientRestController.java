package com.example.hospital.web.rest;


import com.example.hospital.model.Patient;
import com.example.hospital.model.dto.PatientDto;
import com.example.hospital.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/patients")
public class PatientRestController {

    private final PatientService patientService;

    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id)
    {
        this.patientService.deleteById(id);
        if(this.patientService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
                return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> save(@RequestBody PatientDto patientDto)
    {
        return this.patientService.create(patientDto).map(patient -> ResponseEntity.ok().body(patient)).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Patient> edit(@RequestBody PatientDto patientDto,@PathVariable Long id)
    {
        return this.patientService.edit(patientDto,id)
                .map(patient -> ResponseEntity.ok().body(patient))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
}
