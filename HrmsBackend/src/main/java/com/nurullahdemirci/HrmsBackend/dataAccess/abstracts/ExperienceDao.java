package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.HrmsBackend.entities.concretes.Experience;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ExperienceDto;

public interface ExperienceDao  extends JpaRepository<Experience, Integer>{

	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.ExperienceDto "
		+ "(e.companyName, e.position, e.startDate, e.leaveDate) "
		+ "FROM Experience e "
		+ "INNER JOIN e.resume r INNER JOIN r.candidate c "
		+ "WHERE c.id=:candidateId"
	)
	List<ExperienceDto> getByExperienceInCandidateId(Integer candidateId);
	
}
