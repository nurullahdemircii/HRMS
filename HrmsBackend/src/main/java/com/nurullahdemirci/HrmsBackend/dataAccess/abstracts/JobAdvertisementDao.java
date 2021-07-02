package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nurullahdemirci.HrmsBackend.entities.concretes.JobAdvertisement;
import com.nurullahdemirci.HrmsBackend.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.JobAdvertisementDto"
		+ "(j.id, e.companyName, c.cityName, p.jobPositionName, j.numberOfVacancies, j.createdAt, j.deadline) "
		+ "FROM JobAdvertisement j INNER JOIN j.employers e INNER JOIN j.jobPositions p INNER JOIN j.cities c "
		+ "WHERE j.isActive=:isActive "
	)
	List<JobAdvertisementDto> getAllIsActive(Boolean isActive);
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.JobAdvertisementDto"
		+ "(j.id, e.companyName, c.cityName, p.jobPositionName, j.numberOfVacancies, j.createdAt, j.deadline) "
		+ "FROM JobAdvertisement j INNER JOIN j.employers e INNER JOIN j.jobPositions p INNER JOIN j.cities c "
		+ "WHERE j.createdAt=:createdAt AND j.isActive=:isActive "
	)
	List<JobAdvertisementDto> getAllCreatedAtAndIsActive(@Param("createdAt") LocalDate createdAt, @Param("isActive") Boolean isActive);
	
	@Query(""
		+ "SELECT new com.nurullahdemirci.HrmsBackend.entities.dtos.JobAdvertisementDto"
		+ "(j.id, e.companyName, c.cityName, p.jobPositionName, j.numberOfVacancies, j.createdAt, j.deadline) "
		+ "FROM JobAdvertisement j INNER JOIN j.employers e INNER JOIN j.jobPositions p INNER JOIN j.cities c "
		+ "WHERE e.id=:employerId AND j.isActive=:isActive "	
	)
	List<JobAdvertisementDto> getAllEmployerIdAndIsActive(@Param("employerId") Integer employerId, @Param("isActive") Boolean isActive);
	
	@Transactional
	@Modifying
	@Query("UPDATE JobAdvertisement j SET j.isActive=:isActive WHERE j.id=:jobAdvertisementId")
	void setIsActive(@Param("isActive") Boolean isActive, @Param("jobAdvertisementId") Integer jobAdvertisementId);
		
}
