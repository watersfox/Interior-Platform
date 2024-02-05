package com.interiormon.interiorProject.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.interiormon.interiorProject.domain.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EstimateDTO {

	private int estimateNo;
    
    private User user;
    
    private String buildingType;
    private Date buildDate;
    private String budget;
    private String constructionType;
    private String address;
}



