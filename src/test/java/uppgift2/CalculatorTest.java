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
}