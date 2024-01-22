package uppgift2;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
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
