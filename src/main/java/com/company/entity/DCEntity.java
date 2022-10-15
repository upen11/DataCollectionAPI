package com.company.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DATA_COLLECTION")
@Data
public class DCEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "CASE_NUMBER")
	private Integer caseNumber;

	@Column(name = "APP_ID")
	private Integer appId;

	@Column(name = "PLAN_NAME")
	private List<String> planName;

	@Column(name = "MONTHLY_SALARY_INCOME")
	private double monthlySalIncome;

	@Column(name = "RENT_INCOME")
	private double rentIncome;

	@Column(name = "PROPERTY_INCOME")
	private double propertyIncome;

	@Column(name = "HIGHES_TDEGREE")
	private String highestDegree;

	@Column(name = "GRADUATION_YEAR")
	private LocalDate graduationYear;

	@Column(name = "UNIVERSITY_NAME")
	private String universityName;

	@Column(name = "KID_NAME")
	private String kidName;

	@Column(name = "AGE")
	private Integer kidAge;

	@Column(name = "SSN")
	private Integer kidSSN;
}
