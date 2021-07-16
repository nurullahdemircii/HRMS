package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.HrmsBackend.entities.concretes.Education;
import com.nurullahdemirci.HrmsBackend.entities.dtos.EducationDto;

public interface EducationDao extends JpaRepository<Education, Integer> {
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.EducationDto "
		+ "(st.schoolTypeName, b.branchName, s.schoolName, e.startDate, e.graduationDate) "
		+ "FROM Education e "
		+ "INNER JOIN e.schoolType st INNER JOIN e.branch b INNER JOIN e.school s INNER JOIN e.resume r INNER JOIN r.candidate c "
		+ "ORDER BY c.id ASC, e.graduationDate DESC"
	)
	List<EducationDto> getAllEducationsWithCandidateOrderByGraduationDate();
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.EducationDto "
		+ "(st.schoolTypeName, b.branchName, s.schoolName, e.startDate, e.graduationDate) "
		+ "FROM Education e "
		+ "INNER JOIN e.schoolType st INNER JOIN e.branch b INNER JOIN e.school s INNER JOIN e.resume r INNER JOIN r.candidate c "
		+ "WHERE c.id=:candidateId"
	)
	List<EducationDto> getByEducationInCandidateId(Integer candidateId);
}
