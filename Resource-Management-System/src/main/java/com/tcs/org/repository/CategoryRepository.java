package com.tcs.org.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
