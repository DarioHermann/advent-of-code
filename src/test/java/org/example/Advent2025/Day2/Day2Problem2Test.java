package org.example.Advent2025.Day2;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Problem2Test {
    @Test
    public void day2_TestProblem2_test() throws IOException {
        var p = new Problem2();
        var input = Helper.getInputsFromInputFileCommaDashListListLong("src\\test\\resources\\Advent2025\\Day2\\test_input.txt");

        assertThat(p.getInvalidNumber(input)).isEqualTo("4174379265");
    }

    @Test
    public void day2_TestProblem2_actual() throws IOException {
        var p = new Problem2();
        var input = Helper.getInputsFromInputFileCommaDashListListLong("src\\test\\resources\\Advent2025\\Day2\\actual_input.txt");
        assertThat(p.getInvalidNumber(input)).isEqualTo("38731915928");
    }
}
