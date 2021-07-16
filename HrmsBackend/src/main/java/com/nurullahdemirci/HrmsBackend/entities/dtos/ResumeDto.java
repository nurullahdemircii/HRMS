package com.nurullahdemirci.HrmsBackend.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

	private Integer id;
	
	private CandidateDto candidateDto;
	
	private String image;
	
	private String resumeDescription;
	
	private LocalDate createdAt;
	
	private List<EducationDto> educationDtos;

	private List<ExperienceDto> experienceDtos;
	
	private List<ResumeTechnologyDto> resumeTechnologyDtos;
	
	private List<ResumeLanguageDto> resumeLanguageDtos;
	
	private List<ResumeSocialMediaDto> resumeSocialMediaDtos;
	
}
