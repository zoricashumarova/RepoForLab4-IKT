package com.example.hospital.bootstrap;

import com.example.hospital.model.Patient;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Patient> patients=new ArrayList<>();
}
