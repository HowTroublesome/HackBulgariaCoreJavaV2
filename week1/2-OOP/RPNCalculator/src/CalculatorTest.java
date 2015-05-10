import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testCalculateWithRPN() {
        assertEquals(Calculator.calculateWithRPN("5"), "5.0");
        assertEquals(Calculator.calculateWithRPN("3 + (5 + 9*7 + 9)"), "80.0");
        assertEquals(Calculator.calculateWithRPN("4*(4 + 5)"), "36.0");
        assertEquals(Calculator.calculateWithRPN("(5+3)!"), "40320.0");
        assertEquals(Calculator.calculateWithRPN("2^3! + 5*((3+2!)^2)"), "189.0");
    }

}
