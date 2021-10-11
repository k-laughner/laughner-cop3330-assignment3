package ex45;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    @DisplayName("Testing that searchAndReplace is successful")
    public void searchAndReplaceTest() {
        searchReplace s = new searchReplace();
        String expected = "I love cats!";
        String actual = s.searchAndReplace("I love dogs!", "cats", "dogs");
        assertEquals(expected, actual);
    }
}
