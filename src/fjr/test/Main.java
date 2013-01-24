/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fjr.test;

/**
 *
 * @author mamat
 */
import java.util.Iterator;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws Exception {
        Vector data = new Vector();
        new Producer(data).start();
        new Consumer(data).start();
    }
}

class Producer extends Thread {

    Vector data;

    Producer(Vector data) {
        super("Producer");
        this.data = data;
    }

    public void run() {
        while (true) {
            data.addElement(new Object());
            if (data.size() > 1000) {
                data.removeAllElements();
            }
        }
    }
}

class Consumer extends Thread {

    Vector data;

    Consumer(Vector data) {
        super("Consumer");
        this.data = data;
    }

    public void run() {
        while (true) {
            synchronized (data) {
                Iterator it = data.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
