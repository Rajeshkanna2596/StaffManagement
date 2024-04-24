package com.office.staff.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.office.staff.entity.Teacher;
import com.office.staff.service.TeacherService;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	
	
	@PostMapping("/saveTeacher")
	public Teacher createTeacher (@RequestBody Teacher teacher) {
		return teacherService.createTeacher(teacher);
	}
	
	@PostMapping("/listTeacher")
	public List<Teacher> listTeacher (@RequestBody List<Teacher> teacher) {
		return teacherService.listTeacher(teacher);
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Teacher> getTeacher(@PathVariable UUID id) {
		return teacherService.getTeacher(id);
	}
	 
	@GetMapping("/getAll")
	public List<Teacher> getTeachers(){
		return teacherService.getAll();
	}
	

	@GetMapping("/getByPhoneNumberName")
	public Optional<Teacher> getPhoneNumberName (@RequestParam (value ="phoneNumber",required = true)String phoneNumber,
			@RequestParam (value ="name",required = false)String name){
		return teacherService.getByTeacherPhoneNumName(phoneNumber,name);
	}
	
	@GetMapping("/getAllActive")
	public List<Teacher> getAllActive(){
		return teacherService.getAllActive();
	}
	
	
	
	@PutMapping ("/update")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		return teacherService.updateTeacher(teacher);
	}
	
	@PutMapping ("/inactive/{id}")
	public String inactive(@PathVariable UUID id) {
		 teacherService.inactive(id);
		 return "inactivated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTeacher (@PathVariable UUID id) {
		teacherService.deleteTeacher(id);
		return "deleted successfully";
	}
	

}
