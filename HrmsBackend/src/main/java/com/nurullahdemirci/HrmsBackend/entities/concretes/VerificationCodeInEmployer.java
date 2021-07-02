package com.nurullahdemirci.HrmsBackend.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification_codes_in_employers")
public class VerificationCodeInEmployer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@OneToOne // (fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="verification_code_id")
	private VerificationCode verificationCodeIE;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name="employer_id")
	private Employer employerVCIE;
	
}
