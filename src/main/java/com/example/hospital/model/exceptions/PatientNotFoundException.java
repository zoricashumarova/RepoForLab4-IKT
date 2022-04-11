package com.example.hospital.model.exceptions;

public class PatientNotFoundException extends RuntimeException{


    public PatientNotFoundException(Long id) {
        super(String.format("Product with id: %d was not found", id));
    }

}
