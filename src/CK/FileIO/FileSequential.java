package CK.FileIO;

import CK.Helpers;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by connorkeevill12 on 22/06/2016.
 */
public class FileSequential {
    public static void main(String[] args) {

        String username = Helpers.getInput("Enter your username: ");
        int highscore = Helpers.getIntput("Enter your highscore: ");

        ArrayList file = loadFile();
        int indexOfHighscore = getIndexOfHighScore(0, file.size(), file, highscore);
        //not needed
        System.out.println(indexOfHighscore);

        boolean newHighScore = isNewHighScore(highscore, indexOfHighscore, file);

        //not needed
        if(newHighScore){
            System.out.println("The new score belongs in index: " + indexOfHighscore);
        }else{
            System.out.println("The new score already exists at index: " + indexOfHighscore);
        }

        if(newHighScore){
            addNewHighscore(file, username, indexOfHighscore, highscore);
        }else{
            updateHighScore();
        }
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

        int currentIndex = calculateCurrentIndex(startPoint, endPoint);
        String[] lineItems = (String[]) file.get(currentIndex);
        int item = getScoreFromFile(lineItems);

        if (item == score || isScoreNewRecord(score, currentIndex, file)){
            return currentIndex;
        }else if(currentIndex == file.size() - 1 && score < item){
            return currentIndex + 1;
        }

        if (item < score) {
            currentIndex = getIndexOfHighScore(startPoint, currentIndex, file, score);
            return (currentIndex);
        } else if (item > score) {
            currentIndex = getIndexOfHighScore(currentIndex, endPoint, file, score);
            return (currentIndex);
        }
        return 0;
    }

    private static boolean isScoreNewRecord(int score, int index, ArrayList file){

        String[] scoreNow = (String[]) file.get(index);
        String[] higherScore = null;
        if(index != 0){
            higherScore = (String[]) file.get(index-1);
        }

        if(index == 0 && score > getScoreFromFile(scoreNow)){
            return true;
        }else if(score > getScoreFromFile(scoreNow) && score < getScoreFromFile(higherScore)){
            return true;
        }
        return false;
    }

    private static int getScoreFromFile(String[] line) {
        return Integer.parseInt(line[1].trim());
    }

    private static int calculateCurrentIndex(int startPoint, int endPoint) {
        return (startPoint + endPoint) / 2;
    }

    private static boolean isNewHighScore(int score, int index, ArrayList file){
        int scoreNow = getScoreFromFile((String[]) file.get(index));
        return !(score == scoreNow);
    }

    private static void addNewHighscore(ArrayList file, String user, int index, int score) {
        String[] write = {user, Integer.toString(score)};
        file.add(index, write);
        saveToFile(file);
    }

    private static void updateHighScore(ArrayList file, String user, int index, int score){
        //work from here
    }

    private static void saveToFile(ArrayList<String[]> fileData){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./data/output_sequential.txt"));

            for(int i = 0; i < fileData.size(); i++){
                bw.write(String.join(",",  fileData.get(i)));
                bw.newLine();
            }

            bw.close();
        }catch(IOException e){
            System.err.println("There was an error handling the file.");
        }
    }
}
