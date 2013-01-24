/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.dynamic.main;


/**
 *
 * @author mamat
 */
public class BangunDatar {
    
    private int panjang , lebar;
    private int diameter;
    
    public BangunDatar(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }
    
    public BangunDatar(int diameter){
        this.diameter = diameter;
    }
    
    public void setSize(int panjang,int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }
    
    public void setSize(int diameter){
        this.diameter = diameter;
    }
    
    public void setSize(Dimension d){
        this.panjang  = d.panjang;
        this.lebar = d.lebar;
    }

}
