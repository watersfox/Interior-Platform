package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.dto.UserDTO; 
import com.interiormon.interiorProject.persistence.UserRepository;
import com.interiormon.interiorProject.service.UserService;
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

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
@Slf4j

public class EstimateController {

	private final UserService userService;

	 @GetMapping("estimate/application")
	 public String start(HttpSession session, Model model) {
		 userService.getSessionNickname(session, model);
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


}
