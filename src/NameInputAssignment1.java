/**
 * Created by connorkeevill12 on 17/06/2016.
 */
public class NameInputAssignment1 {
    public void main(String[] args) {
        String currentName = null;

        while (true) {
            currentName = Helpers.getInput("Enter a name, or enter 'Quit' to end the progam: ");

            guardAgainstQuitValue(currentName);

            System.out.println("Hello " + capitaliseFirstLetter(currentName));
        }
    }

    private static void guardAgainstQuitValue(String givenValue){
        if(givenValue.equalsIgnoreCase("QUIT")){
            System.exit(0);
        }
    }

    public static String capitaliseFirstLetter(String message) {
        message = message.toLowerCase();

        String firstLetter = message.substring(0, 1).toUpperCase();
        String restOfString = message.substring(1);

        return firstLetter + restOfString;
    }
}
