package CK.Assignment1;

import CK.Helpers;

/**
 * Created by Connor on 16/06/2016.
 */
public class FactorialAssignment1 {
    public static void main(String[] args) {
        int userInput = Helpers.getIntput("Enter the number to calculate the factorial of: ");
        int factorial = calculateFactorial(userInput);
        System.out.println(factorial);
    }

    public static int calculateFactorial(int number){
        if(number == 1){
            return number;
        }else{
            return number * calculateFactorial(number - 1);
        }
    }
}
