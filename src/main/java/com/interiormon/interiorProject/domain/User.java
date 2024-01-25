package com.interiormon.interiorProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

    @Id
    private String userId;

    private String password;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime createdDate;
}