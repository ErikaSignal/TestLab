package uppgift2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            if (numbers.startsWith("//")) {
                int delimiterEndIndex = numbers.indexOf("\n");
                String customDelimiter = numbers.substring(2, delimiterEndIndex);
                String numbersWithoutDelimiter = numbers.substring(delimiterEndIndex + 1);

                String[] numArray = numbersWithoutDelimiter.split(customDelimiter);
                return sumNumbers(numArray);
            } else {
                String[] numArray = numbers.split("[,\n]");
                return sumNumbers(numArray);
            }


        }
    }

    private int sumNumbers(String[] numArray) {
        List<String> negatives = new ArrayList<>();
        int sum = 0;
        for (String num : numArray) {
            int currentNum = Integer.parseInt(num);
            if (currentNum < 0) {
                negatives.add(num);
            }
            sum += currentNum;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }
        return sum;
    }
}
