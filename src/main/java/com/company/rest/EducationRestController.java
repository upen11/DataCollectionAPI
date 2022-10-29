package com.company.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.binding.Education;
import com.company.service.DcService;

import lombok.Data;

@Data
public class EducationRestController {

	@Autowired
	private DcService service;

	@PostMapping("/education")
	public ResponseEntity<Long> saveIncome(@RequestBody Education education) {

		Long caseNum = service.saveEducationDetails(education);

		return new ResponseEntity<>(caseNum, HttpStatus.CREATED);
	}
}
