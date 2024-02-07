package com.interiormon.interiorProject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int estimateNo;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    private String buildingType;
    private String buildDate;
    private String budget;
    private String availableDate;
    private String address;
}