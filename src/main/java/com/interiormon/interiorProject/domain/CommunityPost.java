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
public class CommunityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postNumber;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    private String title;
    private String content;
    private int views;
    private int commentCnt;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int likesCnt;
    private LocalDateTime deletedDate;
    private String fileName;
    private String filePath;

    @OneToMany(mappedBy = "communityPost")
    private List<Comment> comments;

    @OneToMany(mappedBy = "communityPost")
    private List<PostLikes> postLikesList;
}

