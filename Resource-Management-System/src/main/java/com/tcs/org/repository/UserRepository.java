package com.tcs.org.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

//import com.javatechie.audit.api.Book;
import com.tcs.org.model.User;

@Repository
public interface UserRepository extends RevisionRepository<User, Integer, Integer>, JpaRepository<User, Integer> {

	User findByUsername(String username);
	List<User> findByUsernameAndPassword(String username,String password);
	/*List<User>  findByDealId(int dealId);*/
	//User findByUserId(int id);
	Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail2);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	//List<User> findByUserId(int id);
	Optional<User> findByUserId(int userIds);
}
