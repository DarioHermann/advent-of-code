package org.example.Advent2025.Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
    public long beamDown(List<String> tachyonMapOriginal) {
        long result = 0;
        var tachyonMap = createMatrix(tachyonMapOriginal);
        int initialIndex = tachyonMapOriginal.get(0).indexOf('S');
        tachyonMap.get(1).set(initialIndex, 1L);

        for(int i = 1; i < tachyonMap.size()-1; i+=2) {
            for(int j = 0; j < tachyonMap.get(i).size(); j++) {
                var currentVal = tachyonMap.get(i).get(j);
                if(currentVal != 0) {
                    if(tachyonMap.get(i+1).get(j) == 0) {
                        tachyonMap.get(i+1).set(j, currentVal);
                        tachyonMap.get(i+2).set(j, currentVal);
                    } else if(tachyonMap.get(i+1).get(j) == -1) {
                        if(tachyonMap.get(i+1).get(j-1) == 0) {
                            tachyonMap.get(i+1).set(j-1, currentVal);
                            tachyonMap.get(i+2).set(j-1, currentVal);
                        } else {
                            var r = tachyonMap.get(i + 1).get(j-1) + tachyonMap.get(i).get(j);
                            tachyonMap.get(i+1).set(j-1, r);
                            tachyonMap.get(i+2).set(j-1, r);
                        }
                        if(tachyonMap.get(i+1).get(j+1) == 0) {
                            tachyonMap.get(i+1).set(j+1, currentVal);
                            tachyonMap.get(i+2).set(j+1, currentVal);
                        } else {
                            var r = tachyonMap.get(i + 1).get(j+1) + tachyonMap.get(i).get(j);
                            tachyonMap.get(i+1).set(j+1, r);
                            tachyonMap.get(i+2).set(j+1, r);
                        }
                    } else {
                        var r = tachyonMap.get(i + 1).get(j) + tachyonMap.get(i).get(j);
                        tachyonMap.get(i+1).set(j, r);
                        tachyonMap.get(i+2).set(j, r);
                    }
                }
            }
        }

        for(var number : tachyonMap.get(tachyonMap.size()-1)){
            result += number;
        }

        return result;
    }

    private List<List<Long>> createMatrix(List<String> tachyonMapOriginal) {
        Map<Character, Long> map = new HashMap<>() {{
            put('.', 0L);
            put('S', -2L);
            put('^', -1L);
        }};
        var matrix = new ArrayList<List<Long>>();
        for(var line : tachyonMapOriginal) {
            var list = new ArrayList<Long>();
            for(var c : line.toCharArray()) {
                list.add(map.get(c));
            }
            matrix.add(list);
        }
        return matrix;
    }
}