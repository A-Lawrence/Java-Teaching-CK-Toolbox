package CK.Unpackagable;

import CK.Helpers;

/**
 * Created by Connor on 19/06/2016.
 */
public class DataTypesPracticeTask5 {
    public static void main(String[] args) {
        String firstName;
        String secondName;
        String email;
        int day;
        int month;
        int year;
        double gamingYears;

        do {
            firstName = Helpers.getInput("Enter your first name: ");
            secondName = Helpers.getInput("And your second name: ");
            email = Helpers.getInput("Your email address: ");
            day = Helpers.getIntRange(1, 31, "Enter the day you were born on: ");
            month = Helpers.getIntRange(1, 12, "Enter the the month you were born in: ");
            year = Helpers.getIntRange(-1000, 2010, "Enter the year you were born in: ");
            gamingYears = Helpers.getDouble("How many years of gaming have you had?");
        } while (validateAccount(firstName, secondName, email, day, month, year, gamingYears));
        System.out.println("Your account has been created.");
    }


    private static boolean validateAccount(String firstName, String secondName, String email,
                                           int day, int month, int year,
                                           double gamingYears){
        System.out.println("Your information is as follows: ");
        System.out.println("    First name: " + firstName);
        System.out.println("    Second name: " + secondName);
        System.out.println("    Email: " + email);
        System.out.println("    DOB: " + Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year));
        System.out.println("    Gaming experience: " + Double.toString(gamingYears) + " year(s)");
        String confirm = Helpers.getConformation("Are you happy with this information?", "Y", "N");
        if(confirm.equalsIgnoreCase("N")){
            System.out.println("Your sign-up has been cancelled and will restart.");
            return true;
        }else{
            return false;
        }
    }
}

