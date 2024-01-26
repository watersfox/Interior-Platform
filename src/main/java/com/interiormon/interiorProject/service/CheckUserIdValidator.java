package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.impl.AbstractValidator;
import com.interiormon.interiorProject.persistence.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class CheckUserIdValidator extends AbstractValidator<UserDTO> {

    private final UserRepository userRepository;
    @Override
    protected void doValidate(UserDTO userDTO, Errors errors) {
        if (userRepository.existsByUserId(userDTO.getUserId())) {
            errors.rejectValue("userId", "아이디 중복 오류", "중복된 아이디입니다.");
        }
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validate(T t, Class<?>... classes) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T t, String s, Class<?>... classes) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> aClass, String s, Object o, Class<?>... classes) {
        return null;
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> aClass) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }
}
