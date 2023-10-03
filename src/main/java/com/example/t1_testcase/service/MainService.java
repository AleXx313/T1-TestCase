package com.example.t1_testcase.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class MainService {

    public String solve(String text) {
        char[] charSequence = text.toCharArray();
        Map<Character, Integer> result = new TreeMap<>();
        for (char c : charSequence) {
            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                int counter = result.get(c);
                result.put(c, counter + 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        result.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(a -> sb.append("\"").append(a.getKey()).append("\": ").append(a.getValue()).append(", "));
        sb.delete(sb.length() - 2, sb.length() - 1);

        return sb.toString();
    }
}
