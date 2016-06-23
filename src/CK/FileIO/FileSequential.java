package CK.FileIO;

import CK.Helpers;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by connorkeevill12 on 22/06/2016.
 */
public class FileSequential {
    public static void main(String[] args) {
        //String username = Helpers.getInput("Enter your username: ");
        //int highscore = Helpers.getIntput("Enter your highscore: ");
        ArrayList file = loadFile();
        for(int item = 0; item < file.size(); item ++){
            String[] listItem = (String[]) file.get(item);
            System.out.println(listItem[0] + listItem[1]);
        }
    }


    private static ArrayList loadFile(){

        ArrayList<String[]> wholeFile = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/output_sequential.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
                if(lineSplit != null){
                    wholeFile.add(lineSplit);
                }
            }
        }catch(IOException e){
            System.err.println("Error handling file.");
            System.err.println(e);
        }
        return wholeFile;
    }
}
