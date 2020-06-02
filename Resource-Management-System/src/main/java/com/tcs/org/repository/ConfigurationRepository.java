package com.tcs.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.org.model.Configuration;

//import com.tcs.org.model.Requirement;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer>{
}

