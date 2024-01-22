package uppgift2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        Matcher matcher = Pattern.compile("-?\\d+").matcher(numbers);
        List<String> numberList = new ArrayList<>();
        while (matcher.find()) {
            numberList.add(matcher.group());
        }
        return sumNumbers(numberList);
    }



    private int sumNumbers(List<String> numArray) {
        List<String> negatives = new ArrayList<>();
        int sum = 0;
        for (String num : numArray) {
            int currentNum = Integer.parseInt(num);
            if (currentNum < 0) {
                negatives.add(num);
            } else if (currentNum <= 1000) {
                sum += currentNum;
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }
        return sum;
    }
}
