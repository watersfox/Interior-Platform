package com.interiormon.interiorProject.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.InquiryDTO;
import com.interiormon.interiorProject.service.InquiryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InquiryController {
	
    private final InquiryService inquiryService;
	 
    @GetMapping("/fk")
	 public String fk1() {
    	InquiryDTO inquiryDTO = inquiryService.getInquiryByInquiryNo(2);
    	User user = inquiryDTO.getUser();
    	String userId = user.getUserId();
    	String email = user.getEmail();
    	int inquiryNo = inquiryDTO.getInquiryNo();
    	LocalDateTime createdDate = inquiryDTO.getCreatedDate();
    	String title = inquiryDTO.getTitle();
    	
    	System.out.println("유저아이디 = " + userId + ", 문의번호 = " + inquiryNo + ", 유저이메일 = " + email + ", 생성일자 = " + createdDate + "제목 = "+ title + "DTO = " + inquiryDTO.toString() );
	        return "home";
	    }

}

