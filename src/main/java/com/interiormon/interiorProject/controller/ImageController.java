package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.dto.ImageUploadDTO;
import com.interiormon.interiorProject.service.ImageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    @Autowired
    @Qualifier("imageServiceImpl")
    private ImageService imageService;

    @PostMapping("/image-upload")
    public String imageUpload(MultipartFile file, HttpSession session, Model model) {
        String loggeedUserId = (String) session.getAttribute("userId");
        String loggedNickname = (String) session.getAttribute("nickname");
        if (loggeedUserId==null) {
            return "redirect:/";
        }
        imageService.upload(file, loggeedUserId);
        model.addAttribute("userId", loggeedUserId);
        model.addAttribute("nickname", loggedNickname);
        return "home";
    }
}
