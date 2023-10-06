package t1_testcase;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import t1_testcase.controller.MainController;
import t1_testcase.dto.InputText;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@AutoConfigureMockMvc
class T1TestcaseApplicationTest {
    private final MockMvc mockMvc;
    private final MainController controller;
    private final InputText inputText = new InputText();

    @Test
    public void contextLoad() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void solve_shouldCountLatinSymbolsIntInputTextContent() throws Exception {
        inputText.setContent("Hello, World!");
        String json = "{\"content\": \"Hello, World!\"}";
        String response = mockMvc.perform(post("/api/v1/solve")
                        .content(json)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse().getContentAsString();

        assertThat(response).isEqualTo("\"l\": 3, \"o\": 2, \"d\": 1, \"e\": 1, \"h\": 1, \"r\": 1, \"w\": 1");
    }
}