package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.dto.EstimateDTO; 
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import java.util.Map;

public interface EstimateService {
	
	

//    void signUp(EstimateDTO estimateDTO);
    
    EstimateDTO getEstimateByEstimateNo(int estimateNo);

}