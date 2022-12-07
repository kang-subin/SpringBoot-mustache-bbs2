package com.example.bbs4.controller;

import com.example.bbs4.domain.dto.ArticleAddRequestdto;
import com.example.bbs4.domain.dto.ArticleAddResponsedto;
import com.example.bbs4.domain.dto.ArticleDto;
import com.example.bbs4.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc; // 서버에 배포하지 않고 테스트용으로 요청 전송, 응답기능 제공해주는 클래스

    @MockBean
    ArticleService articleService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("해당 id의 글이 조회가 잘 되는지")
    void findSingle() throws Exception {
        Long id = 1l;

        given(articleService.getArticleById(id))
                .willReturn(new ArticleDto(1l, "첫번째 글", "내용입니다.")); // dto로 값 넘겨줌

        int articleId = 1;
        String url = String.format("/api/v1/articles/%d", articleId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).getArticleById(id); // 메소드 실행 했는지 검증해줌
    }

    @Test
    @DisplayName("글 등록이 잘 되는지")
    void add() throws Exception {
        ArticleAddRequestdto dto = new ArticleAddRequestdto("제목입니다.", "내용입니다.");

        //처음에 dto 값 설정하고 이걸 json 형태로 바꾼 후 service.add(dto)로 들어가게 되면 매개변수 dto는 처음 설정한 dto와 같은 해시값을 가진 dto가 아님 여기에는 json 형태로 변경한 dto 객체가 들어가야함 그래서
        // 에러발생한듯? 따라서 any(뭘넘겨도 통과시켜주는 메소드?)로 바꿔준듯?

        given(articleService.add(any())).willReturn(new ArticleAddResponsedto(2l, dto.getTitle(), dto.getContent()));
             // service, repository 단계를 안거쳤으니까 임의로 지정해준 id 값이 1L인듯?

        mockMvc.perform(post("/api/v1/articles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(dto))) // 요청하는 Json 타입 (dto)내용
                .andExpect(status().isOk()) // 요청으로 얻어오는 결과 기대 값
                .andExpect(jsonPath("$.id").exists())// 기대값 체크하는데 json key 값이 id 가 있는가? (있다면 이는 요청한 후 응답을 잘 가져온 것으로 간주)
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("제목입니다."))
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());
    }
}




