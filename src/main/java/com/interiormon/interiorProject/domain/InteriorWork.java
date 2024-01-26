package com.interiormon.interiorProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class InteriorWork {

    @Id
    private int workNumber;
    
    private int companyId;
    private String userId;
    private String address;
    private LocalDateTime workDate;
    private String workType;
    private int workWeeks;
    private int pyeong;
    private int workPrice;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String content;
}
