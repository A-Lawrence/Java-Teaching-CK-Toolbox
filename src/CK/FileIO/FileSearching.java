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
            bReader = new BufferedReader(new FileReader("src/CK/FileIO/dictionary.txt"));
            String wordToFind = Helpers.getInput("Enter the word to find in the file: ");

            for(int line = 1; bReader.readLine() != null; line++){
                System.out.println(bReader.readLine() + Integer.toString(line));
                //Unsure why this if statement never executes
                //even when entering a string which I know
                //I put in dictionary.txt, e.g. "bacon"
                if(bReader.readLine().equalsIgnoreCase(wordToFind)){
                    System.out.println(wordToFind + " is on line, " + line);
                }
            }
        }catch (IOException e){
            System.err.println("There was an error handling the file.");
        }
    }
}
