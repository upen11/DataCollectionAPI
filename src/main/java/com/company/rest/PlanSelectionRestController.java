package com.company.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.binding.PlanSelection;
import com.company.service.DcService;

public class PlanSelectionRestController {

	@Autowired
	private DcService service;
	
	@PostMapping("/planselection")
	public ResponseEntity<Long> planSelection(@RequestBody PlanSelection planselection) {
		
		Long caseNum = service.savePlanSelection(planselection);
		
		return new ResponseEntity<>(caseNum, HttpStatus.CREATED);
	}
}
