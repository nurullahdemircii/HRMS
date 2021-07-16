package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.HrmsBackend.entities.concretes.Candidate;
import com.nurullahdemirci.HrmsBackend.entities.dtos.CandidateDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.CandidateDto "
		+ "(c.firstName, c.lastName) "
		+ "FROM Candidate c "
		+ "WHERE c.id=:candidateId"
	)
	CandidateDto getByCandidateDtoId(Integer candidateId);
}
