package com.nurullahdemirci.HrmsBackend.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeLanguageDto {

	private String languageName;
	
	private Integer languageLevel;
	
}
