package org.example.Advent2025.Day3;

import java.util.List;

public class Problem1 {
    public int getJoltage(List<String> banks) {
        var result = 0;
        for(var bank : banks) {
            result += getHighestVoltage(bank);
        }
        return result;
    }

    private int getHighestVoltage(String bank) {
        int highest = 10;
        int index;
        do {
            index = bank.indexOf((char) ('0' + --highest));
        } while(index == -1 || index == bank.length()-1);

        int secondHighest = 10;
        var bankSubstring = bank.substring(index+1);
        int secondIndex;
        do {
            secondIndex = bankSubstring.indexOf((char) ('0' + --secondHighest));
        } while(secondIndex == -1 && secondHighest > 0);

        var voltage = "%s%s".formatted(Character.getNumericValue(bank.charAt(index)), Character.getNumericValue(bankSubstring.charAt(secondIndex)));
        return Integer.parseInt(voltage);
    }
}
