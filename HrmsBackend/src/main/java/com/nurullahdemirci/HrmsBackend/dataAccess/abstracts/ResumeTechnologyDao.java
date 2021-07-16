package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeTechnology;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeTechnologyDto;

public interface ResumeTechnologyDao extends JpaRepository<ResumeTechnology, Integer> {
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeTechnologyDto "
		+ "(t.techName) "
		+ "FROM ResumeTechnology rt "
		+ "INNER JOIN rt.technology t INNER JOIN rt.resume r INNER JOIN r.candidate c "
		+ "WHERE c.id=:candidateId"
	)
	List<ResumeTechnologyDto> getByResumeTechnologyInCandidateId(Integer candidateId);

}
