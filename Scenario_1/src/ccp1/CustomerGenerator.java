
package ccp1;


import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class CustomerGenerator implements Runnable {

    Cafe cafe;
    public volatile boolean closingTime = false;
     public volatile boolean LastOrder = false;


    public CustomerGenerator(Cafe cafe) {
        this.cafe = cafe;
    }

    public void run() {
        while (!closingTime) {
            
            try {
                Thread.sleep(450);
            } catch (InterruptedException ex) {
                Logger.getLogger(CustomerGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
   
            Customer customer = new Customer(cafe);
            customer.setInTime(new Date());
            Thread thcustomer = new Thread(customer);
            customer.setName("Customer " + thcustomer.getId());
            thcustomer.start();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        

            
        }
        if (closingTime) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            
        }
    }
    public synchronized void setLastOrder() {
        closingTime = true;
    }
    public synchronized void setClosingTime() {
        closingTime = true;  
    }
}
