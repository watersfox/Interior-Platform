package com.interiormon.interiorProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    private String companyId;

    private String name;
    private String phone;
    private String ceoName;
    private String content;
    private int careerYears;
    private String address;
    private LocalDateTime createdDate;
    private String password;
    private String ceoPhone;
    private int companyNumber;
    private String email;
    private double rating;
    private boolean isCertified;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
}
