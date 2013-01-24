/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.test.thread;

/**
 *
 * @author mamat
 */
public class TwoThreadAlive extends Thread{
    
    public void printMsg(){
        Thread  t= Thread.currentThread();
        String name = t.getName();
        System.out.println("Name: "+ name);
    }
    
    public static void main(String[] args){
        
    }
}
