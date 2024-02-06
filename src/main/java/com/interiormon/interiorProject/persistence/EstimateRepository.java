package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.Estimate; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<Estimate, Integer> {

	 
	Estimate save(Estimate estimate);

	Estimate findByEstimateNo(int estimateNo);
}