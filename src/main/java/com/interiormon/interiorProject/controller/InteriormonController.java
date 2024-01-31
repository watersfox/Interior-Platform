package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.dto.UserDTO;
import com.interiormon.interiorProject.persistence.UserRepository;
import com.interiormon.interiorProject.service.UserService;
import com.interiormon.interiorProject.validator.CheckEmailValidator;
import com.interiormon.interiorProject.validator.CheckNicknameValidator;
import com.interiormon.interiorProject.validator.CheckPasswordValidator;
import com.interiormon.interiorProject.validator.CheckUserIdValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
@Slf4j
public class InteriormonController {

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

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        String loggedUserId = (String) session.getAttribute("userId");
        String loggedNickname = (String) session.getAttribute("nickname");

        if (loggedUserId != null) {
            model.addAttribute("userId", loggedUserId);
            model.addAttribute("nickname", loggedNickname);
        }
        return "home";
    }

    @GetMapping("member/signup")
    public String showSignUpForm(Model model, HttpSession session) {

        session.removeAttribute("userId");

        session.invalidate();

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
        String loggedNickname = userService.getNickname(userId);
        session.setAttribute("nickname", loggedNickname);
        model.addAttribute("userId", userId);
        model.addAttribute("nickname", loggedNickname);

        return "home";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {

        session.removeAttribute("userId");

        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("member/member-info")
    public String memberInfo(HttpSession session, Model model) {
        String loggedUserId = (String) session.getAttribute("userId");
        String loggedNickname = (String) session.getAttribute("nickname");

        if (loggedUserId != null) {
            model.addAttribute("userId", loggedUserId);
            model.addAttribute("nickname", loggedNickname);
            return "member/member-info";
        }
        return "home";
    }

    @GetMapping("member/edit-info")
    public String editInfo(HttpSession session, Model model) {
        String loggedUserId = (String) session.getAttribute("userId");
        String loggedNickname = (String) session.getAttribute("nickname");

        if (loggedUserId != null) {
            UserDTO userDTO = userService.getUserDTOByUserId(loggedUserId);
            if (userDTO == null) { // 정상적이지 않은 로그인 대비
                return "home";
            }
            model.addAttribute("userDTO", userDTO);
            model.addAttribute("userId", loggedUserId);
            model.addAttribute("nickname", loggedNickname);

            return "member/edit-info";
        }
        return "home";
    }

    private static final String PHONE_NUMBER_PATTERN = "^01([0|1|6|7|8|9])?([0-9]{3,4})?([0-9]{4})$";
    private static final String NICKNAME_PATTERN = "^(?=.*[ㄱ-ㅎ가-힣a-zA-Z0-9])[ㄱ-ㅎ가-힣a-zA-Z0-9]{1,8}$";

    @PostMapping("member/edit-info-ok")
    public String editInfoOk(
            UserDTO userDTO,
            @RequestParam(name = "password") String password,
            HttpSession session,
            Model model)
    {
        String loggedUserId = (String) session.getAttribute("userId");
        String loggedNickname = (String) session.getAttribute("nickname");
        model.addAttribute("userId", loggedUserId);
        model.addAttribute("nickname", loggedNickname);
        Pattern phonePattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Pattern nicknamePattern = Pattern.compile(NICKNAME_PATTERN);
        Matcher phoneMatcher = phonePattern.matcher(userDTO.getPhone());
        Matcher nicknameMatcher = nicknamePattern.matcher(userDTO.getNickname());

        if (password == null || password.trim().isEmpty() || !userService.checkUserIdAndPassword(userDTO.getUserId(), password)) {
            userDTO = userService.getUserDTOByUserId(loggedUserId);
            model.addAttribute("userDTO", userDTO);
            model.addAttribute("validateError", "유효하지 않은 비밀번호입니다.");
            return "member/edit-info";
        }

        if (!userDTO.getNickname().equals(userService.getNickname(userDTO.getUserId()))) {
            if(userService.checkNickname(userDTO.getNickname())) {
                userDTO = userService.getUserDTOByUserId(loggedUserId);
                model.addAttribute("userDTO", userDTO);
                model.addAttribute("validateError", "중복된 닉네임입니다.");
                return "member/edit-info";
            }
        }

        if (userDTO.getIntroduce().length()>30) {
            userDTO = userService.getUserDTOByUserId(loggedUserId);
            model.addAttribute("userDTO", userDTO);
            model.addAttribute("validateError", "자기소개글은 30자 이내로 작성해주세요.");
            return "member/edit-info";
        }

        if (!phoneMatcher.matches()) {
            userDTO = userService.getUserDTOByUserId(loggedUserId);
            model.addAttribute("userDTO", userDTO);
            model.addAttribute("validateError", "올바르지 않은 전화번호입니다.");
            return "member/edit-info";
        }

        if (!nicknameMatcher.matches()) {
            userDTO = userService.getUserDTOByUserId(loggedUserId);
            model.addAttribute("userDTO", userDTO);
            model.addAttribute("validateError", "닉네임은 1~8자의 영문, 한글, 숫자만 사용해야 합니다.");
            return "member/edit-info";
        }


        userDTO.setPassword(password);
        userService.signUp(userDTO);

        return "home";
    }
}