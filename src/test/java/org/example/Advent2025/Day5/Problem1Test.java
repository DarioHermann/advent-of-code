package org.example.Advent2025.Day5;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @Test
    public void testProblem1_test() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day5\\test_input.txt");

        List<List<Long>> freshRanges = getFreshRanges(input);
        List<Long> ids = getIds(input);

        assertThat(p.checkFreshness(freshRanges, ids)).isEqualTo(3);
    }

    @Test
    public void testProblem1_actual() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day5\\actual_input.txt");

        List<List<Long>> freshRanges = getFreshRanges(input);
        List<Long> ids = getIds(input);

        assertThat(p.checkFreshness(freshRanges, ids)).isEqualTo(744);
    }

    private List<List<Long>> getFreshRanges(List<String> input) {
        var ranges = new ArrayList<List<Long>>();
        for (var line : input) {
            if(!line.contains("-")) break;
            var parts = line.split("-");
            ranges.add(List.of(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
        }
        return ranges;
    }

    private List<Long> getIds(List<String> input) {
        var ids = new ArrayList<Long>();
        for(var line : input) {
            if(line.isEmpty()) continue;
            if(!line.contains("-")) {
                ids.add(Long.parseLong(line));
            }
        }
        return ids;
    }
}
