package com.example.TDD.Assignment;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static final int MAX_LENGTH = 100000;

    public int add(String in) {
        // length check
        if (in != null && in.length() > MAX_LENGTH) {
            System.out.println("The length of string is very large to parse");
            return -1;
        }

        // empty or null than return 0
        if (in == null || in.isEmpty()) {
            return 0;
        }

        // invalid comma usage: consecutive commas
        if (in.contains(",,"))
            throw new RuntimeException("Invalid format: consecutive commas");

        // invalid newline usage: comma-newline or newline-comma
        if (in.contains(",\n") || in.contains("\n,"))
            throw new RuntimeException("Invalid format: misplaced newline");

        // detect & remove custom delimiter
        char customDelim = 0;
        if (in.startsWith("//") && in.length() > 3) {
            int nl = in.indexOf('\n');
            customDelim = in.charAt(2);
            // if header only, return 0
            if (nl == in.length() - 1) {
                return 0;
            }
            in = in.substring(nl + 1);
        }

        // change all delimiters to commas
        String normalized = in.replace('\n', ',');
        if (customDelim != 0) {
            normalized = normalized.replace(customDelim, ',');
        }

        // split & parse integers
        String[] tokens = normalized.split(",", -1);
        List<Integer> numbers = new ArrayList<>(tokens.length);
        for (String tok : tokens) {
            if (tok.isBlank()) continue;
            int val;
            try {
                val = Integer.parseInt(tok.trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid number: \"" + tok + "\"");
            }
            numbers.add(val);
        }

        // collect negatives
        List<Integer> negatives = new ArrayList<>();
        for (int v : numbers) {
            if (v < 0) {
                negatives.add(v);
            }
        }
        if (!negatives.isEmpty()) {
            // format = "<n1,n2,...>"
            StringBuilder sb = new StringBuilder("<");
            for (int i = 0; i < negatives.size(); i++) {
                if (i > 0) sb.append(",");
                sb.append(negatives.get(i));
            }
            sb.append(">");
            throw new IllegalArgumentException("negative numbers not allowed " + sb);
        }

        int sum = 0;
        for (int v : numbers) {
            sum += v;
        }
        return sum;
    }
}
