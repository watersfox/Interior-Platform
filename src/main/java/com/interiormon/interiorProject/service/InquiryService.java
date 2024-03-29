package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.dto.InquiryDTO; 
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import java.util.Map;

public interface InquiryService {
	
	

    void signUp(InquiryDTO inquiryDTO);
    
    InquiryDTO getInquiryByInquiryNo(int inquiryNo);
//
//    Map<String, String> validateHandling(Errors errors);
//
//    boolean checkUserIdAndPassword(String userId, String password);
//
//    String getNickname(String userId);
//
//    UserDTO getUserDTOByUserId(String userId);
//
//    boolean checkNickname(String nickname);
//
//    void setSessionNickname(HttpSession session, Model model);

}