package org.example.Advent2025.Day2;

import java.util.List;

public class Problem2 {
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
        for(int i = numStr.length() / 2; i >=1; i--) {
            if(numStr.length() % i != 0) {
                continue;
            }
            var isValid = false;
            for(int j = 0; j < numStr.length()-i; j+=i) {
                if(!numStr.substring(j, j + i).equals(numStr.substring(j + i, j + 2*i))) {
                    isValid = true;
                    break;
                }
            }
            if(!isValid) {
                return false;
            }
        }
        return true;
    }
}
