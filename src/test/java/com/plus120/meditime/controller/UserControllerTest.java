package com.plus120.meditime.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plus120.meditime.controller.request.UserJoinRequest;
import com.plus120.meditime.model.User;
import com.plus120.meditime.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    @MockBean private UserService userService;

    @Test
    public void joinTest() throws Exception {
        // Given
        String userId = "userId";
        String password = "password";
        String email = "test@email.com";
        String nickname = "nickname";
        given(userService.join(userId, password, email, nickname)).willReturn(mock(User.class));

        // When & Then
        mockMvc.perform(post("/api/v1/users/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(UserJoinRequest.of(userId, password, email, nickname)))
                ).andDo(print())
                .andExpect(status().isOk());
    }
}