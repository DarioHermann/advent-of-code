package org.example.Advent2025.Day5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
    public long checkFreshness(List<List<Long>> freshRanges) {
        var rangeMap = getRangeMap(freshRanges);
        return countFreshRange(rangeMap);
    }

    private Map<Long, Integer> getRangeMap(List<List<Long>> freshRanges) {
        var map = new HashMap<Long, Integer>();
        for(var range : freshRanges) {
            if(!map.containsKey(range.get(0))) {
                map.put(range.get(0), -1);
            }
            else {
                map.put(range.get(0), map.get(range.get(0)) - 1);
            }

            if(!map.containsKey(range.get(1))) {
                map.put(range.get(1), 1);
            }
            else {
                map.put(range.get(1), map.get(range.get(1)) + 1);
            }
        }
        return map;
    }

    private long countFreshRange(Map<Long, Integer> rangeMap) {
        long range = 0;
        var sortedKeys = rangeMap.keySet().stream().sorted().toList();
        int j=0;
        var counter = 0;
        for(int i = 0; i < sortedKeys.size(); i=Math.max(j+1, i+1)) {
            counter += rangeMap.get(sortedKeys.get(i));
            if(counter == 0) {
                range++;
                continue;
            }
            for(j = i + 1; j < sortedKeys.size(); j++) {
                counter += rangeMap.get(sortedKeys.get(j));
                if(counter == 0) {
                    range += sortedKeys.get(j) - sortedKeys.get(i)+1;
                    break;
                }
            }
        }
        return range;
    }
}