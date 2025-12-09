package org.example.Advent2025.Day1;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @Test
    public void testProblem1_test() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListListString("src\\test\\resources\\Advent2025\\Day1\\test_input.txt");

        assertThat(p.rotations(input)).isEqualTo(3);
    }

    @Test
    public void testProblem1_actual() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListListString("src\\test\\resources\\Advent2025\\Day1\\actual_input.txt");
        assertThat(p.rotations(input)).isEqualTo(1120);
    }
}
