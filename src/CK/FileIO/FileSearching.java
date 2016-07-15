package CK.FileIO;

import CK.Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Connor on 21/06/2016.
 */
public class FileSearching {
    public static void main(String[] args) {
        BufferedReader bReader;

        try {
            bReader = new BufferedReader(new FileReader("./data/dictionary.txt"));
            String wordToFind = Helpers.getInput("Enter the word to find in the file: ");

            String lineValue = "";
            int lineNumber = 1;

            while((lineValue = bReader.readLine()) != null){

                if(lineValue.trim().equalsIgnoreCase(wordToFind)){
                    System.out.println(wordToFind + " is on line, " + lineNumber);
                }

                lineNumber++;
            }

        }catch (IOException e){
            System.err.println("There was an error handling the file.");
        }
    }
}
