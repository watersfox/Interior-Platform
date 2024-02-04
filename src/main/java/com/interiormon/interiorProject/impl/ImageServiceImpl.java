package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.ProfileImage;
import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.persistence.ImageRepository;
import com.interiormon.interiorProject.persistence.UserRepository;
import com.interiormon.interiorProject.service.ImageService;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final UserRepository userRepository;

    @Value("${path.upload}")
    private String uploadFolder;

    public void upload(MultipartFile file, String userId) {
        User user = userRepository.findByUserId(userId);

        try {
            // 썸네일 파일명 생성
            UUID uuid = UUID.randomUUID();
            String thumbnailFileName = "s_" + uuid + "_" + file.getOriginalFilename();
            File thumbnailFile = new File(uploadFolder + thumbnailFileName);

            // 썸네일 생성 및 저장
            Thumbnails.of(file.getInputStream())
                    .size(250, 250)
                    .toFile(thumbnailFile);

            ProfileImage image = imageRepository.findByUser(user);

            if (image != null) {
                // 이미지가 이미 존재하면 url 업데이트
                image.updateUrl("/profileImages/" + thumbnailFileName);
            } else {
                // 이미지가 없으면 객체 생성 후 저장
                image = ProfileImage.builder()
                        .user(user)
                        .url("/profileImages/" + thumbnailFileName)
                        .build();
            }
            imageRepository.save(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ProfileImage getProfileImageByUserId(String userId) {
        return imageRepository.findByUser_UserId(userId);
    }

}
