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

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notNo;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    private int notificationCount;
    private int Count;
    private String notType;
    private String notMessage;
    private String notUrl;
    private String address;
    private LocalDateTime createdDate;
    
    //나중에 구현할것 >> 작성글번호
}