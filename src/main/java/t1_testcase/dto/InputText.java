package t1_testcase.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class InputText {

    @NotBlank
    @Size(min = 2, max = 500)
    private String content;
}
