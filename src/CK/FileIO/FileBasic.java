package CK.FileIO;

import CK.Helpers;

import java.io.*;

/**
 * Created by Connor on 21/06/2016.
 */
public class FileBasic {
    public static void main(String[] args) {
        BufferedReader br = getValidBufferedReader("Enter your file name: ");
        BufferedWriter bw;
        String wholeFile = null;
        String line;

        try {
            bw = new BufferedWriter(new FileWriter("./data/output_filebasic.txt"));
            do {
                line = br.readLine();
                wholeFile = wholeFile + line + " ";
            } while (line != null);

            wholeFile = wholeFile.replaceAll("null", "");

            bw.write(wholeFile);
            System.out.println("Your file being written is: " + wholeFile);

            bw.close();

        } catch (IOException e) {
            System.err.println("Error while handling file. ");
            System.err.print(e);
        }
    }


    public static BufferedReader getValidBufferedReader(String prompt) {
        while (true) {
            try {
                return new BufferedReader(new FileReader(Helpers.getInput(prompt)));
            } catch (IOException e) {
                System.err.println("Fail");
            }
        }
    }
}