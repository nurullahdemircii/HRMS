package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Resume")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_id") 
	private Integer id;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "resume_description")
	private String resumeDescription;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@OneToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private Set<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private Set<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private Set<ResumeLanguage> resumeLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private Set<ResumeSocialMedia> resumeSocialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private Set<ResumeTechnology> resumeTechnologies;
	
}
