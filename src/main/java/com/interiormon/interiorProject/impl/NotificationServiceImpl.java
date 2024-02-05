//package com.interiormon.interiorProject.impl;
//
//import com.interiormon.interiorProject.domain.Notification; 
//import com.interiormon.interiorProject.dto.NotificationDTO;
//import com.interiormon.interiorProject.persistence.NotificationRepository;
//import com.interiormon.interiorProject.service.NotificationService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.Errors;
//import org.springframework.validation.FieldError;
//import org.springframework.ui.Model;
//import jakarta.servlet.http.HttpSession;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class NotificationServiceImpl implements NotificationService {
//
//    private final NotificationRepository notificationRepository;
//
//    public NotificationServiceImpl(NotificationRepository userRepository) {
//        this.notificationRepository = userRepository;
//    }
//
////    @Override
////    public void signUp(InquiryDTO inquiryDTO) {
////
////    	Inquiry inquiry = Inquiry.builder()
////    			.inquiryNo(inquiryDTO.getInquiryNo())
////    			.build();
////
////
////    	inquiryRepository.save(inquiry);
////    }
//    
//    public NotificationDTO getNotificationBynotNo(int notNo) {
//    	Notification notification = notificationRepository.findBynotNO(notNo);
//    	
//    	if (notification==null) {
//    		return null;
//    	}
//    	
//    	NotificationDTO notificationDTO = NotificationDTO.builder()
//        .notNo(notification.getNotNo())
//        .user(notification.getUser())
//        .notMessage(notification.getNotMessage())
//        .address(notification.getAddress())
//        .build();
//    	
//    	return notificationDTO;
//    }
//
//}