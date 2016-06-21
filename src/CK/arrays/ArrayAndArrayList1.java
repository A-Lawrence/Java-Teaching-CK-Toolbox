package CK.Arrays;

import java.util.ArrayList;

/**
 * Created by Connor on 19/06/2016.
 */
public class ArrayAndArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> names = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++){
            names.add(i, i);
        }
        System.out.println(names.size());
    }
}
