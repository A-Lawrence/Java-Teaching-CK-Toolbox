package CK.FileIO;

import CK.Helpers;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by connorkeevill12 on 22/06/2016.
 */
public class FileSequenial {
    public static void main(String[] args) {
        try{
            BufferedWriter bWriter = new BufferedWriter(new FileWriter("./data/output_sequential"));

            String username = Helpers.getInput("Enter your username: ");
            int highscore = Helpers.getIntput("Enter your highscore: ");



        }catch(IOException e){
            System.err.println("There was an error with the file.");
        }
    }
    private static ArrayList<String[]> loadFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/output_sequential"));
            String line;
            ArrayList<Array> wholeFile = String[]

            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
            }
        }catch(IOException e){
            System.err.println("Error handling file.");
        }
    }
}
