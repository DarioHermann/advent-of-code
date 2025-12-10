package org.example.Advent2025.Day6;

import org.example.Advent2025.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2Test {
    @Test
    public void testProblem2_test() throws IOException {
        var p = new Problem2();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day6\\test_input.txt");

        var numbersAndOperator = getValues(input);

        assertThat(p.calculate(numbersAndOperator)).isEqualTo(3263827);
    }

    @Test
    public void testProblem2_actual() throws IOException {
        var p = new Problem2();
        var input = Helper.getInputsFromInputFileNewLineListString("src\\test\\resources\\Advent2025\\Day6\\actual_input.txt");

        var numbersAndOperator = getValues(input);

        assertThat(p.calculate(numbersAndOperator)).isEqualTo(6846480843636L);
    }

    // I guess this should have been part of the Problem itself, but oh well
    private List<List<String>> getValues(List<String> input) {
        List<List<String>> values = new ArrayList<>();
        List<Integer> indices = getIndices(input.get(input.size()-1));

        int i = indices.size()-1;
        var index = indices.get(i);
        var arr = new ArrayList<String>();
        for(int current = input.get(0).length()-1; current >= 0; current--) {
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < input.size()-1; j++) {
                if (input.get(j).charAt(current) != ' ') {
                    str.append(input.get(j).charAt(current));
                }
            }
            arr.add(str.toString());
            if(current == index) {
                arr.add(input.get(input.size()-1).substring(current, current+1));
                values.add(arr);
                current--;
                index = indices.get(Math.max(0, --i));
                arr = new ArrayList<>();
            }
        }
        return values;
    }

    private List<Integer> getIndices(String s) {
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+' || s.charAt(i) == '*') {
                indices.add(i);
            }
        }
        return indices;
    }
}
