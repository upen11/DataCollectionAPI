package com.company.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CITIZEN_APPS")
public class CitizenAppEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;

	private String fullName;

	private String email;

	private Long phnNo;

	private String gender;

	private LocalDate dob;

	private Long ssn;

	private String createdBy;

	private String updatedBy;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate creationDate;

	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updationDate;

}
