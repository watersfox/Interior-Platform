package com.interiormon.interiorProject.impl;

import com.interiormon.interiorProject.domain.CommunityPost;
import com.interiormon.interiorProject.persistence.BoardRepository;
import com.interiormon.interiorProject.service.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void writeBoard(CommunityPost board, MultipartFile file) throws Exception {
        
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; // 파일의 저장 경로

        UUID uuid = UUID.randomUUID(); // 랜덤식별자를 생성
        
        String fileName = uuid + "_" + file.getOriginalFilename(); // 파일이름에 식별자 포함한 뒤 저장

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile); // 경로로 파일 전달

        board.setFileName(fileName);
        board.setFilePath("/files/" + fileName);

        boardRepository.save(board); // 보드 저장
    }

    public List<CommunityPost> boardList() { // 게시글을 리스트화
        return boardRepository.findAll();
    }

    public CommunityPost boardView(Integer id) { // postNumber로 게시글 불러오기
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }

}
