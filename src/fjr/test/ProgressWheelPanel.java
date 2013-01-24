/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.test;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mamat
 */
public class ProgressWheelPanel extends JPanel {

    private double angleInDegrees = 1;
    private Timer rotatingTimer;

    public ProgressWheelPanel() {
        rotatingTimer = new Timer(100, new ActionListener() {
            //            @Override
            @Override
            public void actionPerformed(ActionEvent e) {
                angleInDegrees = angleInDegrees + 1;
                if (angleInDegrees == 360) {
                    angleInDegrees = 0;
                }
                repaint();
            }
        });
        rotatingTimer.setRepeats(false);
        rotatingTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        rotatingTimer.stop();

        g2d.clearRect(0, 0, getWidth(), getHeight());
        g2d.setBackground(Color.white);
        g2d.setColor(Color.black);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        g2d.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2d.rotate(angleInDegrees * Math.PI / 180.0, getWidth() / 2, getHeight() / 2);
        g2d.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2 + 100, getHeight() / 2);
        //**************************************************************************************
        AffineTransform transformer = new AffineTransform();
        transformer.translate(5, 5);
        transformer.scale(2, 2);
        g2d.getTransform().concatenate(transformer);
        //***************************************************************************************
        g2d.dispose();
        rotatingTimer.start();
    }

    public void start() {
        rotatingTimer.start();
    }

    public void stop() {
        rotatingTimer.stop();
    }

    public static void main(String[] args) {
        final ProgressWheelPanel demo = new ProgressWheelPanel();
        JButton btnStrat = new JButton("Start"), btnStop = new JButton("Stop");
        btnStrat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demo.setVisible(true);
                demo.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                demo.stop();
                demo.setVisible(false);
            }
        });
        JFrame frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(demo, BorderLayout.CENTER);
        cp.add(btnStrat, BorderLayout.NORTH);
        cp.add(btnStop, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(500, 500);
        frame.setVisible(true);
    }
}
