package org.example.Advent2025.Day3;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2Test {
    @Test
    public void testProblem2_test() throws IOException {
        var p = new Problem2();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day3\\test_input.txt");

        assertThat(p.getJoltage(input)).isEqualTo(3121910778619L);
    }

    @Test
    public void testProblem2_actual() throws IOException {
        var p = new Problem2();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day3\\actual_input.txt");
        assertThat(p.getJoltage(input)).isEqualTo(171518260283767L);
    }
}
