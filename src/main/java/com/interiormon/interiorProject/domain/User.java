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

    private String password;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime createdDate;
    private String introduce;
//    private String imageUrl;

    @OneToMany(mappedBy = "user")
    private List<Inquiry> inquiries;

    @OneToMany(mappedBy = "user")
    private List<CommunityPost> communityPosts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<CommentLikes> commentLikesList;

    @OneToMany(mappedBy = "user")
    private List<PostLikes> postLikesList;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Scrap> scraps;
}