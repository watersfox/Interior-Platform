package com.interiormon.interiorProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class CommunityPost {

    @Id
    private int postNumber;
    
    private String userId;
    private String title;
    private String content;
    private int views;
    private int commentCnt;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int likesCnt;
    private LocalDateTime deletedDate;
}

