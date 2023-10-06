package t1_testcase.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import t1_testcase.dto.InputText;
import t1_testcase.service.MainService;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MainController.class)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MainService mainService;

    private final InputText inputText = new InputText();

    @Test
    void solve_whenInputTextContentLengthIsTwo_thenStatusIsOk() throws Exception {
        inputText.setContent("aa");
        when(mainService.solve(inputText)).thenReturn("\"a\": 2");

        String response = mockMvc.perform(post("/api/v1/solve")
                        .content(objectMapper.writeValueAsString(inputText))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(response).isEqualTo("\"a\": 2");
        verify(mainService, times(1)).solve(any());
    }

    @Test
    void solve_whenInputTextContentLengthIsTen_thenStatusIsOk() throws Exception {
        inputText.setContent("aaaaaaaaaa");
        when(mainService.solve(inputText)).thenReturn("\"a\": 10");

        String response = mockMvc.perform(post("/api/v1/solve")
                        .content(objectMapper.writeValueAsString(inputText))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(response).isEqualTo("\"a\": 10");
        verify(mainService, times(1)).solve(any());
    }

    @Test
    void solve_whenInputTextContentLengthLessThanTwo_thenStatusIsBadRequest() throws Exception {
        inputText.setContent("t");

        mockMvc.perform(post("/api/v1/solve")
                        .content(objectMapper.writeValueAsString(inputText))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(mainService, never()).solve(any());
    }

    @Test
    void solve_whenInputTextContentEmpty_thenStatusIsBadRequest() throws Exception {
        inputText.setContent("");

        mockMvc.perform(post("/api/v1/solve")
                        .content(objectMapper.writeValueAsString(inputText))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(mainService, never()).solve(any());
    }

    @Test
    void solve_whenInputTextContentIsBlank_thenStatusIsBadRequest() throws Exception {
        inputText.setContent(" ");

        mockMvc.perform(post("/api/v1/solve")
                        .content(objectMapper.writeValueAsString(inputText))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(mainService, never()).solve(any());
    }

    @Test
    void solve_whenInputTextContentIsNull_thenStatusIsBadRequest() throws Exception {
        inputText.setContent(null);

        mockMvc.perform(post("/api/v1/solve")
                        .content(objectMapper.writeValueAsString(inputText))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(mainService, never()).solve(any());
    }

    @Test
    void solve_whenInputTextContentSizeMoreThenFiveHundred_thenStatusIsBadRequest() throws Exception {
        inputText.setContent("a".repeat(505));

        mockMvc.perform(post("/api/v1/solve")
                        .content(objectMapper.writeValueAsString(inputText))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(mainService, never()).solve(any());
    }
}