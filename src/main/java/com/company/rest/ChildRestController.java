package com.company.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.binding.ChildRequest;
import com.company.binding.DcSummary;
import com.company.service.DcService;

import lombok.Data;

@Data
public class ChildRestController {
	
	@Autowired
	private DcService service;
	
	@GetMapping("/children")
	public ResponseEntity<DcSummary> saveChilds(@RequestBody ChildRequest request) {

		Long caseNum = service.saveChildren(request);
		
		DcSummary summary = service.showSummary(caseNum);
		
		return new ResponseEntity<>(summary, HttpStatus.OK);
	}
}
