package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Education")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@Column(name="start_date", length=128)
	private LocalDate startDate;
	
	@Column(name="graduation_date", length=128)
	private LocalDate graduationDate;
	
	@ManyToOne//(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "school_type_id")
	private SchoolType schoolType;
	
	@ManyToOne//(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "school_id")
	private School school;
	
	@ManyToOne//(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	@NotNull
	@ManyToOne//(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="resume_id")
	private Resume resume;
	
}
