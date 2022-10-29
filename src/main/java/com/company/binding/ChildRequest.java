package com.company.binding;

import java.util.List;

import lombok.Data;

@Data
public class ChildRequest {

	private Long caseNum;
	
	private List<Child> children;
}
