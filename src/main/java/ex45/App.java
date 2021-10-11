/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kaylee Laughner
 */
package ex45;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
class searchReplace {
    public String searchAndReplace(String content, String newWord, String oldWord) {
        String newContent = content.replaceAll(oldWord, newWord);
        return newContent;
    }
}
public class App {
    public static void main(String[] args) throws IOException {
        // Reads file exercise45_input.txt in as a String
        String oldContent = new String(Files.readAllBytes(Paths.get("src/main/java/ex45/exercise45_input.txt")));
        String oldTerm = "utilize";
        String newTerm = "use";

        // Call class searchReplace
        searchReplace sr = new searchReplace();
        // Call searchAndReplace function
        String newContent = sr.searchAndReplace(oldContent, newTerm, oldTerm);

        // Call outputFile to get the outputFile name
        String outputName = outputFile();
        // Call createFile to get the output file
        createFile(outputName, newContent);
    }
    public static String outputFile() {
        System.out.println("What is the name of the output file? (Do not include .txt portion of name -- only include name of file)");
        Scanner input = new Scanner(System.in);
        String outputFileName = input.nextLine();
        return outputFileName;
    }
    public static FileWriter createFile(String name, String content) throws IOException {
        // Creating file of the specified name
        FileWriter writer = new FileWriter("src/main/java/ex45/"+name+".txt");
        // Writing new content to file
        writer.write(content);
        // Closing the writer
        writer.close();

        return writer;
    }
}
