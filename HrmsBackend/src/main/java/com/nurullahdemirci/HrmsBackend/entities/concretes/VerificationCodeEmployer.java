package com.nurullahdemirci.HrmsBackend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification_code_employers")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "verification_code_id")
public class VerificationCodeEmployer extends VerificationCode{

	@Column(name = "employer_id")
	private Integer employerId;
	
}
