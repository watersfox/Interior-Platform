package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.Member;
import com.interiormon.interiorProject.persistence.MemberRepository;
import com.interiormon.interiorProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Page<Member> findMembersByIdContaining(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return memberRepository.findByUserIdContaining(userId, pageable);
    }

    @Override
    public Page<Member> findMembersByNameContaining(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return memberRepository.findByNameContaining(name, pageable);
    }
}