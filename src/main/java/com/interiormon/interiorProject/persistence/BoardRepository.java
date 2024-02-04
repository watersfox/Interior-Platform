package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<CommunityPost, Integer> {
}