package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.HrmsBackend.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	
	List<Resume> getAllByCandidate_Id(Integer candidateId);
	
}
