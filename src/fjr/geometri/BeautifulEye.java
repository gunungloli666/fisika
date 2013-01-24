/**
 * Copyright 2012, Moh. Fajar
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>
 */
package fjr.geometri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BeautifulEye extends JPanel implements MouseMotionListener {

    int xcenter;
    int ycenter;
    final int horsize = 700;
    final int versize = 580;
    RandomEllipse randomEllips;

    public BeautifulEye() {
        randomEllips = new RandomEllipse(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Point p1, p2;
        int mayor, minor, radius;
        if (randomEllips.getEyeBall().length > 0) {
            for (EyeBall ball : randomEllips.getEyeBall()) {
                p1 = ball.getEllipsPosition();
                mayor = ball.getMayorAxis();
                minor = ball.getMinorAxis();
                radius = ball.getCircleRadius();
                p2 = ball.getCirclePosition();
                System.out.println(p2.x + " dalam beautiful eye " + p2.y);
                g2d.setColor(Color.red);
                g2d.drawOval(p1.x, p1.y, mayor * 2, minor * 2);
                g2d.setColor(Color.green);
                g2d.fillOval(p2.x, p2.y, radius * 2, radius * 2);

            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainframe = new JFrame("Mata Bola");
                mainframe.setLayout(new BorderLayout());
                BeautifulEye eye = new BeautifulEye();
                mainframe.setPreferredSize(new Dimension(eye.horsize, eye.versize));
                mainframe.add(eye);
                mainframe.setResizable(false);
                mainframe.pack();
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setVisible(true);
            }
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xcenter = e.getX();
        ycenter = e.getY();
        int it = 0;
        for (EyeBall ball : randomEllips.getEyeBall()) {
            try {
                double angle;
                Point p = ball.getEllipsPosition();
                int m = ball.getMayorAxis();
                angle = Math.atan((ycenter - p.y + m)
                        / (xcenter - p.x + m));
                ball.setCircle(angle, ball.getCircleRadius());
            } catch (ArithmeticException exc) {
            }
        }
        this.repaint();
    }
}

class EyeBall {

    double circleangle;
    int sumbuMayor;
    int sumbuMinor;
    int xcircle;
    int ycircle;
    int circleRadius;
    int xellips;
    int yellips;
    int circleDiamter;
    int ellipseWidth;
    int ellipseHeight;

    public EyeBall(Point pellips, int sumbumayor, int sumbuminor) {
        this.sumbuMayor = sumbumayor;
        this.sumbuMinor = sumbuminor;
        this.xellips = pellips.x+sumbumayor;
        this.yellips = pellips.y+sumbuminor;
    }

    public Point getEllipsPosition() {
        return new Point(xellips, yellips);
    }

    public int getMayorAxis() {
        return this.sumbuMayor;
    }

    public int getCircleRadius() {
        return circleRadius;
    }

    public int getMinorAxis() {
        return this.sumbuMinor;
    }

    public void setCircle(double angle, int radius) {
        this.circleangle = -angle;
        int r = sumbuMayor - circleRadius;
        xcircle =  xellips + r +(int)( r * Math.cos(angle));
        ycircle =  yellips + r + (int)(r * Math.sin(angle));
    //    System.out.println(xcircle + "  lingkaran   "+ycircle);
        this.circleRadius = radius;
    }

    public Point getCirclePosition() {
        return new Point(xcircle, ycircle);
    }
}

//==========================================================================================
class RandomEllipse {

    EyeBall[] eyeball;
    int numberellipse;
    BeautifulEye beautifuleye;
    int maxWidth;
    int maxHeight;
    final int[] listparameter = {100, 110, 120, 130};
    Random random = new Random();
    Random randomPosisiX = new Random();
    Random randomPosisiY = new Random();

    public RandomEllipse(BeautifulEye be) {
        this(be, 0);
    }

    public RandomEllipse(BeautifulEye be, int numberellipse) {
        this.beautifuleye = be;
        this.maxWidth = beautifuleye.horsize;
        this.maxHeight = beautifuleye.versize;
        this.numberellipse = numberellipse;


        if (numberellipse == 0) {
            int gridx = (int) (maxWidth / 160);
            int gridy = (int) (maxHeight / 150);
            int[] koorx = new int[gridx];
            int[] koory = new int[gridy];
            int itemp = 0;
            int jtemp = 0;
            for (int i = 1; i < koorx.length; i++) {
                itemp += 150;
                koorx[i] = itemp;
            }
            for (int j = 1; j < koory.length; j++) {
                jtemp += 160;
                koory[j] = jtemp;
            }
            ArrayList<Point> list = new ArrayList<Point>();
            Random randList = new Random();
            for (int i = 0; i < koorx.length; i++) {
                for (int j = 0; j < koory.length; j++) {
                    int c = randList.nextInt(2);
                    if (c != 0) {
                        list.add(new Point(koorx[i], koory[j]));
                    }

                }
            }

            System.out.println(list.size());
            eyeball = new EyeBall[list.size()];
            for (int i = 0; i < eyeball.length; i++) {
                int h = random.nextInt(listparameter.length);
                int major = (int) (listparameter[h] / 2) - 5;
                int minor = (int) (listparameter[h] / 2) - 5;
                int radius = minor - 10;

                eyeball[i] = new EyeBall(list.get(i), major, minor);
                eyeball[i].setCircle(Math.PI, radius);
                System.out.println(eyeball[i].getCirclePosition().x+" "
                        + "  dalam randomball  "+eyeball[i].getCirclePosition().y );
                
            //  beautifuleye.repaint();
            }

        }
    }

    public EyeBall[] getEyeBall() {
        return this.eyeball;
    }
}
