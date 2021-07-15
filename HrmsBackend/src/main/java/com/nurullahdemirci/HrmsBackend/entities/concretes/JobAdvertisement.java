package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "JobAdvertisement")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="advertisement_id")
	private Integer advertisementId;
	
	@NotBlank
	@NotNull
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private String minSalary;
	
	@Column(name="max_salary")
	private String maxSalary;
	
	@NotNull
	@Column(name="number_of_vacancies")
	private Short numberOfVacancies;
	
	@NotNull
	@Column(name="creat_at")
	private LocalDate createdAt;

	@NotNull
	@Column(name="deadline")
	private LocalDate deadline;
	
	@NotNull
	@Column(name="is_active")
	private Boolean isActive;
	
	@NotNull
	@OneToOne
	@JoinTable(
		name="job_advertisements_of_employers",
		joinColumns= {@JoinColumn(name="advertisement_id", referencedColumnName="advertisement_id")},
		inverseJoinColumns= {@JoinColumn(name="employer_id", referencedColumnName="user_id")}
	)
	private Employer employers;
	
	@NotNull
	@OneToOne
	@JoinTable(
		name="job_positions_of_advertisements",
		joinColumns= {@JoinColumn(name="advertisement_id", referencedColumnName="advertisement_id")},
		inverseJoinColumns= {@JoinColumn(name="job_position_id", referencedColumnName="id")}
	)
	private JobPosition jobPositions;
	
	@NotNull
	@ManyToMany//cascade=CascadeType.ALL)//, mappedBy="jobAdvertisementIC")
	@JoinTable(
		name="job_advertisements_in_cities",
		joinColumns= {@JoinColumn(name="advertisement_id", referencedColumnName="advertisement_id")},
		inverseJoinColumns= {@JoinColumn(name="city_id", referencedColumnName="city_id")}
	)
	private Set<City> cities;
	
}
