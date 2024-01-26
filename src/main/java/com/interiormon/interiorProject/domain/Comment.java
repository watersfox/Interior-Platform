package com.interiormon.interiorProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    private int commentNumber;
    
    private String userId;
//    @ManyToOne
//    private User user;
    
    private int postNumber;
    private String content;
    private int level;
    private int bundleId;
    private int bundleOrder;
    private boolean isDeleted;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime deletedDate;
    private int likesCnt;
}

