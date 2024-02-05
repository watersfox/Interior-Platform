package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.Estimate; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<Estimate, Integer> {

	 
//    boolean existsByUserId(String userId);
//
//    boolean existsByEmail(String email);
//
//    boolean existsByNickname(String nickname);
//
//    User findByUserIdAndPassword(String userId, String password);
//
	Estimate findByEstimateNo(int estimateNo);
}