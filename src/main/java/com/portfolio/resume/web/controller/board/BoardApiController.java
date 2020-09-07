package com.portfolio.resume.web.controller.board;

import com.portfolio.resume.service.board.BoardService;
import com.portfolio.resume.web.dto.board.BoardResponseDto;
import com.portfolio.resume.web.dto.board.BoardSaveRequestDto;
import com.portfolio.resume.web.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {

        return boardService.save(boardSaveRequestDto);
    }

    @PutMapping("/api/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {

        return boardService.update(id, boardUpdateRequestDto);
    }

    @DeleteMapping("/api/board/{id}")
    public Long delete(@PathVariable Long id) {

        boardService.delete(id);

        return id;
    }

    @GetMapping("/api/board/{id}")
    public BoardResponseDto findById(@PathVariable Long id) {

        return boardService.findById(id);
    }

}
