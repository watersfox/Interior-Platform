package com.interiormon.interiorProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Customer")
public class Member {
    @Id
    private String userId;

    private String password;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime createdDate;
}