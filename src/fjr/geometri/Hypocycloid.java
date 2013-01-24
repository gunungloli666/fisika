  /**
   * Copyright 2012, Moh. Fajar
   * 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
    */


package fjr.geometri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mamat
 */
public class Hypocycloid extends JPanel {

    //posisi dan ukuran persegi utama
    int rectX = 10;
    int rectY = 10;
    int rectH = 420;
    int rectW = 600;
    
    //posisi dan diameter lingkaran  besar
    int radius1 = 270;
//    int x = rectW+rectX-radius1;
    int x = rectX;
    int y = rectH+rectY - radius1;
   
    //posisi dan diameter lingkaran kecil
    int radius2 = 100;
    int x1 = x + (radius1 - radius2) / 2, 
            y1 = y + (radius1 - radius2);
    
    //sudut putaran lingkaran kecil
    double omega = 0; 
    
    //posisi dan titik Hypocycloid
    int x2= x1+radius2;
    int y2 = x1 + radius2;
   
    public Hypocycloid() {
        this.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        drawMainRect(g);
        drawBigCircle(g);
        drawSmallCircle(g);
        drawPoint(g);
    }
   
    public void drawBigCircle(Graphics g) {
        g.setColor(Color.red);
        g.drawOval(x, y, radius1, radius1);
    }
    
    public void drawSmallCircle(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval(x1, y1, radius2, radius2);

    }

    public void drawMainRect(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(rectX, rectY, rectW, rectH);
    }
    
    public void drawPoint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.fillOval(x2, y2, 10, 10);
        
    }
  
    public void start() {
        LingkaranDalam lingkarandalam = new LingkaranDalam(this);
        Thread t1 = new Thread(lingkarandalam);
        t1.start();
        LingkaranLuar lingkarangluar = new LingkaranLuar(this);
        Thread t2 = new Thread(lingkarangluar);
        t2.start();
              
    }
    
    private class LingkaranLuar implements Runnable {
        
        Hypocycloid hypo;
        
        public LingkaranLuar(Hypocycloid hypo){
            this.hypo = hypo;
        }
        
        @Override
        public void run() {

            while (true) {
                for (int i = 0; i < 110; i++) {//sorong ke kiri
                    x += (int) ((rectW + rectX - radius1) / 100);
                    synchronized (hypo) {
                        hypo.repaint();
                    }
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        System.out.println("thread error 2");
                    }
                }

                for (int i = 0; i < 50; i++) { //sorong ke atas
                    y -= (int) ((rectH + rectY - radius1) / 50);
                    synchronized (hypo) {
                        hypo.repaint();
                    }
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        System.out.println("thread error 2");
                    }
                }

                for (int i = 0; i <110; i++) { //sorong ke kanan
                    x -= (int) ((rectW + rectX - radius1) / 100);
                    synchronized (hypo) {
                        hypo.repaint();
                    }
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        System.out.println("thread error 2");
                    }
                }

                for (int i = 0; i < 50; i++) { //sorong ke bawah
                    y += (int) ((rectH + rectY - radius1) / 50);
                    synchronized (hypo) {
                        hypo.repaint();
                    }
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        System.out.println("thread error 2");
                    }
                }
            }

        }
    }

    private class LingkaranDalam implements Runnable {
        
        Hypocycloid hypo;
        
        public LingkaranDalam(Hypocycloid hypo){
            this.hypo = hypo;
        }

        @Override
        public void run() {
            boolean run = true;
            int a = radius1/2;
            int b = radius2/2;
            int rtemp = a - b;
            while (run) {
                for (int i = 0; i < 200; i++) {
                    omega -= Math.PI / 200;
                    x1 = (int) (x +
                            rtemp + //untuk koreksi grafis
                            rtemp //nilai jari-jari lingkaran besar kurang jari-jari lingkaran kecil
                            * Math.cos(omega));
                    y1 = (int) (y + rtemp + rtemp * Math.sin(omega));
                       
                    x2 = (int)(x1+(b-5)+b*Math.cos((a-b)*omega/b));
                    y2 = (int)(y1+(b-5)-b*Math.sin((a-b)*omega/b) );
                    
                    synchronized(hypo){
                        hypo.repaint();
                    }
                    try {
                        Thread.sleep(5);
                    } catch (Exception e) {
                        System.out.println("thread error 1");
                    }
                }

            }
        }
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainframe = new JFrame("Geometri Fun");
                mainframe.setLayout(new BorderLayout());
                mainframe.setPreferredSize(new Dimension(700, 500));
                Hypocycloid hypo = new Hypocycloid();
                mainframe.add(hypo);
                mainframe.setResizable(false);
                mainframe.pack();
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setVisible(true);
            }
        });
    }
}
