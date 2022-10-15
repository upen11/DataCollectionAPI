package com.company.binding;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class PlanSelection {

	@Id
	@GeneratedValue
	private Integer planId;
	
	private Integer caseNumber;

	private String planName;
}
