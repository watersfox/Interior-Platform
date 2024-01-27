package com.interiormon.interiorProject.validator;

import com.interiormon.interiorProject.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckPasswordValidator extends AbstractValidator<UserDTO> {

    @Override
    protected void doValidate(UserDTO userDTO, Errors errors) {
        if (!userDTO.getPassword().equals(userDTO.getPassword2())) {
            errors.rejectValue("password2", "비밀번호 불일치", "비밀번호가 일치하지 않습니다.");
        }
    }
}