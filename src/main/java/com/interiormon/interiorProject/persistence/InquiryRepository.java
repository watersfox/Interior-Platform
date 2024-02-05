package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

	 
//    boolean existsByUserId(String userId);
//
//    boolean existsByEmail(String email);
//
//    boolean existsByNickname(String nickname);
//
//    User findByUserIdAndPassword(String userId, String password);
//
    Inquiry findByInquiryNo(int inquiryNo);
}