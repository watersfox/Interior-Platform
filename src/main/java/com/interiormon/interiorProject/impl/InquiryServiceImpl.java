package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.Inquiry; 
import com.interiormon.interiorProject.dto.InquiryDTO;
import com.interiormon.interiorProject.persistence.InquiryRepository;
import com.interiormon.interiorProject.service.InquiryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryServiceImpl(InquiryRepository userRepository) {
        this.inquiryRepository = userRepository;
    }

    @Override
    public void signUp(InquiryDTO inquiryDTO) {

    	Inquiry inquiry = Inquiry.builder()
    			.inquiryNo(inquiryDTO.getInquiryNo())
    			.build();


    	inquiryRepository.save(inquiry);
    }
    
    public InquiryDTO getInquiryByInquiryNo(int inquiryNo) {
    	Inquiry inquiry = inquiryRepository.findByInquiryNo(inquiryNo);
    	
    	if (inquiry==null) {
    		return null;
    	}
    	
//    	InquiryDTO inquiryDTO = new InquiryDTO();
//    	inquiryDTO.setInquiryNo(inquiry.getInquiryNo());
//    	inquiryDTO.setUser(inquiry.getUserId());
    	
    	InquiryDTO inquiryDTO = InquiryDTO.builder()
        .inquiryNo(inquiry.getInquiryNo())
        .user(inquiry.getUser()) // User 엔터티 전체를 저장
        .title(inquiry.getTitle())
        .content(inquiry.getContent())
        .createdDate(inquiry.getCreatedDate())
        .modifiedDate(inquiry.getModifiedDate())
        .category(inquiry.getCategory())
        .build();
    	
    	return inquiryDTO;
    }

//    @Transactional(readOnly = true)
//    @Override
//    public Map<String, String> validateHandling(Errors errors) {
//        Map<String, String> validatorResult = new HashMap<>();
//
//        for (FieldError error : errors.getFieldErrors()) {
//            String validKeyName = String.format("valid_%s", error.getField());
//            validatorResult.put(validKeyName, error.getDefaultMessage());
//        }
//
//        return validatorResult;
//    }
//
//    public boolean checkUserIdAndPassword(String userId, String password) {
//        User user = userRepository.findByUserIdAndPassword(userId, password);
//        return user != null;
//    }
//
//    public String getNickname(String userId) {
//        String nickname = userRepository.findByUserId(userId).getNickname();
//        return nickname;
//    }
//
//    public UserDTO getUserDTOByUserId(String userId) {
//        User user = userRepository.findByUserId(userId);
//
//        if (user == null) {
//            return null;
//        }
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserId(user.getUserId());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPhone(user.getPhone());
//        userDTO.setNickname(user.getNickname());
//        userDTO.setIntroduce(user.getIntroduce());
//
//        return userDTO;
//    }
//
//    public boolean checkNickname(String nickname) {
//        boolean isNickname = userRepository.existsByNickname(nickname);
//        return isNickname;
//    }
//
//    public void setSessionNickname(HttpSession session, Model model) {
//        String loggedUserId = (String) session.getAttribute("userId");
//        String loggedNickname = (String) session.getAttribute("nickname");
//
//        if (loggedUserId != null) {
//            model.addAttribute("userId", loggedUserId);
//            model.addAttribute("nickname", loggedNickname);
//        }
//    }

}