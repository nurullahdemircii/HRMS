package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="countries")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	private Short countryId;
	
	@NotBlank
	@NotNull
	@Column(name="country_name", length=32)
	private String countryName;
	
	@NotBlank
	@NotNull
	@Column(name="country_code", length=8)
	private String countryCode;
	
	@JsonIgnore
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<City> cities;
	
}
