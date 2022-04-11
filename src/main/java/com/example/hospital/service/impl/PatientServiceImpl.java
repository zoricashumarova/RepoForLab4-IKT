package com.example.hospital.service.impl;

import com.example.hospital.model.Patient;
import com.example.hospital.model.dto.PatientDto;
import com.example.hospital.model.exceptions.PatientNotFoundException;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository=patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return this.patientRepository.findById(id);
    }



    @Override
    public Optional<Patient> create(PatientDto dto) {
        if(dto==null)
        {
            throw new IllegalArgumentException();
        }
        Patient p=new Patient(dto);
        patientRepository.save(p);
        return Optional.of(p);
    }

    @Override
    public Optional<Patient> edit(PatientDto dto, Long id) {
        Patient patient=this.patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException(id));


        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setBirthDate(dto.getBirthDate());
        patient.setEmail(dto.getEmail());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setAddress(dto.getAddress());
        patient.setCity(dto.getCity());
        patient.setZipCode(dto.getZipCode());
        patient.setCountry(dto.getCountry());

        return Optional.of(this.patientRepository.save(patient));
    }


    @Override
    public Patient create(Long id, String  firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, String address, String city, Integer zipCode, String country) {
        if(firstName==null || firstName.isEmpty() || lastName==null || lastName.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        Patient p=new Patient(id,firstName,lastName,birthDate,email,phoneNumber,address,city,zipCode,country);
        patientRepository.save(p);
        return p;
    }



   /*
   @Override
    public Patient update(String name, String surname) {
        if(name==null || name.isEmpty() || surname==null || surname.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        Patient p=new Patient(name,surname);
        patientRepository.save(p);
        return p;
    }
  */

    /*
    @Override
    public Optional<Patient> edit(PatientDto2 dto, Long id) {
        Patient patient=this.patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException(id));

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setBirthDate(birthDate);
        patient.setEmail(email);
        patient.setPhoneNumber(phoneNumber);
        patient.setAddress(address);
        patient.setCity(city);
        patient.setZipCode(zipCode);
        patient.setCountry(country);

        return Optional.of(this.patientRepository.save(patient));

    }


     */

    @Override
    public void deleteById(Long id) {

        this.patientRepository.deleteById(id);
    }

    @Override
    public void delete(String name, String surname) {
        if(name==null || name.isEmpty() || surname==null || surname.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        patientRepository.delete(name,surname);
    }
}
