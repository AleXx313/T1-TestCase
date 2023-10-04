package t1_testcase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InputText {

    @NotBlank
    @Size(min = 2, max = 500)
    private String content;
}
