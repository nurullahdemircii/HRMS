package com.nurullahdemirci.HrmsBackend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "JobPosition")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobPosition{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="job_position_name")
	private String jobPositionName;
	
}
