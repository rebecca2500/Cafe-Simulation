/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ccp1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author rebeccadamanik
*/
public class Waiter  implements Runnable {
String server="Waiter";
Cafe cafe;
CCP1 ccp;
Owner owner;
public boolean closingTime = false;
public boolean LastOrder = false;
public boolean waiterLeave = false;


    public Waiter(Cafe cafe) {
        this.cafe = cafe;
    }


    public void run() {
        System.out.println("Waiter get started to work");  
        try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Waiter.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        while (!LastOrder) {
            this.cafe.order(server);
            
}
        if (closingTime){
           
            try {
                 System.out.println("Waiter is leaving");
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Waiter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public synchronized void setClosingTime() {
        closingTime=true;
        try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Waiter.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public synchronized void setLastOrder() {
        LastOrder=true;
    }
}






