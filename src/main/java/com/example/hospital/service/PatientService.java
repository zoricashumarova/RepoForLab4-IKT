package com.example.hospital.service;


import com.example.hospital.model.Patient;
import com.example.hospital.model.dto.PatientDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientService {

    //CRUD

    //create
    Patient create(Long id,String  firstName,String lastName,LocalDate birthDate,String email,String phoneNumber,String address,String city,Integer zipCode,String country);

    //update
    //Patient update(String name,String surname);

    //Optional<Patient> edit(Long id, String firstName, String lastName, LocalDate birthDate, String email,String phoneNumber, String address, String city, Integer zipCode, String country);


    //delete
    void deleteById(Long id);

    void delete(String name,String surname);

    List<Patient> findAll();

    Optional<Patient> findById(Long id);

    //Optional<Patient> create(PatientDto patientDto);

    Optional<Patient> create(PatientDto dto);

    Optional<Patient> edit(PatientDto dto, Long id);


}
