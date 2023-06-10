package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.SATResult;

@Repository
public interface SATResultRepository extends JpaRepository<SATResult, Long> {
    SATResult findByName(String name);
}
