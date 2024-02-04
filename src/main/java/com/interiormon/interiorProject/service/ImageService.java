package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.domain.ProfileImage;
import com.interiormon.interiorProject.dto.ImageUploadDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void upload(MultipartFile file, String userId);

    ProfileImage getProfileImageByUserId(String userId);
}
