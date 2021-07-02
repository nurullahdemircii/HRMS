package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeInCandidate;

public interface VerificationCodeInCandidateDao extends JpaRepository<VerificationCodeInCandidate, Integer>{

}
