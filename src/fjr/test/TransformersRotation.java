/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.test;

/**
 *
 * @author mamat
 */
import java.awt.*;
import java.awt.geom.AffineTransform;

public class TransformersRotation
        extends Transformers {

    public static void main(String[] args) {
        Transformers t = new TransformersRotation();
        Frame f = t.getFrame();
        f.setVisible(true);
    }

    @Override
    public AffineTransform getTransform() {
        return AffineTransform.getRotateInstance(-Math.PI / 6);
    }
}
