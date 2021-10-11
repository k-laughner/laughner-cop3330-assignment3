package ex43;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    @DisplayName("Checking that directory includes specified name by user")
    public void webNameFolderTest() {
        generateFiles g = new generateFiles();
        String expected = "src/main/java/ex43/website/awesomeco";
        String actual = g.webNameFolder("awesomeco");
        assertEquals(expected, actual);
    }
}
