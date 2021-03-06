package com.nurullahdemirci.HrmsBackend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification_codes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VerificationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank
	@NotNull
	@Column(name = "code", length=6)
	private String code;
	
	@NotBlank
	@NotNull
	@Column(name = "is_verified")
	private Boolean isVerified;

	@JsonIgnore
	@OneToOne(mappedBy="verificationCodeIE")
	private VerificationCodeInEmployer verificationCodeInEmployer;

	@JsonIgnore
	@OneToOne(mappedBy="verificationCodeIC")
	private VerificationCodeInCandidate verificationCodeInCandidate;
		
}
