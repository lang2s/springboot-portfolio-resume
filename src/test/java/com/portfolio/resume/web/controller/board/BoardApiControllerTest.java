package com.portfolio.resume.web.controller.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.resume.domain.board.Board;
import com.portfolio.resume.domain.board.BoardRepository;
import com.portfolio.resume.web.dto.board.BoardSaveRequestDto;
import com.portfolio.resume.web.dto.board.BoardUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                    .webAppContextSetup(context)
                    .apply(springSecurity())
                    .build();
    }

    @After
    public void tearDown() throws Exception {
        boardRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Board_등록된다() throws Exception {
        // given
        String title = "title";
        String content = "content";
        BoardSaveRequestDto boardSaveRequestDto = BoardSaveRequestDto.builder()
                                                    .title(title)
                                                    .content(content)
                                                    .author("author")
                                                    .build();

        String url = "http://localhost:" +  port + "api/board/";

        // when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(boardSaveRequestDto)))
                .andExpect(status().isOk());

        // then
        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Board_수정된다() throws Exception {
        // given
        Board savedBoard = boardRepository.save(Board.builder()
                                        .title("title")
                                        .content("content")
                                        .author("author")
                                        .build());

        Long updateId = savedBoard.getId();

        String expectedTitle = "title2";
        String expectedContent = "content2";

        BoardUpdateRequestDto updateRequestDto = BoardUpdateRequestDto.builder()
                                                    .title(expectedTitle)
                                                    .content(expectedContent)
                                                    .build();

        String url = "http://localhost:" + port + "/api/board/" + updateId;

        HttpEntity<BoardUpdateRequestDto> updateRequestEntity = new HttpEntity<>(updateRequestDto);

        // when
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(updateRequestDto)))
                .andExpect(status().isOk());

        //then
        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

    }



}
