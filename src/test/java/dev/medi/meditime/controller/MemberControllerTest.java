package dev.medi.meditime.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dev.medi.meditime.model.dto.MemberDTO;
import dev.medi.meditime.model.entity.Member;
import dev.medi.meditime.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MockMvc mvc;

    @Test
    @Transactional
    @DisplayName("회원 가입 확인")
    void signupTest() throws Exception {
        MemberDTO newMember = MemberDTO.builder()
                .memberId(1L)
                .email("test@gmail.com")
                .password("1234")
                .born("1995")
                .gender("M")
                .regDate(LocalDate.now())
                .build();

        String jsonData = new Gson().toJson(newMember);

        mvc.perform(post("/api/members/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().isCreated()); // 상태코드만 확인

        verify(memberService).signup(newMember);
    }

}