package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.domain.ProfileImage;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void upload(MultipartFile file, String userId);

    ProfileImage getProfileImageByUserId(String userId);

    void deleteProfileImageByUserUserID(String userId);
}
