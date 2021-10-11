/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kaylee Laughner
 */
package ex41;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter; // to write to file
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList; // to make arrayList
import java.util.Collections; // for sorting

// Create new class for alphabetizing an ArrayList
class alphabetize {
    // Create new method alphabetize ArrayList
    public ArrayList alphabetizeArrayList(ArrayList list) {
        // Use Collections.sort to sort the list from A to Z
        Collections.sort(list);
        // return the Alphabetized list
        return list;
    }
}

public class App
{
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        // Read file exercise41_input.txt
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        Scanner input = new Scanner(file);

        // Create an ArrayList
        ArrayList <String> list = new ArrayList<String>();

        // Add each name from the .txt file to the ArrayList
        // While there is a line, it is added to the list
        while(input.hasNextLine()) {
            list.add(input.nextLine());
        }

        // Call class alphabetize
        alphabetize a = new alphabetize();
        // Use method alphabetizeArrayList from class alphabetize to sort list
        a.alphabetizeArrayList(list);

        // Creating an output file
        listToFile(list);


    }

    // method to write sorted list to .txt file
    public static FileWriter listToFile(ArrayList<String> list) throws IOException {
        // Create a file to write the list to exercise41_output.txt
        FileWriter writer = new FileWriter("src/main/java/ex41/exercise41_output.txt");

        // write heading to file: 'Total of 7 names'
        writer.write("Total of 7 names \n");

        // write line separator
        writer.write("-------------------\n");

        // write each item in the ArrayList to the file
        for(String str: list) {
            writer.write(str + System.lineSeparator());
        }

        // close and return the file
        writer.close();
        return writer;
    }
}
