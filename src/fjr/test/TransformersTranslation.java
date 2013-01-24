/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.test;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class TransformersTranslation
        extends Transformers {

    public static void main(String[] args) {
        Transformers t = new TransformersTranslation();
        Frame f = t.getFrame();
        f.setVisible(true);
    }

    @Override
    public AffineTransform getTransform() {
        return AffineTransform.getTranslateInstance(150, 0);
    }
}
