package org.example.Advent2025.Day6;

import java.util.List;

public class Problem1 {
    public long calculate(List<List<String>> listOfValues) {
        long result = 0;

        for(var values : listOfValues) {
            result += switch(values.get(values.size()-1)) {
                case "+" -> addAllValues(values);
                case "*" -> multiplyAllValues(values);
                default -> throw new IllegalStateException("Unexpected value: " + values.get(values.size()-1));
            };
        }

        return result;
    }

    private long addAllValues(List<String> values) {
        long sum = 0;
        for(int i = 0; i < values.size() - 1; i++) {
            sum += Long.parseLong(values.get(i));
        }
        return sum;
    }

    private long multiplyAllValues(List<String> values) {
        long multiplication = 1;
        for(int i = 0; i < values.size() - 1; i++) {
            multiplication *= Long.parseLong(values.get(i));
        }
        return multiplication;
    }
}