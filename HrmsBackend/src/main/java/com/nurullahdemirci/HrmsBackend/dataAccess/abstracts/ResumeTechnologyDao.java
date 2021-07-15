package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeTechnology;

public interface ResumeTechnologyDao extends JpaRepository<ResumeTechnology, Integer> {

}
