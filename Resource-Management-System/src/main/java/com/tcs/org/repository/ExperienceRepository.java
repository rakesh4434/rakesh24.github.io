package com.tcs.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tcs.org.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
