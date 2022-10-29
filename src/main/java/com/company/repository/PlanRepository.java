package com.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable>{

}
