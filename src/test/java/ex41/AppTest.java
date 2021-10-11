package ex41;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

public class AppTest 
{
    @Test
    @DisplayName("Testing alphabetizeArrayList function")
    public void alphabetizeArrayListTest() {
        alphabetize a = new alphabetize();
        ArrayList <String> expected = new ArrayList<String>();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("D");

        ArrayList <String> actual = new ArrayList<String>();
        actual.add("D");
        actual.add("A");
        actual.add("B");
        actual.add("C");

        a.alphabetizeArrayList(actual);
        assertArrayEquals(expected.toArray(), actual.toArray());

    }
}
