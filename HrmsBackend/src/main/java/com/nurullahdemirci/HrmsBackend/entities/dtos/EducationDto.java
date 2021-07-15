package com.nurullahdemirci.HrmsBackend.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String schoolType;
	
	private String branch;
	
	private String school;
	
	private LocalDate startDate;
	
	private LocalDate graduationDate;

}
