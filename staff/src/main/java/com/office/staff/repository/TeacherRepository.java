package com.office.staff.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.office.staff.entity.Teacher;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, UUID>{

	
	@Query(value="select * from teachers t where t.teacher_phonenumber =:phoneNumber or t.teacher_name=:name",nativeQuery = true)
	Optional<Teacher> getByPhoneName(@Param ("phoneNumber")String phoneNumber,@Param("name") String name);

}
