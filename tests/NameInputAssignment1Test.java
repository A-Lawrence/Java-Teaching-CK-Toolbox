import CK.Assignment1.NameInputAssignment1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameInputAssignment1Test {
    @Test
    public void test_convert_fully_uppercase() {
        String name = "JAKE";

        name = NameInputAssignment1.capitaliseFirstLetter(name);

        assertEquals("Jake", name);
    }

    @Test
    public void test_convert_fully_lowercase() {
        String name = "connor";

        name = NameInputAssignment1.capitaliseFirstLetter(name);

        assertEquals("Connor", name);
    }

    @Test
    public void test_convert_mixed_case() {
        String name = "bReNdOn";

        name = NameInputAssignment1.capitaliseFirstLetter(name);

        assertEquals("Brendon", name);
    }

}
