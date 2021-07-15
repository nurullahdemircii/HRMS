package com.nurullahdemirci.HrmsBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.HrmsBackend.entities.concretes.ResumeSocialMedia;

public interface ResumeSocialMediaDao extends JpaRepository<ResumeSocialMedia, Integer> {

}
