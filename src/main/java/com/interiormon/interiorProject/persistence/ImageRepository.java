package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.ProfileImage;
import com.interiormon.interiorProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface ImageRepository extends JpaRepository<ProfileImage, Integer> {

    ProfileImage findByUser(User user);

    ProfileImage findByUser_UserId(String userId);

    void deleteProfileImageByUserUserId(String userId);

}