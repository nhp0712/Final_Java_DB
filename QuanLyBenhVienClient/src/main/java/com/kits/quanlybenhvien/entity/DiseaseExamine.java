package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
public class DiseaseExamine  {
    Integer IDExamination;
    String ID_DoctorExamination;
    String IDPatient;
    String nameDisease;
}
