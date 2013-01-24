/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.geometri.test;

public class Shuffle {

    public static void main(String[] args) {
        int a[] = {1,3,5,7,9,11,13,15,17,19};
        int N = a.length;

        // shuffle
        for (int i = 0; i < N; i++) {
            // int from remainder of deck
            int r = i + (int) (Math.random() * (N - i));
            int  swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }

        // print permutation
        for (int i = 0; i < N; i++) {
            System.out.println(a[i]);
        }
    }
}