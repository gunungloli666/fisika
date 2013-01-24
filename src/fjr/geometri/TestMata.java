/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.geometri;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mamat
 */
public class TestMata extends JPanel implements MouseMotionListener {

    int pointerX, pointerY;
    double angle;
    int x1 = 100;
    int y1 = 100;
    int diameter1 = 75;
    int x2, y2;
    int diameter2 = 40;
    final double pi = Math.PI;

    public TestMata() {
        this.addMouseMotionListener(this);

        angle = pi;
        x2 = x1 + (int) ((diameter1 - diameter2) * Math.cos(angle)) + (diameter1 - diameter2);
        y2 = y1 + (int) ((diameter1 - diameter2) * Math.sin(angle)) + (diameter1 - diameter2);
    }

    public void setAngle(double angle) {
        this.angle = angle;
        x2 = x1 + (int) ((diameter1 - diameter2) * Math.cos(angle)) + (diameter1 - diameter2);
        y2 = y1 + (int) ((diameter1 - diameter2) * Math.sin(angle)) + (diameter1 - diameter2);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(x1, y1, diameter1 * 2, diameter1 * 2);
        g2d.fillOval(x2, y2, diameter2 * 2, diameter2 * 2);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    double angletemp ;

    @Override
    public void mouseMoved(MouseEvent e) {
        this.pointerX = e.getX();
        this.pointerY = e.getY();
        int xtemp = x1 + diameter1;
        int ytemp = y1 + diameter1;
        System.out.println("Nilai x = " + pointerX + "  " + pointerY);
        try {
            angle = Math.atan((pointerY - ytemp) / (pointerX - xtemp));
            System.out.println("g eror "+angle);
           // angletemp = angle;
        } catch (ArithmeticException ex) {
          //  angle = angletemp;
          //  System.out.println("still eror"+ angle);
        }
        if((pointerY < ytemp) || (pointerX < xtemp)){
            angle = -angle;
        }
       
        this.setAngle(angle);
        repaint();
    //    System.out.println("angle = " + Math.toDegrees(angle) + " angletemp = " + Math.toDegrees(angletemp));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainframe = new JFrame("Geometri Fun");
                mainframe.setLayout(new BorderLayout());
                mainframe.setPreferredSize(new Dimension(700, 500));
                mainframe.setResizable(false);
                TestMata mata = new TestMata();
                mainframe.add(mata);
                mainframe.pack();
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setVisible(true);
            }
        });
    }
}
