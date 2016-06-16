/**
 * Created by Connor on 16/06/2016.
 */
public class FactorPairsAssignment1 {
    public static void main(String[] args) {
        int userInput = Helpers.getIntput("Enter a number to find it's factors: ");
        calculateFactorsOf(userInput);
    }
    public static void calculateFactorsOf(int number){
        for(int i = 1; i <= number; i++){ //Starting i at 1 instead of 0 so an error doesn't arise when trying to divide by 0.
            if(number % i == 0){
                System.out.println(i + ", " + (number / i));
            }
        }
    }
}
