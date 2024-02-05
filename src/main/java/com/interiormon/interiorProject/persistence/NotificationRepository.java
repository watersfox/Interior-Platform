package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.Notification; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	 
//    boolean existsByUserId(String userId);
//
//    boolean existsByEmail(String email);
//
//    boolean existsByNickname(String nickname);
//
//    User findByUserIdAndPassword(String userId, String password);
//
	Notification findBynotNo(int notNo);
}