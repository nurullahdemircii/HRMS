package com.nurullahdemirci.HrmsBackend.entities.concretes;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "City")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="city_id")
	private Integer cityId;
	
	@NotBlank
	@NotNull
	@Column(name="city_name", length=64, nullable = false)
	private String cityName;
	
	@NotNull
	@Column(name="plate_code")
	private Short plateCode;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name="country_id")
	private Country country;
	
	@JsonIgnore
	@ManyToMany(mappedBy="cities")
	private Set<JobAdvertisement> jobAdvertisements;
	
}
