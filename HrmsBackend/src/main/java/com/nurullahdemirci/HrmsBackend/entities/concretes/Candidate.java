package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate extends User{
	
	@NotBlank
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	@NotNull
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotBlank
	@NotNull
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<VerificationCodeInCandidate> verificationCodeInCandidates;
	
	@JsonIgnore
	@OneToOne(mappedBy="candidate")
	private Resume resume;

}
