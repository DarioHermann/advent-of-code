package org.example.Advent2025.Day1;

import java.util.List;

public class Problem1 {
    public int rotations(List<List<String>> inputs) {
        int position = 50;
        int result = 0;
        for(var input : inputs) {
            var direction = input.get(0);
            var distance = Integer.parseInt(input.get(1));

            position = switch (direction) {
                case "L" -> turnLeft(position, distance);
                case "R" -> turnRight(position, distance);
                default -> position;
            };

            if(position == 0) {
                result++;
            }
        }
        return result;
    }

    private int turnRight(int position, int distance) {
        position += distance;
        return position % 100;
    }

    private int turnLeft(int position, int distance) {
        position -= distance;
        if(position < 0) {
            position %= 100;
            position += position != 0 ? 100 : 0;
        }
        return position;
    }
}
