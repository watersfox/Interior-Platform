package com.interiormon.interiorProject.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inquiry {

    @Id
    private int inquiryNo;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;
    
    private String title;
    private String content;
    
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    
    private LocalDateTime modifiedDate;
    private String category;
}
