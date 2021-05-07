    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp1;

import java.util.List;

/**
 *
 * @author rebeccadamanik
 */
public class CCP1 {
  /**
     * @param args the command line arguments
     */
 
     List<Customer> listCustomer;
    public static void main(String[] args) {
        
         Cafe cafe = new Cafe();

        Owner owner = new Owner(cafe);
        Waiter waiter = new Waiter(cafe);
        CustomerGenerator cg = new CustomerGenerator(cafe);

        Thread thowner = new Thread(owner,"owner");
        Thread thwaiter = new Thread(waiter,"waiter");
        Thread thcg = new Thread(cg,"cg");
        
        thcg.start();
        thowner.start();
        thwaiter.start();
        
        Clock clock = new Clock(cg,owner,waiter);
        clock.start();
    }
    
}
