package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeLanguage;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer> {

}
