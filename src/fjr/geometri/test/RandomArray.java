/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.geometri.test;

import java.util.Random;

/**
 *
 * @author mamat
 */
public class RandomArray {

    public static void main(String[] args) {
        Random random = new Random();
        int test[][] = new int[10][10];
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                test[i][j] = random.nextInt(2);
            }
        }
        print(test);
    }

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}
//Hasil eksekusi
//0   1   0   1   1   0   0   1   0   0   
//0   0   1   0   1   0   0   1   0   0   
//0   1   0   1   0   0   0   1   0   1   
//1   0   0   0   0   0   1   0   0   0   
//1   1   1   1   1   0   1   0   1   1   
//1   0   1   0   0   0   1   0   1   1   
//1   0   0   0   1   0   0   1   0   0   
//0   0   1   0   1   0   0   1   1   1   
//0   0   1   0   0   1   0   0   0   0   
//0   0   0   1   0   1   0   1   0   0   
//================