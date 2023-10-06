package t1_testcase.service;

import org.junit.jupiter.api.Test;
import t1_testcase.dto.InputText;

import static org.assertj.core.api.Assertions.assertThat;

class MainServiceTest {

    private final MainService mainService = new MainService();
    private final InputText inputText = new InputText();
    @Test
    void solve_whenStringHasLatinLetters_thenReturnLettersCountString() {
        inputText.setContent("abca");

        String result = mainService.solve(inputText);
        assertThat(result).isEqualTo("\"a\": 2, \"b\": 1, \"c\": 1");
    }
    @Test
    void solve_whenStringHasOneLatinLetter_thenReturnLettersCountStringWithOneLetter() {
        inputText.setContent("a");

        String result = mainService.solve(inputText);
        assertThat(result).isEqualTo("\"a\": 1");
    }

    @Test
    void solve_whenStringHasNotOnlyLatinLetter_thenReturnOnlyLatinLettersCountString() {
        inputText.setContent("a)))b234@@@23c23^^42&&&34a6%%45###6**4(((");

        String result = mainService.solve(inputText);
        assertThat(result).isEqualTo("\"a\": 2, \"b\": 1, \"c\": 1");
    }

    @Test
    void solve_whenStringHasOnlyOneLatinLetterAndOtherSymbols_thenReturnLettersCountStringWithOneLetter() {
        inputText.setContent(")))234@@@2323^^4a2&&&346%%45###6**4(((");

        String result = mainService.solve(inputText);
        assertThat(result).isEqualTo("\"a\": 1");
    }

    @Test
    void solve_whenStringHasNoLatinLetterAndHasOtherSymbols_thenReturnNoticeString() {
        inputText.setContent(")))234@@@2323^^42&&&346%%45###6**4(((");

        String result = mainService.solve(inputText);
        assertThat(result).isEqualTo("В переданной строке отсутствуют символы латинского алфавита!");
    }
}