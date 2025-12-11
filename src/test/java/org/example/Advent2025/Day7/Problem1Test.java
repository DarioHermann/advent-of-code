package org.example.Advent2025.Day7;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @Test
    public void testProblem1_test() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day7\\test_input.txt");

        assertThat(p.beamDown(input)).isEqualTo(21);
    }

    @Test
    public void testProblem1_actual() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day7\\actual_input.txt");

        assertThat(p.beamDown(input)).isEqualTo(1560);
    }
}
