package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.FileReader;
import org.json.simple.parser.ParseException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    @DisplayName("Testing matcher method for successful matching")
    public void matcherTest() throws ParseException, IOException {
        match m = new match();

        // Reading JSON file in as an object using the JSONParser() in the json.simple package
        Object json = new JSONParser().parse(new FileReader("src/main/java/ex44/exercise44_input.json"));
        // typecasting object json to JSONObject
        JSONObject j = (JSONObject) json;
        // JSONArray with values of products
        JSONArray products = (JSONArray) j.get("products");

        int expected = 1;
        int actual = m.matcher(products, "Thing");
        // testing that successfully matches with an item on list
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Testing matcher method for no match found")
    public void matcherTest2() throws ParseException, IOException{
        match m = new match();

        // Reading JSON file in as an object using the JSONParser() in the json.simple package
        Object json = new JSONParser().parse(new FileReader("src/main/java/ex44/exercise44_input.json"));
        // typecasting object json to JSONObject
        JSONObject j = (JSONObject) json;
        // JSONArray with values of products
        JSONArray products = (JSONArray) j.get("products");

        int expected2 = 0;
        int actual2 = m.matcher(products, "Cat Food");
        // testing that successfully does not match if item not on list
        assertEquals(expected2, actual2);
    }

}
