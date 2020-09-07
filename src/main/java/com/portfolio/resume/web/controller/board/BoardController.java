package com.portfolio.resume.web.controller.board;

import com.portfolio.resume.config.auth.LoginUser;
import com.portfolio.resume.config.auth.dto.SessionUser;
import com.portfolio.resume.service.board.BoardService;
import com.portfolio.resume.web.dto.board.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String BoardList(Model model, @LoginUser SessionUser user) {

        model.addAttribute("boardList", boardService.findAllDesc());

        if (user != null) {
            model.addAttribute("userList", user);
        }

        return "board/board-list";
    }

    @GetMapping("/board/detail/{id}")
    public String boardDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);

        if (user != null) {
            model.addAttribute("userList", user);
        }

        return "board/board-detail";
    }
}
