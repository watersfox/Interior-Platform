package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.domain.Member;
import org.springframework.data.domain.Page;

public interface MemberService {
    Page<Member> findMembersByIdContaining(String userId, int page, int size);
    Page<Member> findMembersByNameContaining(String name, int page, int size);
}