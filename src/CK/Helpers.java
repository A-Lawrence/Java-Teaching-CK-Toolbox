package CK;

import java.util.ArrayList;
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

//    private static int binarySearch2DArrayList(int startPoint, int endPoint, ArrayList data, int target) {
//
//        int currentIndex = (startPoint + endPoint) / 2;
//        String[] lineItems = (String[]) data.get(currentIndex);
//        int item = getScoreFromFile(lineItems);
//
//        if (item == target || isScoreNewRecord(target, currentIndex, data)){
//            return currentIndex;
//        }else if(currentIndex == data.size() - 1 && target < item){
//            return currentIndex + 1;
//        }
//
//        if (item < target) {
//            currentIndex = getIndexOfHighScore(startPoint, currentIndex, data, target);
//            return (currentIndex);
//        } else if (item > target) {
//            currentIndex = getIndexOfHighScore(currentIndex, endPoint, data, target);
//            return (currentIndex);
//        }
//        return 0;
//    }
}

