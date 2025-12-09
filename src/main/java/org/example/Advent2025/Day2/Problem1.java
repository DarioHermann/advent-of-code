package org.example.Advent2025.Day2;

import java.util.List;

public class Problem1 {
    public String getInvalidNumber(List<List<Long>> inputs) {
        var result = 0L;

        for(var input : inputs) {
            for(long i = input.get(0); i <= input.get(1); i++) {
                if(isValid(i)) {
                    continue;
                }
                result += i;
            }
        }

        return String.valueOf(result);
    }

    private boolean isValid(long number) {
        var numStr = String.valueOf(number);
        if(numStr.length() % 2 != 0) {
            return true;
        }
        return !numStr.substring(0, numStr.length() / 2).equals(numStr.substring(numStr.length() / 2));
    }
}
