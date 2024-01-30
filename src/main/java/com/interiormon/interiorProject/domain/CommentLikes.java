package com.interiormon.interiorProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommentLikes {

    @Id
    private int commentLikesNo;
    
    private String userId;
    private int commentNumber;
}

