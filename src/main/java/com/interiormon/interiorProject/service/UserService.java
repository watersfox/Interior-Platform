package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.domain.User;
import com.interiormon.interiorProject.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import java.util.Map;

public interface UserService {

    void signUp(UserDTO userDTO);

    void onlySignUp(UserDTO userDTO);

    Map<String, String> validateHandling(Errors errors);

    boolean checkUserIdAndPassword(String userId, String password);

    String getNickname(String userId);

    UserDTO getUserDTOByUserId(String userId);

    boolean checkNickname(String nickname);

    void setSessionNickname(HttpSession session, Model model);

    String getUserIdByEmail(String email);

    void deleteUserByUserId(String userId);

    User findByUserId(String userId);
    
//    User getUserFromSession();
}