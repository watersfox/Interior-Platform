package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.dto.UserDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface UserService {

    void signUp(UserDTO userDTO);

    Map<String, String> validateHandling(Errors errors);
}