package com.tcs.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.Opportunity;

@Repository
public interface OpportunityRepository  extends JpaRepository<Opportunity,Integer> {

}