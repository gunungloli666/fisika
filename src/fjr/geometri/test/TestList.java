/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.geometri.test;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author mamat
 */
public class TestList {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        System.out.println(list.size());

        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        System.out.println(list.size());
    }
}
