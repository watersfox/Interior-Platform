package com.interiormon.interiorProject.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.interiormon.interiorProject.domain.Estimate;
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
    private String buildDate;
    private String budget;
    //private String constructionType;
    private String availableDate;
    private String address;
    
    public Estimate toEntity() {
        return Estimate.builder()
            .user(this.user)
            .buildingType(this.buildingType)
            .buildDate(this.buildDate)
            .budget(this.budget)
            //.constructionType(this.constructionType)
            .address(this.address)
            .build();
    }    
}



