package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.dto.NotificationDTO; 
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import java.util.Map;

public interface NotificationService {
	
	

//    void signUp(EstimateDTO estimateDTO);
    
   NotificationDTO getNotificationBynotNo(int notNo);

}