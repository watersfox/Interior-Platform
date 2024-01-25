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

        if (userRepository.existsByUserId(userDTO.getUserId())) {
            throw new RuntimeException("이미 사용 중인 아이디입니다.");
        }

        User customer = new User();
        customer.setUserId(userDTO.getUserId());
        customer.setPassword(userDTO.getPassword());
        customer.setNickname(userDTO.getNickname());
        customer.setPhone(userDTO.getPhone());
        customer.setEmail(userDTO.getEmail());

        userRepository.save(customer);
    }
}