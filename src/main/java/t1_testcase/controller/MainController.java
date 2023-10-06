package t1_testcase.controller;

import org.springframework.web.bind.annotation.*;
import t1_testcase.dto.InputText;
import t1_testcase.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/api/v1/solve")
public class MainController {

    private final MainService mainService;

    @PostMapping
    public String solve(@RequestBody @Valid InputText text){
        return mainService.solve(text);
    }
}
