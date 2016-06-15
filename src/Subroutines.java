/**
 * Created by connorkeevill12 on 15/06/2016.
 */
public class Subroutines {
    public static void main(String[] args) {
        int x = Helpers.getIntput("Enter x: ");
        int y = Helpers.getIntput("Enter y: ");
        String operation = Helpers.getInput("Enter your operation: ").toUpperCase();
        switch(operation) {
            case "ADDITION":
                System.out.println(addition(x, y));
                break;
            case "SUBTRACTION":
                System.out.println(subtraction(x, y));
                break;
            case "MULTIPLY":
                System.out.println(multiply(x, y));
                break;
            case "DIVIDE":
                System.out.println(divide(x, y));
                break;
        }

    }

    public static int addition(int x, int y){
        return x + y;
    }

    public static int subtraction(int x, int y){
        return x - y;
    }

    public static int multiply(int x, int y){
        return x * y;
    }

    public static float divide(int x, int y){
        return x / y;
    }

}
