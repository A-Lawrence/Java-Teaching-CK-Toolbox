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
        int highscore = Helpers.getIntput("Enter your highscore: ");

        ArrayList file = loadFile();
        int indexOfHighscore = getIndexOfHighScore(0, file.size(), file, highscore);
        System.out.println(indexOfHighscore);

    }

    private static ArrayList loadFile() {

        ArrayList<String[]> wholeFile = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/output_sequential.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
                if (lineSplit != null) {
                    wholeFile.add(lineSplit);
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error handling file: ");
            System.err.println(e);
        }
        return wholeFile;
    }

    private static int getIndexOfHighScore(int startPoint, int endPoint, ArrayList file, int score) {

        int midPointOfSector = calculateMidPoint(startPoint, endPoint);
        String[] lineItems = (String[]) file.get(midPointOfSector);

        //guardAgainstStackOverflow()

        if (Integer.parseInt(lineItems[1].trim()) == score) {
            return midPointOfSector;
        }
        if (Integer.parseInt(lineItems[1].trim()) < score) {
            return (midPointOfSector = getIndexOfHighScore(startPoint, midPointOfSector, file, score));
        } else if (Integer.parseInt(lineItems[1].trim()) > score) {
            return (midPointOfSector = getIndexOfHighScore(midPointOfSector, endPoint, file, score));
        }
        return 0;
    }
    private static int calculateMidPoint(int startPoint, int endPoint) {
        return (startPoint + endPoint) / 2;
    }
}