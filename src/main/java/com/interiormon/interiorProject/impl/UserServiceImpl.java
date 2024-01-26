package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.persistence.UserRepository;
import com.interiormon.interiorProject.service.UserService;
import org.springframework.stereotype.Service;

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

    public boolean isUserIdExist(String userId){

    return userRepository.existsByUserId(userId);
    }

    public boolean isEmailExist(String email){

        return userRepository.existsByEmail(email);
    }

    public boolean isNicknameExist(String nickname){

        return userRepository.existsByNickname(nickname);
    }
}