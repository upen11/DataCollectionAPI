package com.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.DcIncomeEntity;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity, Serializable>{

	public DcIncomeEntity findByCaseNumber(Long caseNum);

}
