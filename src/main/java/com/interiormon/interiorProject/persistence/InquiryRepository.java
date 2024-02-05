package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.Inquiry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

	Inquiry findByInquiryNo(int inquiryNo);
}