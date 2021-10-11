/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kaylee Laughner
 */
package ex46;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

class wordFrequency {
    // method to count frequency of each word present in content
    Map countFrequencies(String fileContent) {
        // Removing line breaks in String content and replacing them with spaces
        String tempContent = fileContent.replace("\n", " ").replace("\r", " ");
        // Removing any double spacing between words due to split at line breaks
        String content = tempContent.replace("  ", " ");
        // Creating a string array that separates the words in String content
        String[] words = content.split(" ");
        // Creating a map
        Map<String, Integer> map = new TreeMap<>();
        for (int i=0; i<words.length; i++) {
            // if map already has the word in it
            // then add 1 to int count of the word
            if(map.containsKey(words[i])) {
                map.put(words[i], 1+map.get(words[i]));
            }
            // if map does not have the word, then add it to the map
            else {
                map.put(words[i], 1);
            }
        }
        // return map when function is called
        return map;
    }
}
public class App {
    public static void main(String[] args) throws IOException {
        // Reads file exercise46_input.txt in as a String
        String content = new String(Files.readAllBytes(Paths.get("src/main/java/ex46/exercise46_input.txt")));

        // Calling class wordFrequency
        wordFrequency w = new wordFrequency();
        Map<String, Integer> map = w.countFrequencies(content);

        // calls print graphic function
        printGraphic(map);
    }
    public static void printGraphic(Map<String, Integer> map) {
        // for each map entry
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            // initializing variable for * string
            String starGraphic = "";
            // initializing variable for the number of * that should appear
            // to be the word frequency
            int count = entry.getValue();
            // for every 1 word present, a * is added to string starGraphic
            for (int i=0; i<count; i++) {
                starGraphic=starGraphic+"*";
            }
            // printing word and stars to represent word's frequency
            System.out.printf("%-8s: %s \n",entry.getKey(), starGraphic);
        }
    }
}
