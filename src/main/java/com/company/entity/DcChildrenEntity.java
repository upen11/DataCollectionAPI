package com.company.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class DcChildrenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childId;
	
	private Long caseNumber;
	
	private String childName;
	
	private LocalDate childAge;
	
	private Long childSsn;

}
