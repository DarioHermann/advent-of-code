package org.example.Advent2025.Day3;

import java.util.List;

public class Problem2 {
    public long getJoltage(List<String> banks) {
        var result = 0L;
        for(var bank : banks) {
            result += getHighestVoltage(bank);
        }
        return result;
    }

    private long getHighestVoltage(String bank) {
        StringBuilder voltage = new StringBuilder();
        var minIndex = 0;
        for(int i = 12; i > 0; i--) {
            int highest = 10;
            var bankSubstring = bank.substring(minIndex);
            int indexOfHighest;
            do {
                indexOfHighest = bankSubstring.indexOf((char) ('0' + --highest));
            } while(indexOfHighest == -1 || indexOfHighest > bankSubstring.length()-i);
            voltage.append(bankSubstring.charAt(indexOfHighest));
            minIndex += indexOfHighest + 1;
        }
        return Long.parseLong(voltage.toString());
    }
}
