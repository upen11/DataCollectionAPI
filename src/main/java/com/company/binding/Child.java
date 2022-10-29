package com.company.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Child {

	private String childName;

	private LocalDate childAge;

	private Long childSsn;
	
}
