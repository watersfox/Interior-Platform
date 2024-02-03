package com.interiormon.interiorProject.dto;

import java.time.LocalDateTime;

import com.interiormon.interiorProject.domain.User;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InquiryDTO {

    private int inquiryNo;
    
    private User user;
    
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String category;
}
