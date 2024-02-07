package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.Estimate; 
import com.interiormon.interiorProject.dto.EstimateDTO;
import com.interiormon.interiorProject.persistence.EstimateRepository;
import com.interiormon.interiorProject.service.EstimateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class EstimateServiceImpl implements EstimateService {

    private final EstimateRepository estimateRepository;

    public EstimateServiceImpl(EstimateRepository userRepository) {
        this.estimateRepository = userRepository;
    }

//    @Override
//    public void signUp(InquiryDTO inquiryDTO) {
//
//    	Inquiry inquiry = Inquiry.builder()
//    			.inquiryNo(inquiryDTO.getInquiryNo())
//    			.build();
//
//
//    	inquiryRepository.save(inquiry);
//    }
    
    public EstimateDTO getEstimateByEstimateNo(int estimateNo) {
    	Estimate estimate = estimateRepository.findByEstimateNo(estimateNo);
    	
    	if (estimate==null) {
    		return null;
    	}
    	
    	EstimateDTO estimateDTO = EstimateDTO.builder()
        .estimateNo(estimate.getEstimateNo())
        .user(estimate.getUser())
        .buildingType(estimate.getBuildingType())
        .buildDate(estimate.getBuildDate())
        .budget(estimate.getBudget())
        .address(estimate.getAddress())
//        .constructionType(estimate.getConstructionType())
        .build();
    	
    	return estimateDTO;
    }
    
    @Override
    public void saveEstimate(Estimate estimate) {
        estimateRepository.save(estimate);
        // 필요에 따라 추가적인 로직 수행
    }    

}