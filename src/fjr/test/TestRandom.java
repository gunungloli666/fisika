/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.test;

import java.util.Random;

/**
 *
 * @author mamat
 */
public class TestRandom {

    Random random = new Random();
    
    public TestRandom() {
        for(int i=0; i< 20; i++){
            System.out.println(random.nextInt(10));
        }
    }
    
    public static void main(String[] args){
        new TestRandom();
    }
    
}
