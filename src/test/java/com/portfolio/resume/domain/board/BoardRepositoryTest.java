package com.portfolio.resume.domain.board;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @After
    public void cleanup() {
        boardRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "게시글 저장";
        String content = "테스트 본문";

        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .author("작성자")
                .build());

        // when
        List<Board> boardList = boardRepository.findAll();

        // then
        Board board = boardList.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDate now = LocalDate.of(2019,6,4);
        boardRepository.save(Board.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        // when
        List<Board> boardList = boardRepository.findAll();

        //then
        Board board = boardList.get(0);

        System.out.println("============== createdDate: " + board.getCreatedDate() + ", modifiedDate: " + board.getModifiedDate() + " ==========");

        assertThat(board.getCreatedDate()).isAfter(now);
        assertThat(board.getModifiedDate()).isAfter(now);
    }

}