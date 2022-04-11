package com.example.hospital.model.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PatientDto {


    private String firstName;

    private String lastName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    private String email;

    private String phoneNumber;

    private String address;

    private String city;

    private int zipCode;

    private String country;


    public PatientDto(String firstName, String lastName,
                   LocalDate birthDate, String email,
                   String phoneNumber, String address,
                   String city, int zipCode, String country) {

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

    public PatientDto() {

    }


}
