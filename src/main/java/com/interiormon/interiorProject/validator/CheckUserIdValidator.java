package com.interiormon.interiorProject.validator;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckUserIdValidator extends AbstractValidator<UserDTO> {

    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserDTO userDTO, Errors errors) {
//        if(!errors.hasFieldErrors("userId")){
            if(userRepository.existsByUserId(userDTO.getUserId())) {
                errors.rejectValue("userId", "아이디 중복 오류", "이미 사용중인 아이디입니다.");
            }
//        }
    }
}
