package com.example.hospital.repository.impl;

import com.example.hospital.bootstrap.DataHolder;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryImpl  {


    //add
    public Patient save(Patient p)
    {
        if(p==null || p.getFirstName().isEmpty() || p.getLastName().isEmpty())
        {
            return null;
        }
        DataHolder.patients.removeIf(r->(r.getFirstName().equals(p.getFirstName()) &&
                r.getLastName().equals(p.getLastName())));
        DataHolder.patients.add(p);
        return p;
    }

    //edit
    public Patient edit(Patient p)
    {
        if(p==null || p.getFirstName().isEmpty() || p.getLastName().isEmpty())
        {
            return null;
        }
        DataHolder.patients.removeIf(r->(r.getFirstName().equals(p.getFirstName()) &&
                r.getLastName().equals(p.getLastName())));
        DataHolder.patients.add(p);
        return p;
    }


    //delete
    public void delete(String name,String surname)
    {
        DataHolder.patients.removeIf(r->r.getFirstName().equals(name) && r.getLastName().equals(surname));
    }


    public List<Patient> findAll() {
        return DataHolder.patients;
    }

}
