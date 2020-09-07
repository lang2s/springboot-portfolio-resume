package com.portfolio.resume.web.dto.board;

import com.portfolio.resume.domain.board.Board;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BoardListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDate modifiedDate;

    public BoardListResponseDto(Board entity) {

        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

}
