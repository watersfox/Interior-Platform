package com.interiormon.interiorProject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postLikesNo;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postNumber", referencedColumnName="postNumber")
    private CommunityPost communityPost;

}

