package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Page<Member> findByUserIdContaining(String userId, Pageable pageable);
    Page<Member> findByNameContaining(String name, Pageable pageable);
}