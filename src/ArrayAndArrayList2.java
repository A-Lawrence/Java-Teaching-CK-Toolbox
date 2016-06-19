import java.util.ArrayList;

/**
 * Created by Connor on 19/06/2016.
 */
public class ArrayAndArrayList2 {
    public static void main(String[] args) {
        ArrayList<String> inputStrings = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            inputStrings.add(Helpers.getInput("Enter string #" + (i+1) + ": "));
        }
        String compareString = Helpers.getInput("Enter another string: ");
        System.out.println(inputStrings.contains(compareString));
    }
}
