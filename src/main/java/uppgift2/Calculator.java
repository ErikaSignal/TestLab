package uppgift2;

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
                int sum = 0;
                for (String num : numArray) {
                    sum += Integer.parseInt(num);
                }
                return sum;
            } else {
                // Split by both commas and new lines
                String[] numArray = numbers.split("[,\n]");
                int sum = 0;
                for (String num : numArray) {
                    sum += Integer.parseInt(num);
                }
                return sum;
            }
        }
    }
}
