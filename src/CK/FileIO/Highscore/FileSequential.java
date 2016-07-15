package CK.FileIO.Highscore;

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

        HighscoreStore scoreBoard = new HighscoreStore("./data/output_sequential.txt");

        int indexOfHighscore = scoreBoard.findHighscorePosition(0, (scoreBoard.getHighscores().size()), highscore);
        boolean userNewRecord = scoreBoard.isUserNewRecord(username, highscore);

        if (userNewRecord) {
            System.out.println("Record 2");
            scoreBoard.removeUser(username);
        }

        scoreBoard.addHighscore(indexOfHighscore, username, highscore);
        scoreBoard.saveToFile();
    }
}

/*
        //not needed
        if(newHighScore){
            System.out.println("The new score belongs in index: " + indexOfHighscore);
        }else{
            System.out.println("The new score already exists at index: " + indexOfHighscore);
        }

        if(newHighScore){
            addNewHighscore(scoreBoard, username, indexOfHighscore, highscore);
        }else{
            updateHighScore(scoreBoard, username, indexOfHighscore, highscore);
        }

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
*/
