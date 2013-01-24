/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.geometri.test;

/**
 *
 * @author mamat
 */
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class randomUniqueNumberGenerator {

    public static final int SET_SIZE_REQUIRED = 10;
    public static final int NUMBER_RANGE = 100;

    public static void main(String[] args) {
        Random random = new Random();

        Set set = new HashSet<Integer>(SET_SIZE_REQUIRED);

        while (set.size() < SET_SIZE_REQUIRED) {
            while (set.add(random.nextInt(NUMBER_RANGE)) != true)
               ;
        }
        assert set.size() == SET_SIZE_REQUIRED;
        System.out.println(set);
    }
}