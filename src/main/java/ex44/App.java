/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kaylee Laughner
 */
package ex44;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class match {
    public static int matcher(JSONArray products, String input) {
        // match int var that equals 0 if no match is found
        int match = 0;
        // Creating an iterator
        Iterator it = products.iterator();

        // Loop through it
        while (it.hasNext()) {
            JSONObject result = (JSONObject) it.next();
            String name = (String) result.get("name");

            // Comparing the input to product name
            if (input.toLowerCase().equals(name.toLowerCase())){
                System.out.println("Name: " + name);
                System.out.println("Price: "+ result.get("price"));
                System.out.println("Quantity: "+ result.get("quantity"));
                match = 1;
            }
        }
        return match;
    }
}
public class App {
    public static void main(String[] args) throws IOException, ParseException {
        int matcher = 0;
        do {
            // Reading JSON file in as an object using the JSONParser() in the json.simple package
            Object json = new JSONParser().parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

            // typecasting object json to JSONObject
            JSONObject j = (JSONObject) json;

            // JSONArray with values of products
            JSONArray products = (JSONArray) j.get("products");

            // Asking for user input
            String name = getInput();

            // Call class match
            match m = new match();
            // use matcher method to loop through products to find one matching the input
            matcher = m.matcher(products, name);

            // if result is not found then print statement
            if (matcher == 0) {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        } while( matcher == 0 ); // if result is found then the input loop will stop

    }
    // method to get input from user
    public static String getInput() {
        System.out.println("What is the product name?");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        return name;
    }
}