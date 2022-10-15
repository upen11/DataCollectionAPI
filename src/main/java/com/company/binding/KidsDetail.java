package com.company.binding;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class KidsDetail {

	@Id
	@GeneratedValue
	private Integer kidsId;
	
	private Integer caseNumber;
	
	private String kidName;
	
	private Integer kidAge;	// or dob
	
	private Long kidSSN;

}
