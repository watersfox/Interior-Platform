package com.interiormon.interiorProject.service;

import com.interiormon.interiorProject.domain.CommunityPost;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    void writeBoard(CommunityPost board, MultipartFile file) throws Exception;

    List<CommunityPost> boardList();

    CommunityPost boardView(Integer postNumber);
}
