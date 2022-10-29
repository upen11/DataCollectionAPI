package com.company.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.binding.Income;
import com.company.service.DcService;

public class IncomeRestController {

	@Autowired
	private DcService service;
	
	@PostMapping("/income")
	public ResponseEntity<Long> saveIncome(@RequestBody Income income) {
		
		Long caseNum = service.saveIncomeDetails(income);
		
		return new ResponseEntity<>(caseNum, HttpStatus.CREATED);
	}
}
