package com.example.hospital.model;


import com.example.hospital.model.dto.PatientDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String email;

    private String phoneNumber;

    private String address;

    private String city;

    private int zipCode;

    private String country;


    public Patient(Long id, String firstName, String lastName,
                   LocalDate birthDate, String email,
                   String phoneNumber, String address,
                   String city, int zipCode, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }


    public Patient(PatientDto dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.birthDate = dto.getBirthDate();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.address = dto.getAddress();
        this.city = dto.getCity();
        this.zipCode = dto.getZipCode();
        this.country = dto.getCountry();
    }

    public Patient(String firstName,String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Patient() {

    }
}
