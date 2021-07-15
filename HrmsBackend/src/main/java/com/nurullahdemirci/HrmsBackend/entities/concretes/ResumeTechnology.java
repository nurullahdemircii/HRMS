package com.nurullahdemirci.HrmsBackend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "ResumeTechnology")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resume_technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ResumeTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "tech_id")
	private Technology technology;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;

}
