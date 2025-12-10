package org.example.Advent2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<String> getInputsFromInputFileNewLineListString(String filePath) throws IOException {
        var path = Path.of(filePath);
        var inputFile = Files.readString(path);
        return List.of(inputFile.split("\r\n"));
    }

    public static List<List<String>> getInputsFromInputFileNewLineListListString(String filePath) throws IOException {
        var path = Path.of(filePath);
        var inputFile = Files.readString(path);
        var lines = inputFile.split("\r\n");

        var inputs = new ArrayList<List<String>>();
        for(var line : lines) {
            var direction = line.substring(0, 1);
            var distance = line.substring(1);
            inputs.add(List.of(direction, distance));
        }
        return inputs;
    }

    public static List<List<Long>> getInputsFromInputFileCommaDashListListLong(String filePath) throws IOException {
        var path = Path.of(filePath);
        var inputFile = Files.readString(path);
        var lines = inputFile.split(",");

        var inputs = new ArrayList<List<Long>>();
        for(var line : lines) {
            var split = line.split("-");
            inputs.add(List.of(Long.parseLong(split[0]), Long.parseLong(split[1])));
        }
        return inputs;
    }

    public static List<List<Character>> getInputsFromInputFileNewLineListListChar(String filePath) throws IOException {
        var path = Path.of(filePath);
        var inputFile = Files.readString(path);
        var lines = inputFile.split("\r\n");

        var inputs = new ArrayList<List<Character>>();
        for(var line : lines) {
            var charList = new ArrayList<Character>();
            for(var c : line.toCharArray()) {
                charList.add(c);
            }
            inputs.add(charList);
        }
        return inputs;
    }
}
