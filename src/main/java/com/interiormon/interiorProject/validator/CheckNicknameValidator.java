package com.interiormon.interiorProject.validator;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckNicknameValidator extends AbstractValidator<UserDTO> {

    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserDTO userdto, Errors errors) {
        if(userRepository.existsByNickname(userdto.getNickname())) {
            errors.rejectValue("nickname", "닉네임 중복 오류", "이미 사용중인 닉네임 입니다.");
        }
    }
}