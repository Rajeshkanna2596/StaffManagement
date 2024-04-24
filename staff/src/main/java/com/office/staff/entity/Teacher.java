package com.office.staff.entity;

import java.sql.SQLType;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.office.staff.enumuration.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teachers")//sql
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@GenericGenerator(name="UUID2",type=org.hibernate.id.uuid.UuidGenerator.class)
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(name="teacher_id",updatable = false,nullable = false)
	private UUID id;
	
	@Column(name="teacher_name")
	private String name;
	
	
	@Column(name="teacher_address")
	private String address;
	
	
	@Column(name="teacher_phonenumber")
	private String phoneNumber;
	
	@Column(name="teacher_salary")
	private int salary;
	
	@Column(name ="teacher_status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;
}
	
	


