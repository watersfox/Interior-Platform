package com.interiormon.interiorProject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNumber;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName="companyId")
    private Company company;

    private String title;
    private String content;
    private double rating;
    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
    private LocalDateTime deletedDate;
}
