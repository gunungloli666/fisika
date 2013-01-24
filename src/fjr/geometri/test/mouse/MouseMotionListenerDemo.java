/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.geometri.test.mouse;

/**
 *
 * @author mamat
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class CustomListener implements MouseMotionListener {

    public void mouseMoved(MouseEvent me) {
        System.out.println("mouseMoved");
    }

    public void mouseDragged(MouseEvent me) {
        System.out.println("mouseDragged");
    }
}

public class MouseMotionListenerDemo {

    public static void main(String[] a) {
        JFrame frame = new JFrame("Popup JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();

        label.addMouseMotionListener(new CustomListener() {
        });

        frame.add(label);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}