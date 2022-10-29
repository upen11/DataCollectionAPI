package com.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.DcEducationEntity;

@Repository
public interface DcEducationRepo extends JpaRepository<DcEducationEntity, Serializable> {

	public DcEducationEntity findByCaseNumber(Long caseNum);

}
