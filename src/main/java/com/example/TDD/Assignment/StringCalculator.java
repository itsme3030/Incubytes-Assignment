package com.example.TDD.Assignment;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static int MAX_LENGTH = 100000;
    public int add(String in) {
        // if length is above 1e5 then its invalide
        if (in != null && in.length() > MAX_LENGTH) {
            System.out.println("The length of string is very large to parse");
            return -1;
        }
        // if empty than ans = 0 ...
        if (in == null || in.isEmpty()) {
            return 0;
        }

        // detect custom delimiter
        char customDelim = 0;
        if (in.startsWith("//")) {
            int nl = in.indexOf('\n');
            customDelim = in.charAt(2);
            in = in.substring(nl + 1);
        }

        // normalize all delimiters to comma
        // so we only have to split on ','
        String normalized = in.replace('\n', ',');
        if (customDelim != 0) {
            normalized = normalized.replace(customDelim, ',');
        }

        // 5) split and parse
        String[] tokens = normalized.split(",", -1);
        List<Integer> numbers = new ArrayList<>(tokens.length);
        for (String tok : tokens) {
            if (tok.isBlank()) {
                continue;
            }
            int val;
            try {
                val = Integer.parseInt(tok.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number: \"" + tok + "\"");
            }
            numbers.add(val);
        }

        // if any negatives than throw exception
        List<Integer> negatives = new ArrayList<>();
        for (int v : numbers) {
            if (v < 0) {
                negatives.add(v);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }


        int sum = 0;
        for (int v : numbers) {
            sum += v;
        }
        return sum;
    }
}
