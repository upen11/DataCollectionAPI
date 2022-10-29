package com.company.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.DcChildrenEntity;

public interface DcChildrenRepo extends JpaRepository<DcChildrenEntity, Serializable>{

	public List<DcChildrenEntity> findByCaseNumber(Long caseNum);

}
