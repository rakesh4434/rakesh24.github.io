package com.tcs.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.AwardTbl;

@Repository
public interface AwardTblRepository extends JpaRepository<AwardTbl , Integer> {
	//AwardTbl findByEmpId(int EmpId);
	
}