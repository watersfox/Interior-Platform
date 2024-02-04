package com.interiormon.interiorProject.domain;

import jakarta.persistence.*;
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

    private String password;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime createdDate;
    private String introduce;
//    private String imageUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Inquiry> inquiries;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<CommunityPost> communityPosts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<CommentLikes> commentLikesList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<PostLikes> postLikesList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Scrap> scraps;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private ProfileImage profileImage;
}