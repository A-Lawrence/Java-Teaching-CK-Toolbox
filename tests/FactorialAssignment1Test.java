import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialAssignment1Test {
    @Test
    public void test_number_one() {
        assertEquals(1, FactorialAssignment1.calculateFactorial(1));
    }

    @Test
    public void test_number_3() {
        assertEquals(6, FactorialAssignment1.calculateFactorial(3));
    }

}
