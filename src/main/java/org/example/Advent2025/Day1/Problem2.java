package org.example.Advent2025.Day1;

import java.util.List;

public class Problem2 {
    private int result = 0;
    public int rotations(List<List<String>> inputs) {
        int position = 50;
        for(var input : inputs) {
            var direction = input.get(0);
            var distance = Integer.parseInt(input.get(1));

            position = switch (direction) {
                case "L" -> turnLeft(position, distance);
                case "R" -> turnRight(position, distance);
                default -> position;
            };
        }
        System.out.println("this: " + -25%20);
        return result;
    }

    private int turnRight(int position, int distance) {
        position += distance;
        result += position / 100;
        return position % 100;
    }

    private int turnLeft(int position, int distance) {
        System.out.println("Position before left turn: " + position + ", distance: " + distance);
        if(position == 0) {
            System.out.println("Result From 0: " + result);
            result--;
        }
        position -= distance;
        System.out.println("Position after left turn: " + position);

        if(position < 0) {
            System.out.println("Result: " + result + " Position: " + position);
            result++;
            result += (Math.abs(position)) / 100;
            System.out.println("Result: " + result);
            position %= 100;
            position += position != 0 ? 100 : 0;
        }
        else if(position == 0) {
            result++;
        }
//        System.out.println("Normalized position after left turn: " + position);
        return position;
    }
}
