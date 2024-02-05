package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.domain.Estimate;
import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.EstimateDTO;
import com.interiormon.interiorProject.persistence.EstimateRepository;
import com.interiormon.interiorProject.service.EstimateService;
import com.interiormon.interiorProject.service.UserService;
import com.interiormon.interiorProject.service.EstimateService;
import com.interiormon.interiorProject.validator.CheckEmailValidator;
import com.interiormon.interiorProject.validator.CheckNicknameValidator;
import com.interiormon.interiorProject.validator.CheckPasswordValidator;
import com.interiormon.interiorProject.validator.CheckUserIdValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EstimateController {
	
	private final UserService userService;
	private final EstimateService estimateService;
	
	 @GetMapping("estimate/application")
	 public String start(HttpSession session, Model model) {
		 userService.setSessionNickname(session, model);
	        return "estimate/견적신청";
	    }
	 
	 @GetMapping("/ea")
	 public String start2() {

	        return "estimate/index2";
	    }
	 
	 @GetMapping("/e2")
	 public String start3() {

	        return "estimate1/견적신청";
	    }
	 
	    @GetMapping("/es")
		 public String es1() {
	    	EstimateDTO estimateDTO = estimateService.getEstimateByEstimateNo(1);
	    	User user = estimateDTO.getUser();
	    	String userId = user.getUserId();
	    	String nickname = user.getNickname();
	    	String email = user.getEmail();
	    	int estimateNo = estimateDTO.getEstimateNo();	  
	    	String buildingType = estimateDTO.getBuildingType();
	    	System.out.println(estimateDTO.toString());
	    	//System.out.println("유저아이디 = " + userId + ", 유저이메일 = " + email + "DTO = " + estimateDTO.toString() );
	    	System.out.println("유저아이디 = " + userId + " nickname = " + nickname + " estimateNo =" + estimateNo + "  buildingType = " + buildingType );
		        return "home";
		    }
	    
	    @GetMapping("/es2")
		 public String es2() {

		        return "home";
		    }	    



}
