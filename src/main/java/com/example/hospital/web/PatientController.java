package com.example.hospital.web;


import com.example.hospital.model.Patient;
import com.example.hospital.model.dto.PatientDto;
import com.example.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String getPatientPage(@RequestParam(required = false)String error, Model model)
    {
        if(error!=null || !error.isEmpty())
        {
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);

        }
        List<Patient> patients=this.patientService.findAll();
        model.addAttribute("patients",patients);
        model.addAttribute("bodyContent",patients);
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePageById(@PathVariable Long id)
    {
        this.patientService.deleteById(id);
        return "redirect:/patients";
    }

    @PostMapping("/add")
    public String savePatient(@RequestBody PatientDto dto2)
    {
        this.patientService.create(dto2);
        return "redirect:/patients";

    }

    @PutMapping("/edit/{id}")
    public String editPatient(@RequestBody PatientDto dto2, @PathVariable Long id)
    {
        if(id!=null)
        {
            this.patientService.edit(dto2, id);
        }
        else {
            throw new IllegalArgumentException();
        }
        return "redirect:/patients";

    }


}
