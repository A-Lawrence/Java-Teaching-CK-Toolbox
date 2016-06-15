/**
 * Created by connorkeevill12 on 15/06/2016.
 */
public class SwitchCase {
    public static void main(String[] args) {
        String month = Helpers.getInput("What month is it? ");
        month = month.toUpperCase();

        int days = 0;
        switch(month) {
            case "JANUARY":
            case "MARCH":
            case "MAY":
            case "JULY":
            case "AUGUST":
            case "OCTOBER":
            case "DECEMBER":
                days = 31;
                break;
            case "APRIL":
            case "JUNE":
            case "SEPTEMBER":
            case "NOVEMBER":
                days = 30;
                break;
            case "FEBRUARY":
                days = 28;
                break;
            default:
                System.err.println("Not a valid month");
                System.exit(1);
        }

        System.out.println(month.toLowerCase() + " has " + days + " days");
    }
}
