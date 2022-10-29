package com.company.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.company.binding.CreateCaseResponse;
import com.company.service.DcService;

@RestController
public class CreateCaseRestController {

	@Autowired
	public DcService service;
	
	@GetMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId) {
		
		long caseNum = service.loadCaseNum(appId);
		
		Map<Integer, String> planNames = service.getPlanNames();
		
		CreateCaseResponse response = new CreateCaseResponse();
		
		response.setCaseNum(caseNum);
		response.setPlanNames(planNames);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
