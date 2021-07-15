package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nurullahdemirci.HrmsBackend.entities.concretes.Resume;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeDto;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeDto "
		+ "(r.id, c.firstName, c.lastName, r.image, t.techName, st.schoolTypeName, b.branchName, s.schoolName, e.startDate, e.graduationDate) "
		+ "FROM Resume r "
		+ "INNER JOIN r.candidate c INNER JOIN r.educations e INNER JOIN r.resumeTechnologies rt "
		+ "INNER JOIN e.schoolType st INNER JOIN e.branch b INNER JOIN e.school s "
		+ "INNER JOIN rt.technology t "
		+ "WHERE c.id=:candidateId"
	)
	List<ResumeDto> getAllResumeInCandidate(@Param("candidateId") Integer candidateId);

}
