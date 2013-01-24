/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.dynamic.main;

/**
 *
 * @author mamat
 */
public class Dimension {
    
    int panjang, lebar;
    
    public  Dimension(int panjang, int lebar){
        this.panjang  = panjang; 
        this.lebar = lebar;
    }
    
    public  Dimension getDimension(){
        return new Dimension(panjang, lebar);
    }
}
