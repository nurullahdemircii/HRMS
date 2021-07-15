package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Experience")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private Short experienceId;
	
	@NotBlank
	@NotNull
	@Column(name="company_name", length=128)
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name="position", length=128)
	private String position;
	
	@NotNull
	@Column(name="start_date", length=128)
	private LocalDate startDate;
	
	@Column(name="leave_date", length=128)
	private LocalDate leaveDate;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="resume_id")
	private Resume resume;
	
}
