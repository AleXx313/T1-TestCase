package com.example.t1_testcase.controller;

import com.example.t1_testcase.service.MainService;
import com.example.t1_testcase.util.PatternConstants;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/api/v1/parse")
public class MainController {

    private final MainService mainService;

    @GetMapping
    public String solve(@RequestParam(name = "text") @Pattern(regexp = PatternConstants.LATIN_AND_KIRILL_PATTERN) String text) {
        return mainService.solve(text);
    }

}
