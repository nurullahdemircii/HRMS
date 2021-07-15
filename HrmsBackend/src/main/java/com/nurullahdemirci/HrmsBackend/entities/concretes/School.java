package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "School")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private Short schoolId;
	
	@NotBlank
	@NotNull
	@Column(name="school_name", length=128)
	private String schoolName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<Education> educations;
	
}
