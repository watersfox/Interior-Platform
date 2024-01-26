package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InteriormonController {

    @GetMapping("/")
    public String home() {

        return "home";
    }

}

@Controller
class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/member/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "member/signup";
    }

    @PostMapping("login/re-login")
    public String signUp(@ModelAttribute @Valid UserDTO userDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDTO", userDTO);
            return "member/signup";
        }

        userService.signUp(userDTO);
        return "redirect:/login/re-login";
    }

    @GetMapping("/login/re-login")
    public String reLogin() {
        return "login/re-login";
    }
}