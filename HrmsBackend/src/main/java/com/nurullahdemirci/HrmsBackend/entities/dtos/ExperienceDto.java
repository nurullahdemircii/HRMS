package com.nurullahdemirci.HrmsBackend.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {

	private String companyName;
	
	private String position;
	
	private LocalDate startDate;
	
	private LocalDate leaveDate;
	
}
