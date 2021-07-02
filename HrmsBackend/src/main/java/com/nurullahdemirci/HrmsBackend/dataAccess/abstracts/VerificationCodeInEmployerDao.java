package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.HrmsBackend.entities.concretes.VerificationCodeInEmployer;

public interface VerificationCodeInEmployerDao extends JpaRepository<VerificationCodeInEmployer, Integer>{

}
