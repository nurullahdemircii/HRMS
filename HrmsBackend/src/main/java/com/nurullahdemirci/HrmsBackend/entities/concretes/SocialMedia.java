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
@Entity(name = "SocialMedia")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="social_medias")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SocialMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "social_id")
	private Short socialId;
	
	@NotBlank
	@NotNull
	@Column(name = "social_name")	
	private String socialName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "socialMedia")
	private Set<ResumeSocialMedia> resumeSocialMedias;

}
