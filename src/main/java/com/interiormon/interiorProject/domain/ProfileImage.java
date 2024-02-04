package com.interiormon.interiorProject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageNumber;

    private String url;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName="userId")
    private User user;

    public void updateUrl(String url) {
        this.url = url;
    }

}
