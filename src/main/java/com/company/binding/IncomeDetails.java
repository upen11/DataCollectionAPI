package com.company.binding;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class IncomeDetails {

	@Id
	@GeneratedValue
	private Integer incomeId;
	
	private Integer caseNumber;
	
	private Double monthlySalIncome;
	
	private Double propertyIncome;
	
	private Double rentIncome;
}
