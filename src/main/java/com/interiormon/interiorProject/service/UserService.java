package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.dto.UserDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface UserService {

    void signUp(UserDTO userDTO);

    Map<String, String> validateHandling(Errors errors);

    boolean checkUserIdAndPassword(String userId, String password);

    String getNickname(String userId);

    UserDTO getUserDTOByUserId(String userId);

    boolean checkNickname(String nickname);

}