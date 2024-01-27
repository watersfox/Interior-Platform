package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.persistence.UserRepository;
import com.interiormon.interiorProject.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

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
        
        // 아이디 중복 방지 로직
        if (userRepository.existsByUserId(userDTO.getUserId())) {
            throw new RuntimeException("이미 사용 중인 아이디입니다.");
        }

        User user = User.builder()
                .userId(userDTO.getUserId())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .nickname(userDTO.getNickname())
                .phone(userDTO.getPhone())
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
}