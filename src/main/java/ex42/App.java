/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kaylee Laughner
 */
package ex42;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class csvToStringArr {
    public String[][] toArr(Scanner file) {
        // ArrayList to store each last name, first name, and number
        ArrayList<String> first = new ArrayList<String>();
        ArrayList<String> last = new ArrayList<String>();
        ArrayList <String> num = new ArrayList<String>();
        // While there is another line of text in the file
        while (file.hasNext()) {
            // Initialize string to be equal to each line
            String s = file.nextLine();
            // separate columns by their commas
            String[] arr = s.split(",");
            // add each first,last, and number to a list
            last.add(arr[0]);
            first.add(arr[1]);
            num.add(arr[2]);
        }
        String[][] data = new String[last.size()][3];
        for (int i =0; i<last.size(); i++){
            data[i][0] = last.get(i);
            data[i][1] = first.get(i);
            data[i][2] = num.get(i);
        }
        return data;
    }
}
class App {
    public static void main( String[] args ) throws FileNotFoundException {
        // Read file exercise42_input.txt
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner input = new Scanner(file);

        csvToStringArr c = new csvToStringArr();
        String[][] parsedFile = c.toArr(input);

        print(parsedFile);
    }
    public static void print(String[][] parsedFile) {
        System.out.println("Last        First        Salary");
        System.out.println("------------------------------");
        for (int i=0; i< parsedFile.length; i++) {
            System.out.printf("%-12s %-12s %-12s \n", parsedFile[i][0], parsedFile[i][1], parsedFile[i][2]);
        }
    }
}
