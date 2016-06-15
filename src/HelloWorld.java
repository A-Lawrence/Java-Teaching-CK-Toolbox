import java.util.Scanner;

/**
 * Created by connorkeevill12 on 13/06/2016.
 */
public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello World");

        String gender = Helpers.getInput("Enter your gender please: ");
        System.out.println("You are " + gender + ".");

        if(gender.equalsIgnoreCase("male")) {
            System.out.println("You are male");
        } else if(gender.equalsIgnoreCase("female")){
            System.out.println("You are female");
        } else {
            System.out.println("You are unknown");
        }
    }
}
