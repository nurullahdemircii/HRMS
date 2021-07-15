package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Language")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lang_id")
	private Short langId;
  
	@NotBlank
	@NotNull
	@Column(name="lang_name", length=32)
	private String langName;
  
	@JsonIgnore
	@OneToMany(mappedBy = "language")
	private Set<ResumeLanguage> resumeLanguages;
  
}

