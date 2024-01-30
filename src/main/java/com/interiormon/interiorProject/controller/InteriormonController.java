package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.service.UserService;
import com.interiormon.interiorProject.validator.CheckEmailValidator;
import com.interiormon.interiorProject.validator.CheckNicknameValidator;
import com.interiormon.interiorProject.validator.CheckPasswordValidator;
import com.interiormon.interiorProject.validator.CheckUserIdValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class InteriormonController {

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String nickname = (String) session.getAttribute("nickname");

        if (userId != null) {
            model.addAttribute("userId", userId);
            model.addAttribute("nickname", nickname);
        }
        System.out.println("userId = " +  userId + " " + "nickname = " + nickname );
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

    @GetMapping("member/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "member/signup";
    }

    @PostMapping("member/signup-ok")
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
        return "redirect:/member/signup-ok";

    }

    @GetMapping("member/signup-ok")
    public String reLogin() {
        return "member/signup-ok";
    }

    @GetMapping("login/login")
    public String loginForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "login/login";
    }

    @PostMapping("login/login-ok")
    public String login(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "password") String password,
            HttpSession session,
            Model model) {

        if (userId == null || userId.trim().isEmpty()) {
            model.addAttribute("userId", userId);
            model.addAttribute("loginError", "아이디를 입력하세요.");
            return "login/login";
        }

        if (password == null || password.trim().isEmpty()) {
            model.addAttribute("userId", userId);
            model.addAttribute("loginError", "비밀번호를 입력하세요.");
            return "login/login";
        }

        if (!userService.checkUserIdAndPassword(userId, password)) {
            model.addAttribute("userId", userId);
            model.addAttribute("loginError", "유효하지 않은 아이디와 비밀번호입니다.");
            return "login/login";
        }
        session.setAttribute("userId", userId);
        String nickname = userService.getNickname(userId);
        session.setAttribute("nickname", nickname);
        model.addAttribute("userId", userId);
        model.addAttribute("nickname", nickname);

        return "home";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        // 세션에 저장된 사용자 정보 제거
        session.removeAttribute("userId");

        // 세션을 완전히 무효화
        session.invalidate();

        // 로그아웃 후 리다이렉트할 페이지 또는 뷰 이름 반환
        return "redirect:/"; // 로그아웃 후 홈 화면으로 리다이렉트하도록 설정
    }
}