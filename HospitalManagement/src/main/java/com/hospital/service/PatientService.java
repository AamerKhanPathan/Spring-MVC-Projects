package com.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.pojo.PatientPOJO;
import com.hospital.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository repository;

	public PatientPOJO addPatient(String name, String email, long contact, String address, String disease,
			String date) {
		PatientPOJO pojo=repository.addPatient(name,email,contact,address,disease,date);
		return pojo;
	}

	public PatientPOJO searchPatient(int id) {
		PatientPOJO pojo=repository.searchPatient(id);
		
		return pojo;
	}

	public PatientPOJO removePatient(int id) {
		PatientPOJO pojo=repository.removePatient(id);
		return pojo;
	}

	public List<PatientPOJO> getPatients() {
		List<PatientPOJO> patients=repository.getPatients() ;
		return patients;
	}

	

	public PatientPOJO updatepatient(int id, String name, long contact, String email, String deisease, String date) {
		PatientPOJO pojo=repository.updatepatient(id,name,contact,email,deisease,date);
		return pojo;
	} 
}
