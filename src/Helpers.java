import java.util.Scanner;

/**
 * Created by connorkeevill12 on 13/06/2016.
 */
public class Helpers {
    public static String getInput(String message){
        Scanner myScanner = new Scanner(System.in);

        System.out.print(message);

        return myScanner.nextLine().trim();
    }
    public static int getIntput(String message){
        String r = getInput(message);

        return Integer.parseInt(r);
    }
}

