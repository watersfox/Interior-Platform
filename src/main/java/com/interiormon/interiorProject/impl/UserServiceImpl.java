package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.persistence.UserRepository;
import com.interiormon.interiorProject.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(UserDTO userDTO) {

        User user = User.builder()
                .userId(userDTO.getUserId())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .nickname(userDTO.getNickname())
                .phone(userDTO.getPhone())
                .introduce(userDTO.getIntroduce())
                .build();

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    public boolean checkUserIdAndPassword(String userId, String password) {
        User user = userRepository.findByUserIdAndPassword(userId, password);
        return user != null;
    }

    public String getNickname(String userId) {
        String nickname = userRepository.findByUserId(userId).getNickname();
        return nickname;
    }

    public User findByUserId(String userId) {
        User user = userRepository.findByUserId(userId);

        if (user == null) {
            return null;
        }

        return user;
    }

    public UserDTO getUserDTOByUserId(String userId) {
        User user = userRepository.findByUserId(userId);

        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setNickname(user.getNickname());
        userDTO.setIntroduce(user.getIntroduce());

        return userDTO;
    }

    public boolean checkNickname(String nickname) {
        boolean isNickname = userRepository.existsByNickname(nickname);
        return isNickname;
    }

    public void setSessionNickname(HttpSession session, Model model) {
        String loggedUserId = (String) session.getAttribute("userId");
        String loggedNickname = (String) session.getAttribute("nickname");

        if (loggedUserId != null) {
            model.addAttribute("userId", loggedUserId);
            model.addAttribute("nickname", loggedNickname);
        }
    }

    public String getUserIdByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }

        String userId = user.getUserId();

        return userId;
    }

    @Transactional
    public void deleteUserByUserId(String userId) {

        userRepository.deleteUserByUserId(userId);

    }
}