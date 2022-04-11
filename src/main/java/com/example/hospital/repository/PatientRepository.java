package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    void delete(String name, String surname);

    void deleteById(Long id);



}
