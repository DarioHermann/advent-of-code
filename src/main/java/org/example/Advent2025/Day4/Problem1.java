package org.example.Advent2025.Day4;

import java.util.List;

public class Problem1 {
    public int getAccessibleRolls(List<List<Character>> map) {
        int result = 0;
        for(int i = 0; i < map.size(); i++) {
            result += getAccessibleRollsThisLine(i, map);
        }
        return result;
    }

    private int getAccessibleRollsThisLine(int i, List<List<Character>> map) {
        if(i == 0) {
            return checkOnlyNextLine(map.get(i), map.get(i + 1));
        }
        if(i == map.size() - 1) {
            return checkOnlyPreviousLine(map.get(i), map.get(i - 1));
        }
        return checkBothLines(map.get(i), map.get(i - 1), map.get(i + 1));

    }

    private int checkBothLines(List<Character> currentLine, List<Character> previousLine, List<Character> nextLine) {
        int accessibleRolls = 0;
        for(int j = 0; j < currentLine.size(); j++) {
            if(currentLine.get(j) != '@') {
                continue;
            }
            int count = 0;
            if(j > 0) {
                if (currentLine.get(j-1) == '@') {
                    count++;
                }
                if(previousLine.get(j-1) == '@') {
                    count++;
                }
                if(nextLine.get(j-1) == '@') {
                    count++;
                }
            }
            if (previousLine.get(j) == '@') {
                count++;
            }
            if (nextLine.get(j) == '@') {
                count++;
            }
            if(count > 3) continue;
            if(j < currentLine.size() - 1) {
                if (previousLine.get(j+1) == '@') {
                    count++;
                }
                if(count > 3) continue;
                if (nextLine.get(j+1) == '@') {
                    count++;
                }
                if(count > 3) continue;
                if(currentLine.get(j+1) == '@') {
                    count++;
                }
                if(count > 3) continue;
            }
            accessibleRolls++;
        }
        return accessibleRolls;
    }

    private int checkOnlyNextLine(List<Character> currentLine, List<Character> nextLine) {
        int accessibleRolls = 0;
        for(int j = 0; j < currentLine.size(); j++) {
            if(currentLine.get(j) != '@') {
                continue;
            }
            int count = 0;
            if(j > 0) {
                if (currentLine.get(j-1) == '@') {
                    count++;
                }
                if(nextLine.get(j-1) == '@') {
                    count++;
                }
            }
            if (nextLine.get(j) == '@') {
                count++;
            }
            if(j < currentLine.size() - 1) {
                if (nextLine.get(j+1) == '@') {
                    count++;
                }
                if(currentLine.get(j+1) == '@') {
                    count++;
                }
            }
            if(count < 4) {
                accessibleRolls++;
            }
        }
        return accessibleRolls;
    }

    private int checkOnlyPreviousLine(List<Character> currentLine, List<Character> previousLine) {
        int accessibleRolls = 0;
        for(int j = 0; j < currentLine.size(); j++) {
            if(currentLine.get(j) != '@') {
                continue;
            }
            int count = 0;
            if(j > 0) {
                if (currentLine.get(j-1) == '@') {
                    count++;
                }
                if(previousLine.get(j-1) == '@') {
                    count++;
                }
            }
            if (previousLine.get(j) == '@') {
                count++;
            }
            if(j < currentLine.size() - 1) {
                if (previousLine.get(j+1) == '@') {
                    count++;
                }
                if(currentLine.get(j+1) == '@') {
                    count++;
                }
            }
            if(count < 4) {
                accessibleRolls++;
            }
        }
        return accessibleRolls;
    }
}
