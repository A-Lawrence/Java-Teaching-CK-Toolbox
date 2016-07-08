package CK.FileIO;

import CK.FileIO.Highscore.Highscore;
import CK.Helpers;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by connorkeevill12 on 22/06/2016.
 */
public class FileSequential {
    public static void main(String[] args) {

        String username = Helpers.getInput("Enter your username: ");
        int highscore = Helpers.getIntput("Enter your highscore: ");

        ArrayList<Highscore> file = loadFile();

        int indexOfHighscore = getIndexOfHighScore(0, file.size() - 1, file, highscore);
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
            updateHighScore(file, username, indexOfHighscore, highscore);
        }
    }

    private static ArrayList<Highscore> loadFile() {

        ArrayList<Highscore> wholeFile = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/output_sequential.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
                if (lineSplit != null) {
                    Highscore hs = new Highscore(lineSplit[0].trim(), lineSplit[1].trim());
                    wholeFile.add(hs);
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error handling file: ");
            System.err.println(e);
        }
        return wholeFile;
    }

    private static int getIndexOfHighScore(int startPoint, int endPoint, ArrayList<Highscore> file, int score) {

        int currentIndex = (startPoint + endPoint) / 2;

        if(startPoint == endPoint){
            return currentIndex + 1;
        }

        Highscore highscore = file.get(currentIndex);

        if (highscore.getScore() == score){
            return currentIndex;
        }

        if (highscore.getScore() < score) {
            return getIndexOfHighScore(startPoint, currentIndex - 1, file, score);
        }

        if (highscore.getScore() > score) {
            return getIndexOfHighScore(currentIndex + 1, endPoint, file, score);
        }

        return 0;
    }

//    private static boolean isScoreNewRecord(int score, int index, ArrayList file){
//
//        String[] scoreNow = (String[]) file.get(index);
//        String[] higherScore = null;
//        if(index != 0){
//            higherScore = (String[]) file.get(index-1);
//        }
//
//        if(index == 0 && score > getScoreFromFile(scoreNow)){
//            return true;
//        }else if(score > getScoreFromFile(scoreNow) && score < getScoreFromFile(higherScore)){
//            return true;
//        }
//        return false;
//    }

//    private static int getScoreFromFile(String[] line) {
//        return Integer.parseInt(line[1].trim());
//    }
//
//    private static String getNameFromFile(String[] line) {
//        return line[0].trim();
//    }
//
//    private static int calculateCurrentIndex(int startPoint, int endPoint) {
//        return (startPoint + endPoint) / 2;
//    }

    private static boolean isNewHighScore(int score, int index, ArrayList<Highscore> file){
        Highscore scoreNow = file.get(index);
        return !(score == scoreNow.getScore());
    }

    private static void addNewHighscore(ArrayList<Highscore> file, String user, int index, int score) {
        Highscore hs = new Highscore(user, score);
        file.add(index, hs);
        saveToFile(file);
    }

    private static void updateHighScore(ArrayList<Highscore> file, String user, int index, int score){
        Highscore data = new Highscore(user, score);
        Highscore line = file.get(index);

        if(line.getUsername() == user){
            file.set(index, data);
        }else{
            file.add(index + 1, data);
        }
    }

    private static void saveToFile(ArrayList<Highscore> file){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./data/output_sequential.txt"));

            for(int i = 0; i < file.size(); i++){
                Highscore line = file.get(i);
                bw.write(line.getUsername() + ", " + line.getScore());
                bw.newLine();
            }

            bw.close();
        }catch(IOException e){
            System.err.println("There was an error handling the file.");
        }
    }
}
