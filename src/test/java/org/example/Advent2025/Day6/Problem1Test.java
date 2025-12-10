package org.example.Advent2025.Day6;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class Problem1Test {
    @Test
    public void testProblem1_test() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day6\\test_input.txt");

        var numbersAndOperator = getValues(input);

        assertThat(p.calculate(numbersAndOperator)).isEqualTo(4277556);
    }

    @Test
    public void testProblem1_actual() throws IOException {
        var p = new Problem1();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day6\\actual_input.txt");

        var numbersAndOperator = getValues(input);

        assertThat(p.calculate(numbersAndOperator)).isEqualTo(3525371263915L);
    }

    private List<List<String>> getValues(List<String> input) {
        List<List<String>> values = new ArrayList<>();

        var line = input.get(0);
        var numbs = line.split(" ");
        int i = 0;
        for(var n : numbs) {
            if(n.isEmpty()) continue;
            var list = new ArrayList<String>();
            list.add(n);
            values.add(list);
            i++;
        }
        for(int j = 1; j < input.size(); j++) {
            i = 0;
            numbs = input.get(j).split(" ");
            for(var n : numbs) {
                if(n.isEmpty()) continue;
                values.get(i).add(n);
                i++;
            }
        }

        return values;
    }
}
