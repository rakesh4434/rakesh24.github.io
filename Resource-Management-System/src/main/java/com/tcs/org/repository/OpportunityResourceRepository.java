package com.tcs.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.OpportunityResource;

@Repository
public interface OpportunityResourceRepository  extends JpaRepository<OpportunityResource,Integer> {

	/*void deleteByResourceId(int resourceId);*/

}
