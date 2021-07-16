package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeLanguage;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeLanguageDto;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer> {

	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeLanguageDto "
		+ "(l.langName, rl.level) "
		+ "FROM ResumeLanguage rl "
		+ "INNER JOIN rl.language l INNER JOIN rl.resume r INNER JOIN r.candidate c "
		+ "WHERE c.id=:candidateId"
	)
	List<ResumeLanguageDto> getByResumeLanguageInCandidateId(Integer candidateId);
	
}
