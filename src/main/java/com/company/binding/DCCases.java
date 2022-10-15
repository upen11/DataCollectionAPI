package com.company.binding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "DC_CASES")
public class DCCases {

	@Id
	@GeneratedValue
	@Column(name = "CASE_ID")
	private Integer caseId;
	
	private Integer caseNumber;
	
	private Integer appId;
	
	private Integer planId;
	

}
