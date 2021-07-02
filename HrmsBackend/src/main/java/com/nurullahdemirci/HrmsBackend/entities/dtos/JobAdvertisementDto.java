package com.nurullahdemirci.HrmsBackend.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private Integer id;
	
	private String companyName;
	
	private String cityName;
	
	private String jobPositionName;
	
	private Short numberOfVacancies;
	
	private LocalDate createdAt;
	
	private LocalDate deadline;
	
}
