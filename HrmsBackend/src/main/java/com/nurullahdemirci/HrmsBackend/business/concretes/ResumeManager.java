package com.nurullahdemirci.HrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.HrmsBackend.business.abstracts.CandidateService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.EducationService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.ExperienceService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeLanguageService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeSocialMediaService;
import com.nurullahdemirci.HrmsBackend.business.abstracts.ResumeTechnologyService;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.DataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.Result;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.HrmsBackend.core.utilities.results.SuccessResult;
import com.nurullahdemirci.HrmsBackend.dataAccess.abstracts.ResumeDao;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Candidate;
import com.nurullahdemirci.HrmsBackend.entities.concretes.Resume;
import com.nurullahdemirci.HrmsBackend.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	CandidateService candidateService;
	EducationService educationService;
	ExperienceService experienceService;
	ResumeLanguageService resumeLanguageService;
	ResumeSocialMediaService resumeSocialMediaService;
	ResumeTechnologyService resumeTechnologyService;
	
	@Autowired
	public ResumeManager(
		ResumeDao resumeDao,
		CandidateService candidateService,
		EducationService educationService,
		ExperienceService experienceService,
		ResumeLanguageService resumeLanguageService,
		ResumeSocialMediaService resumeSocialMediaService,
		ResumeTechnologyService resumeTechnologyService
	) {
		super();
		this.resumeDao = resumeDao;
		this.candidateService = candidateService;
		this.educationService = educationService;
		this.experienceService = experienceService;
		this.resumeLanguageService = resumeLanguageService;
		this.resumeSocialMediaService = resumeSocialMediaService;
		this.resumeTechnologyService = resumeTechnologyService;
	}

	@Override
	public Result create(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("");
	}
		
	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), "");
	}

	@Override
	public DataResult<List<Resume>> getById(Integer candidateId) {
		List<Resume> resumes = this.resumeDao.getAllByCandidate_Id(candidateId);
		return new SuccessDataResult<List<Resume>>(resumes, "");
	}

	@Override
	public DataResult<ResumeDto> getAllResumeDetailsByCandidateId(Integer candidateId) {
		Candidate candidate = this.candidateService.getById(candidateId).getData();
		Resume resume = this.resumeDao.getById(candidate.getResume().getId());
		ResumeDto resumeDto = new ResumeDto();
		
		resumeDto.setId(candidateId);
		resumeDto.setCandidateDto(this.candidateService.getByCandidateDtoId(candidateId).getData());
		resumeDto.setImage(resume.getImage());
		resumeDto.setResumeDescription(resume.getResumeDescription());
		resumeDto.setCreatedAt(resume.getCreatedAt());
		resumeDto.setEducationDtos(this.educationService.getByEducationInCandidateId(candidateId).getData());
		resumeDto.setExperienceDtos(this.experienceService.getByExperienceInCandidateId(candidateId).getData());
		resumeDto.setResumeTechnologyDtos(this.resumeTechnologyService.getByResumeTechnologyInCandidateId(candidateId).getData());
		resumeDto.setResumeLanguageDtos(this.resumeLanguageService.getByResumeLanguageInCandidateId(candidateId).getData());
		resumeDto.setResumeSocialMediaDtos(this.resumeSocialMediaService.getByResumeSocialMediaInCandidateId(candidateId).getData());
		return new SuccessDataResult<ResumeDto>(resumeDto, "Candidate Resume All Details!");
	}
	
}