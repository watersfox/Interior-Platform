package com.interiormon.interiorProject.controller;

import com.interiormon.interiorProject.domain.CommunityPost;
import com.interiormon.interiorProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

//    @GetMapping("/board/write")
//    public String boardWrite() {
//        return "board/board-view";
//    }
//
//    @PostMapping("/board/writePro")
//    public String boardWritePro(CommunityPost board, Model model, MultipartFile file) throws Exception { // 데이터가 board에 담겨서 들어옴
//
//        boardService.writeBoard(board, file);
//
//        model.addAttribute("message", "글 작성이 완료되었습니다.");
//        model.addAttribute("searchUrl", "/board/list");
//
//        return "message";
//    }
}
