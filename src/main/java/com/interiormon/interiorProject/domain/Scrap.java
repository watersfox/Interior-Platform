package com.interiormon.interiorProject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Scrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scrapNumber;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    private String linkUrl;
    private String thumbnailUrl;
}

