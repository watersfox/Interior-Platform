package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.domain.Notification;
import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.NotificationDTO;
import com.interiormon.interiorProject.persistence.NotificationRepository;
import com.interiormon.interiorProject.service.NotificationService;
import com.interiormon.interiorProject.service.UserService;
import com.interiormon.interiorProject.service.NotificationService;
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
public class NotificationController {
	
	private final UserService userService;
	private final NotificationService notificationService;

//	    @GetMapping("/not1")
//		 public String es1() {
//	    	NotificationDTO notificationDTO = notificationService.getNotificationBynotNo(1);
//	    	User user = notificationDTO.getUser();
//	    	String userId = user.getUserId();
//	    	String nickname = user.getNickname();
//	    	String email = user.getEmail();
//	    	int notNo = notificationDTO.getNotNo();	  
//	    	String NotMessage = notificationDTO.getNotMessage();
//	    	System.out.println(notificationDTO.toString());
//	    	//System.out.println("유저아이디 = " + userId + ", 유저이메일 = " + email + "DTO = " + estimateDTO.toString() );
//	    	System.out.println("유저아이디 = " + userId + " nickname = " + nickname + " notNo =" + notNo + "  NotMessage = " + NotMessage );
//		        return "home";
//		    }
//	    
//	    @GetMapping("/es2")
//		 public String es2() {
//
//		        return "home";
//		    }	    
//
//
//
}
