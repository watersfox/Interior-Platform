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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postNumber", referencedColumnName = "postNumber")
    private CommunityPost communityPost;

    private String content;
    private int level;
    private int bundleId;
    private int bundleOrder;
    private boolean isDeleted;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime deletedDate;
    private int likesCnt;

    @OneToMany(mappedBy = "comment")
    private List<CommentLikes> commentLikesList;
}

