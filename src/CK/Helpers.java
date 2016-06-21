package CK;

import java.util.Scanner;
import java.util.jar.Pack200;

/**
 * Created by connorkeevill12 on 13/06/2016.
 */
public class Helpers {
    public static String getInput(String message) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print(message);

        return myScanner.nextLine().trim();
    }

    public static int getIntput(String message) {
        String r = getInput(message);

        return Integer.parseInt(r);
    }

    public static int getIntRange(int lowest, int highest, String prompt) {
        int number;

        do {
            number = getIntput(prompt);
        } while (number < lowest || number > highest);

        return number;
    }

    public static double getDouble(String prompt) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print(prompt);

        return myScanner.nextDouble();
    }

    public static String getConformation(String prompt, String expectedOne, String expectedTwo) {
        String confirm;
        do {
            confirm = getInput(prompt + "(" + expectedOne + "/" + expectedTwo + ")");
        } while (!confirm.equalsIgnoreCase(expectedOne) && !confirm.equalsIgnoreCase(expectedTwo));
        return confirm;
    }
}

