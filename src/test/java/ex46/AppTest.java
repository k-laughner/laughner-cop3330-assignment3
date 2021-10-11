/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kaylee Laughner
 */
package ex46;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.CoreMatchers.is;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Map;
import java.util.TreeMap;

public class AppTest {
    @Test
    @DisplayName("Checking countFrequencies method for accuracy")
    public void countFrequenciesTest() throws IOException {
        wordFrequency w = new wordFrequency();
        Map<String, Integer> expectedMap = new TreeMap<>();
        Map<String, Integer> actualMap = new TreeMap<>();
        expectedMap.put("badger", 7);
        expectedMap.put("mushroom", 2);
        expectedMap.put("snake", 1);

        String fileContent = new String(Files.readAllBytes(Paths.get("src/main/java/ex46/exercise46_input.txt")));
        actualMap = w.countFrequencies(fileContent);
        assertThat(expectedMap, is(actualMap));

    }
}
