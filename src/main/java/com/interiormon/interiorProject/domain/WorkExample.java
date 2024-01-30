package com.interiormon.interiorProject.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class WorkExample {

    @Id
    private int workExNO;
    
    private int companyId;
    private String title;
    private String content;
    private String address;
    private int pyeong;
    private String workType;
    private int workPrice;
    private int workWeeks;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime deletedDate;
}
