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
}