/**
 * Created by Connor on 19/06/2016.
 */
public class ArrayAndArrayList4 {
    public static void main(String[] args) {
        String[] phrases = new String[10];
        for(int i = 0; i < phrases.length; i++){
            phrases[i] = Helpers.getInput("Enter a string: ");
        }
        System.out.println(phrases.length);
        for(int item = 0; item < phrases.length; item++){
            System.out.println(phrases[item]);
        }
    }
}
