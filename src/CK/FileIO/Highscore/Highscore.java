package CK.FileIO.Highscore;

/**
 * Created by connorkeevill12 on 08/07/2016.
 */
public class Highscore {
    private String username;
    private int score;

    public Highscore(String username, int score){
        this.username = username;
        this.score = score;
    }

    public Highscore(String username, String score){
        this(username, Integer.parseInt(score));
    }

    public String getUsername(){
        return this.username;
    }

    public int getScore(){
        return this.score;
    }

    public void setUsername(String usernamme){
        this.username = usernamme;
    }

    public void setScore(int score){
        this.score = score;
    }
}
