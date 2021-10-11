package ex42;

import org.junit.Test;
import org.junit.jupiter.api.*;
import java.util.Scanner;
import static org.junit.Assert.assertArrayEquals;

public class AppTest {
    @Test
    @DisplayName("Test for toArr method")
    public void toArrTest() {
        csvToStringArr c;
        c = new csvToStringArr();
        String[][] expected = new String[1][3];
        expected[0][0] = "Jones";
        expected[0][1] = " Aaron";
        expected[0][2] = " 46000";

        String test = "Jones, Aaron, 46000";
        Scanner input = new Scanner(test);
        String[][] actual = c.toArr(input);

        assertArrayEquals(expected, actual);

    }
}
