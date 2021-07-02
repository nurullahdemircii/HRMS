package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Employer")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employer extends User{
	
	@NotBlank
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name="web_address")
	private String webAddress;
	
	@NotBlank
	@NotNull
	@Column(name="phone_number")
	private String phoneNumber;
	
	@NotNull
	@Column(name="is_activated", columnDefinition = "boolean default false")
	private Boolean isActivated;
	
	//@JsonIgnore
	@OneToMany(mappedBy="employerVCIE")
	private List<VerificationCodeInEmployer> verificationCodeInEmployers;

}
