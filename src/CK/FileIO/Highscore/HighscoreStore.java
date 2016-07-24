package CK.FileIO.Highscore;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Connor on 12/07/2016.
 */
public class HighscoreStore {
    private ArrayList<Highscore> highscores = new ArrayList<>();
    private String filename;

    public HighscoreStore(String filename) {
        this.filename = filename;
        String line;

            try{
                BufferedReader br = new BufferedReader(new FileReader(filename));
            while((line = br.readLine()) != null){
                String[] highscoreData = line.split(", ");
                this.highscores.add(new Highscore(highscoreData[0], highscoreData[1]));
            }
            br.close();
        }catch(IOException e){
            System.err.println("There was an error handling the file.");
        }
    }

    public ArrayList<Highscore> getHighscores(){
        return this.highscores;
    }

    //Overloaded method addHighScore START
    public void addHighscore(int index, String username, int score) {
        this.highscores.add(index, new Highscore(username,score));
    }

    public void addHighscore(String username, int score){
        this.highscores.add(new Highscore(username, score));
    }
    //Overloaded method addHighScore END

    public boolean isUserNewRecord(String username, int score){
        for(int record = 0; record < this.highscores.size(); record++){
            Highscore scoreNow = this.highscores.get(record);
            if(scoreNow.getUsername().equals(username) && scoreNow.getScore() < score) {
                System.out.println("User new highscore");
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public int findHighscorePosition(int startPoint, int endPoint, int score){
        if(this.highscores.size() < 1){
            return 0;
        }

        int currentIndex = (startPoint + endPoint) / 2;

        Highscore currentScore = this.highscores.get(currentIndex);

        if(startPoint == endPoint){
            System.out.println("Condition 1, index: " + currentIndex);
            return currentIndex;
        }

        if(currentScore.getScore() == score){
            System.out.println("Condidtion 2, index: " + currentIndex);
            return currentIndex;
        }


        if(currentScore.getScore() < score){
            return this.findHighscorePosition(startPoint, currentIndex - 1, score);
        }
        if(currentScore.getScore() > score){
            return this.findHighscorePosition(currentIndex + 1, endPoint, score);
        }
        return 0;
    }

    public void removeUser(String username){
        for(int record = 0; record < this.highscores.size(); record++){
            String user = this.highscores.get(record).getUsername().trim();

            if(user.equals(username.trim())){
                System.out.println("Remove");
                this.highscores.remove(record); }
        }
    }

    public void saveToFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename));
            for(int record = 0; record < this.highscores.size(); record++){
                Highscore scoreNow = this.highscores.get(record);
                bw.write(scoreNow.getUsername() + ", " + scoreNow.getScore());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            System.err.println("There was an error writing to the file.");
        }
    }
}

