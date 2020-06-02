package com.tcs.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Role;
//import com.tcs.org.model.Company;
import com.tcs.org.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
	Status findByStatusId(int statusId);
}
