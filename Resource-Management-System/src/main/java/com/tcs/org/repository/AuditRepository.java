package com.tcs.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.AuditDetails;

@Repository
public interface AuditRepository extends JpaRepository<AuditDetails, Integer> {

}
