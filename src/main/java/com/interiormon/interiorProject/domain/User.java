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
//
//    @OneToMany(mappedBy = "userId")
//    private List<Comment> comment;
//
//    @OneToMany(mappedBy = "userId")
//    private List<CommentLikes> commentLikes;

    private String password;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime createdDate;
    private String introduce;
//    private String imageUrl;

}