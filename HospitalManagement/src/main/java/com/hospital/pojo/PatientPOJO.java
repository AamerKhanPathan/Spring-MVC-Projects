package com.hospital.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PatientPOJO {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private int id;
	private String name;
	private String email;
	private long contact;
	private String address;
	private String disease;
	private String nextVisitDate;
}
