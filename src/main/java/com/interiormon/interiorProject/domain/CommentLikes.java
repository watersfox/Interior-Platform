package com.interiormon.interiorProject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentLikesNo;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "commentNumber", referencedColumnName="commentNumber")
    private Comment comment;
}

