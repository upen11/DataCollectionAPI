package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.DCEntity;

@Repository
public interface DCEntityRepo extends JpaRepository<DCEntity, Integer> {

}
