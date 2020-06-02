package com.tcs.org.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.org.model.Role;
import com.tcs.org.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	List<Role> findByType(String type);
	
	List<Role> findByRoleIdIn(List<Integer> roleId);

	Optional<Role> findByName(RoleName roleName);

	//Optional<Role> findByName(RoleName associates, RoleName roleAdmin, RoleName roleDeveloper);

	//Optional<Role> findByName(RoleName associates, RoleName roleAdmin, RoleName roleDeveloper);

	//Role findByName(int roleId);

}
