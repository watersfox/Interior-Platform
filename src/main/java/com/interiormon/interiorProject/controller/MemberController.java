package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.domain.Member;
import com.interiormon.interiorProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String getMembersByIdContaining(
            @RequestParam String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Page<Member> members = memberService.findMembersByIdContaining(userId, page, size);
        model.addAttribute("members", members);
        return "member-list";
    }

    @GetMapping("/membersByName")
    public String getMembersByNameContaining(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Page<Member> members = memberService.findMembersByNameContaining(name, page, size);
        model.addAttribute("members", members);
        return "member-list";
    }
}