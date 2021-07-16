package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeSocialMedia;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeSocialMediaDto;

public interface ResumeSocialMediaDao extends JpaRepository<ResumeSocialMedia, Integer> {
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeSocialMediaDto "
		+ "(sm.socialName, rsm.url) "
		+ "FROM ResumeSocialMedia rsm "
		+ "INNER JOIN rsm.socialMedia sm INNER JOIN rsm.resume r INNER JOIN r.candidate c "
		+ "WHERE c.id=:candidateId"
	)
	List<ResumeSocialMediaDto> getByResumeSocialMediaInCandidateId(Integer candidateId);

}
