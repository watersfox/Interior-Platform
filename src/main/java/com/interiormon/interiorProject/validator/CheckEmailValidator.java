package com.interiormon.interiorProject.validator;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckEmailValidator extends AbstractValidator<UserDTO> {

    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserDTO userdto, Errors errors) {
        if(userRepository.existsByEmail(userdto.getEmail())) {
            errors.rejectValue("email", "이메일 중복 오류", "이미 사용중인 이메일 입니다.");
        }
    }
}