package com.office.staff.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.staff.entity.Teacher;
import com.office.staff.enumuration.Status;
import com.office.staff.repository.TeacherRepository;

@Service
public class TeacherService {
	
	
	@Autowired
	TeacherRepository teacherRepository;
	

	public Teacher createTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}


	public List<Teacher> listTeacher(List<Teacher> teacher) {
		return teacherRepository.saveAll(teacher);
	}


	public Optional<Teacher> getTeacher(UUID id) {
		return teacherRepository.findById(id);
	}


	public List<Teacher> getAll() {
		return teacherRepository.findAll();
	}


	public Optional<Teacher> getByTeacherPhoneNumName(String phoneNumber, String name) {
		return teacherRepository.getByPhoneName(phoneNumber,name);
	}


	public Teacher updateTeacher(Teacher teacher) {
		return teacherRepository.saveAndFlush(teacher);
	}


	public String deleteTeacher(UUID id) {
		teacherRepository.deleteById(id);;
		return " ";
	}


	public String inactive(UUID id) {
		Teacher teacher = teacherRepository.findById(id).get();
		teacher.setStatus(Status.INACTIVE);
		teacherRepository.save(teacher);
		return "";
	}


	public List<Teacher> getAllActive() {
		List<Teacher> teacher = teacherRepository.findAll();
		List<Teacher> teacher1= new ArrayList<>();
		
		for(Teacher t : teacher) {
			if(t.getStatus().equals(Status.ACTIVE)) {
				teacher1.add(t);
			}
		}
		
		return teacher1;
	}

}
