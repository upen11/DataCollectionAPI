package com.company.binding;

import java.util.List;

import lombok.Data;

@Data
public class DcSummary {
	
	private String planName;

	private Income income;
	
	private Education education;
	
	private List<Child> child;
	
}
