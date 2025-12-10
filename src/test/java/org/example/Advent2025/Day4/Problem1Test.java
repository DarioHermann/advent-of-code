package org.example.Advent2025.Day4;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @Test
    public void testProblem1_test() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListListChar("src\\test\\resources\\Advent2025\\Day4\\test_input.txt");

        assertThat(p.getAccessibleRolls(input)).isEqualTo(13);
    }

    @Test
    public void testProblem1_actual() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListListChar("src\\test\\resources\\Advent2025\\Day4\\actual_input.txt");
        assertThat(p.getAccessibleRolls(input)).isEqualTo(1389);
    }
}
