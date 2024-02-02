package com.interiormon.interiorProject.domain;

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
public class User {

    @Id
    private String userId;
    @OneToMany(mappedBy = "user")
    private List<Inquiry> Inquirys;

    private String password;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime createdDate;
    private String introduce;
//    private String imageUrl;

}