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
@Entity(name = "Technology")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Technology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tech_id")
	private Short techId;
  
	@NotBlank
	@NotNull
	@Column(name="tech_name", length=32)
	private String techName;
  
	@JsonIgnore
	@OneToMany(mappedBy = "technology")
	private Set<ResumeTechnology> resumeTechnologies;

}
