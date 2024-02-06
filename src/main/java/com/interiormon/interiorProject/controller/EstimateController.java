package com.interiormon.interiorProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.interiormon.interiorProject.domain.Estimate;
import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.EstimateDTO;
import com.interiormon.interiorProject.service.EstimateService;
import com.interiormon.interiorProject.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

//	    @PostMapping("/saveEstimate")
//	    public ResponseEntity<String> saveEstimate(@Valid @RequestBody EstimateDTO estimateDTO, Errors errors) {
//	        if (errors.hasErrors()) {
//	            // Validation errors occurred, handle them as needed
//	            return new ResponseEntity<>("Validation error in estimate data", HttpStatus.BAD_REQUEST);
//	        }
//
//	        try {
//	            // Map EstimateDTO to Estimate entity
//	            Estimate estimate = estimateDTO.toEntity();
//
//	            // Set the user for the estimate (you may need to get the user from the session or elsewhere)
//	            // For example, assuming you have a method getUserFromSession() in UserService
//	            User user = userService.getUserFromSession();
//	            estimate.setUser(user);
//
//	            // Save the estimate
//	            estimateService.saveEstimate(estimate);
//
//	            return new ResponseEntity<>("Estimate data saved successfully", HttpStatus.OK);
//	        } catch (Exception e) {
//	            return new ResponseEntity<>("Error saving estimate data", HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
//	    }

}

//function submitForm() {
//    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
//    const checkedCheckboxes = Array.from(checkboxes).filter(checkbox => checkbox.checked);
//
//    // Check if at least one checkbox is checked
//    if (checkedCheckboxes.length === 0) {
//        alert('Please check at least one checkbox.');
//        return;
//    }
//
//    // Assume that you have a REST API endpoint for saving estimate data
//    const apiUrl = '/api/saveEstimate';
//
//    // Prepare data to send to the server
//    const requestData = {
//        buildingType: 'YourBuildingType', // Replace with actual building type
//        // Add other properties as needed
//    };
//
//    // Send a POST request to save estimate data
//    fetch(apiUrl, {
//        method: 'POST',
//        headers: {
//            'Content-Type': 'application/json',
//        },
//        body: JSON.stringify(requestData),
//    })
//    .then(response => response.json())
//    .then(data => {
//        // Handle the response as needed
//        console.log('Estimate data saved successfully:', data);
//        alert('Estimate data saved successfully!');
//    })
//    .catch(error => {
//        console.error('Error saving estimate data:', error);
//        alert('Error saving estimate data. Please try again.');
//    });
//}
