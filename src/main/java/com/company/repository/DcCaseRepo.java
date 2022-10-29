package com.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.DcCasesEntity;

public interface DcCaseRepo extends JpaRepository<DcCasesEntity, Serializable>{

}
