package com.portfolio.resume.web.dto.board;

import com.portfolio.resume.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public BoardSaveRequestDto(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Board toEntity() {

        return Board.builder()
                    .title(title)
                    .content(content)
                    .author(author)
                    .build();
    }

}