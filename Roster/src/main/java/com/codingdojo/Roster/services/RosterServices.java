package com.codingdojo.Roster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.Roster.models.ContactInfo;
import com.codingdojo.Roster.models.Dorms;
import com.codingdojo.Roster.models.Students;
import com.codingdojo.Roster.repository.ContactInfoRepository;
import com.codingdojo.Roster.repository.DormsRepository;
import com.codingdojo.Roster.repository.StudentsRepository;

@Service
public class RosterServices {
	@Autowired
	public StudentsRepository studentRepo;
	@Autowired
	public ContactInfoRepository contactRepo;
	@Autowired
	public DormsRepository dormRepo;
	
	public Students createStudent(Students student) {
        return studentRepo.save(student);
    }
	
	public ContactInfo createContactInfo(ContactInfo contactInfo) {
        return contactRepo.save(contactInfo);
    }
	public Dorms createDorms(Dorms dorm) {
        return dormRepo.save(dorm);
    }
	public List<Students> allStudents(){
		return studentRepo.findAll();
	}
	public List<ContactInfo> allContactInfo(){
		return contactRepo.findAll();
	}
	public List<Dorms> allDorms(){
		return dormRepo.findAll();
	}

	public StudentsRepository getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(StudentsRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	public ContactInfoRepository getContactRepo() {
		return contactRepo;
	}

	public void setContactRepo(ContactInfoRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	public DormsRepository getDormRepo() {
		return dormRepo;
	}

	public void setDormRepo(DormsRepository dormRepo) {
		this.dormRepo = dormRepo;
	}
	public Students findStudent(Long student_id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(student_id).orElse(null);
	}

	public Dorms findDorm(Long dorm_id) {
		// TODO Auto-generated method stub
		return dormRepo.findById(dorm_id).orElse(null);
	}

}
