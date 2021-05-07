
package ccp1;



import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Clock extends Thread {
CustomerGenerator cg;
Owner owner;
Waiter waiter;
Cafe cafe;
int timer=28000;


    Clock(CustomerGenerator cg, Owner owner, Waiter waiter){
        this.cg = cg;
        this.owner = owner;
        this.waiter=waiter;
    }

    public  void run(){
    try{
        Thread.sleep(this.timer);
    }catch(Exception e){
        e.printStackTrace();
    }
    synchronized(this){
    notifyLastOrder();
    notifyClosing();
    }
    }
    public synchronized void notifyLastOrder(){
    this.cg.setLastOrder();
    this.waiter.setLastOrder();
    this.owner.setLastOrder();
    }

    public synchronized void notifyClosing(){    
    try {
        Thread.sleep(2000);
    } catch (InterruptedException ex) {
        Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
    }
    synchronized (this){
        
        this.cg.setClosingTime();
        System.out.println("21.00 : Closing Time");
        this.owner.setClosingTime();
        this.waiter.setClosingTime();
        this.owner.setClosedTime();
        
        }

    }
}
