package uppgift2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void testAddEmptyStringReturnsZero(){
        Calculator calculator = new Calculator();
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    public void testAddNumberStringReturnsNumber(){
        Calculator calculator = new Calculator();
        int result = calculator.add("3");

        assertEquals(3, result);
    }

    @Test
    public void testAddTwoNumbersStringReturnsSum(){
        Calculator calculator = new Calculator();
        int result = calculator.add("2,2");

        assertEquals(4, result);
    }

    @Test
    public void testAddAnyNumbersReturnsSum(){
        Calculator calculator = new Calculator();
        int result = calculator.add("1,2,3,4,5");

        assertEquals(15, result);
    }

    @Test
    public void testAddWithNewLineReturnsSum(){
        Calculator calculator = new Calculator();
        int result = calculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    public void testCustomDelimiterReturnsSum(){
        Calculator calculator = new Calculator();
        int result = calculator.add("//;\n1;2");

        assertEquals(3, result);
    }

    @Test
    public void testNegativeNumbersThrowsException(){
        Calculator calculator = new Calculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });

        assertEquals("Negatives not allowed: -2, -4", exception.getMessage());
    }
}