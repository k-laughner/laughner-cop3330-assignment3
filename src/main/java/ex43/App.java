/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Kaylee Laughner
 */
package ex43;
import java.io.*;
import java.util.Scanner;

class generateFiles {
    void websiteFolder() {
        // Specify folder to create
        File f = new File("src/main/java/ex43/website");
        // Create folder
        f.mkdir();
    }
    String webNameFolder(String name) {
        String directory = "src/main/java/ex43/website/"+name;
        // Specify folder to create
        File f = new File(directory);
        // Create website name folder
        f.mkdir();
        return directory;
    }
    void indexCreator(String name, String author) throws IOException {
        // Create html index file
        FileWriter writer = new FileWriter("src/main/java/ex43/website/"+name+"/index.html");
        // Write specified content to the file
        String content = "<title>"+name+"</title>\n<meta>"+author+"</meta>";
        writer.write(content);
        // close the writer
        writer.close();
    }
    void cssFolder(String name) {
        //Specify folder to create
        File f = new File("src/main/java/ex43/website/"+name+"/css");
        // Create website name folder
        f.mkdir();
    }
    void javaScriptFolder(String name) {
        //Specify folder to create
        File f = new File("src/main/java/ex43/website/"+name+"/js");
        // Create website name folder
        f.mkdir();
    }
}

public class App {
    public static void main( String[] args ) throws IOException, FileNotFoundException{

        // Getting User Input
        System.out.println("Site name:");
        String siteName = getInput();
        System.out.println("Author:");
        String author = getInput();
        System.out.println("Do you want a folder for JavaScript? (y/n)");
        String javaScript = getInput();
        System.out.println("Do you want a folder for CSS? (y/n)");
        String css = getInput();
        // End User Input

        // Call generateFiles class
        generateFiles g = new generateFiles();

        // Call method to generate website folder
        g.websiteFolder();
        // Call method to create website name folder
        g.webNameFolder(siteName);
        // Call method to create index.html file
        g.indexCreator(siteName, author);

        // if user says yes to javaScript folder then javaScript folder method called
        if (javaScript.equals("y") || javaScript.equals("Y")) {
            g.javaScriptFolder(siteName);
        }
        // if user says yes to css folder then css folder method called
        if (css.equals("y") || css.equals("Y")) {
            g.cssFolder(siteName);
        }
    }
    // method to get user input
    public static String getInput() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        return str;
    }
}
