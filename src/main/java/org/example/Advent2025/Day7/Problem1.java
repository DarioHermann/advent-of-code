package org.example.Advent2025.Day7;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public int beamDown(List<String> tachyonMapOriginal) {
        int result = 0;
        var tachyonMap = new ArrayList<>(tachyonMapOriginal);
        int initialIndex = tachyonMap.get(0).indexOf('S');
        tachyonMap.set(1, tachyonMap.get(1).substring(0, initialIndex) + '|' + tachyonMap.get(1).substring(initialIndex + 1));

        for(int i = 1; i < tachyonMap.size()-1; i++) {
            for(int j = 0; j < tachyonMap.get(i).length(); j++) {
                if(tachyonMap.get(i).charAt(j) == '|') {
                    if(tachyonMap.get(i+1).charAt(j) == '.') {
                        tachyonMap.set(i+1, tachyonMap.get(i+1).substring(0, j) + '|' + tachyonMap.get(i+1).substring(j + 1));
                    } else if(tachyonMap.get(i+1).charAt(j) == '^') {
                        result++;
                        tachyonMap.set(i+1, tachyonMap.get(i+1).substring(0, j-1) + "|^|" + tachyonMap.get(i+1).substring(j + 2));
                    }
                }
            }
        }

        return result;
    }
}