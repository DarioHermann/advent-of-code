package org.example.Advent2025.Day5;

import java.util.List;

public class Problem1 {
    public int checkFreshness(List<List<Long>> freshRanges, List<Long> ids) {
        int result = 0;
        for(var id : ids) {
            if(freshRanges.stream().anyMatch(range -> id >= range.get(0) && id <= range.get(1))) {
                result++;
            }
        }

        return result;
    }
}