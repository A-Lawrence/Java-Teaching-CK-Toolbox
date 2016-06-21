package CK.Arrays;

import static jdk.nashorn.internal.objects.NativeArray.length;

/**
 * Created by Connor on 19/06/2016.
 */
public class ArrayAndArrayList3 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for(int i = 0; i < 8; i++){
            numbers[i] = i;
        }
        for(int number = 0; number < numbers.length; number++){
            System.out.println(numbers[number]);
        }
    }
}
