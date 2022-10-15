package com.company.binding;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class EducationDetails {
	
	@Id
	@GeneratedValue
	private Integer educationId;
	
	private Integer caseNumber;
	
	private String highestDegree;
	
	private String universityName;
	
	private Integer graduationYear;
}
