package t1_testcase.service;

import org.springframework.stereotype.Service;
import t1_testcase.dto.InputText;
import t1_testcase.util.PatternConstants;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MainService {

    public String solve(InputText text) {
        String lowerString = text.getContent().toLowerCase();
        char[] charSequence = lowerString.toCharArray();
        Map<Character, Integer> countedSymbols = countFitSymbols(charSequence, Pattern.compile(PatternConstants.LATIN));
        return buildResponse(countedSymbols);
    }

    private Map<Character, Integer> countFitSymbols(char[] charSequence, Pattern pattern) {
        Map<Character, Integer> result = new TreeMap<>();
        for (char c : charSequence) {
            Matcher matcher = pattern.matcher("" + c);
            if (matcher.matches()) {
                if (!result.containsKey(c)) {
                    result.put(c, 1);
                } else {
                    int counter = result.get(c);
                    result.put(c, counter + 1);
                }
            }
        }
        return result;
    }

    private String buildResponse(Map<Character, Integer> symbols){
        StringBuilder sb = new StringBuilder();
        symbols.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(a -> sb.append("\"").append(a.getKey()).append("\": ").append(a.getValue()).append(", "));
        if (sb.length() > 7) {
            sb.delete(sb.length() - 2, sb.length() - 1);
            return sb.toString();
        } else {
            return "В переданной строке отсутствуют символы латинского алфавита!";
        }
    }
}
