package Advent2025.Day1;

import org.example.Advent2025.Day1.Problem1;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @Test
    public void testProblem1_test() throws IOException {
        var p = new Problem1();
        var path = Path.of("src\\test\\resources\\Advent2025\\Day1\\test_input.txt");
        var inputFile = Files.readString(path);

        var input = getInputsFromInputFile(inputFile);

        assertThat(p.rotations(input)).isEqualTo(3);
    }

    @Test
    public void testProblem1_actual() throws IOException {
        var p = new Problem1();
        var path = Path.of("src\\test\\resources\\Advent2025\\Day1\\actual_input.txt");
        var inputFile = Files.readString(path);

        var input = getInputsFromInputFile(inputFile);
        assertThat(p.rotations(input)).isEqualTo(1120);
    }

    private List<List<String>> getInputsFromInputFile(String inputFile) {
        var lines = inputFile.split("\r\n");

        var inputs = new ArrayList<List<String>>();
        for(var line : lines) {
            var direction = line.substring(0, 1);
            var distance = line.substring(1);
            inputs.add(List.of(direction, distance));
        }
        return inputs;
    }
}
