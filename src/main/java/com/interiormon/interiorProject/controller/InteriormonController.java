package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.service.UserService;
import com.interiormon.interiorProject.validator.CheckEmailValidator;
import com.interiormon.interiorProject.validator.CheckNicknameValidator;
import com.interiormon.interiorProject.validator.CheckPasswordValidator;
import com.interiormon.interiorProject.validator.CheckUserIdValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class InteriormonController {

    @GetMapping("/")
    public String home() {

        return "home";
    }

}

@Controller
@RequiredArgsConstructor
@Slf4j
class UserController {

    private final UserService userService;
    private final CheckUserIdValidator checkUserIdValidator;
    private final CheckEmailValidator checkEmailValidator;
    private final CheckNicknameValidator checkNicknameValidator;
    private final CheckPasswordValidator checkPasswordValidator;


    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(checkUserIdValidator);
        binder.addValidators(checkEmailValidator);
        binder.addValidators(checkNicknameValidator);
        binder.addValidators(checkPasswordValidator);
    }

    @GetMapping("/member/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "member/signup";
    }

    @PostMapping("/login/re-login")
    public String signUp(@ModelAttribute @Valid UserDTO userDTO, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("userDTO", userDTO);

            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            return "member/signup";
        }


        userService.signUp(userDTO);
        return "redirect:/login/re-login";

    }

    @GetMapping("/login/re-login")
    public String reLogin() {
        return "login/re-login";
    }

    @GetMapping("/login/login")
    public String Login() {
        return "login/login";
    }
}