/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.geometri.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mamat
 */
public class Test_shufle {

    public static void main(String[] args) {
//        // Create a list
//        List list = new ArrayList();
//
//// Add elements to list
//
//// Shuffle the elements in the list
//        Collections.shuffle(list);
//
//// Create an array
//        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10};
//
//// Shuffle the elements in the array
//        Collections.shuffle(Arrays.asList(array));
//        
//        for(int i=0; i< array.length; i++){
//            System.out.println(array[i]);
//        }



        Random rgen = new Random();  // Random number generator
        int[] cards = new int[52];

//--- Initialize the array to the ints 0-51
        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }

//--- Shuffle by exchanging each element randomly
        for (int i = 0; i < cards.length; i++) {
            int randomPosition = rgen.nextInt(cards.length);
            int temp = cards[i];
            cards[i] = cards[randomPosition];
            cards[randomPosition] = temp;
        }
        
        for(int i=0; i< cards.length ;i++){
            System.out.println(cards[i]);
        }
    }
}
