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
@Entity(name = "Branch")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="branches")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="branch_id")
	private Short branchId;
	
	@NotBlank
	@NotNull
	@Column(name="branch_name", length=128)
	private String branchName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "branch")
	private Set<Education> educations;
	
}
