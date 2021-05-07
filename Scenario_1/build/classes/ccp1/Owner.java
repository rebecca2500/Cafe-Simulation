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
public class Owner  implements Runnable {
String server="Owner";
Cafe cafe;
Waiter waiter;
public  boolean closingTime = false;
public  boolean closedTime = false;
public  boolean LastOrderTime = false;


    public Owner(Cafe cafe) {
    this.cafe = cafe;
    }

    public void run() {
    System.out.println("10.00 AM : Cafe opened..");
    try {
        Thread.sleep(1500);
    } catch (InterruptedException iex) {
        iex.printStackTrace();
    }
        
        System.out.println("Owner started to work");
        while (!closingTime) {
            this.cafe.order(server);
        }
        System.out.println("It is closing time");

        if (closingTime){
            try {
                
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        } 
    }


    public synchronized void setClosingTime() {
    this.closingTime=true;
   
    }
    
    public synchronized void setClosedTime() {
    this.closedTime=true;
     while(!cafe.listCustomer.isEmpty()){
        synchronized(cafe.listCustomer){
            System.out.println(cafe.listCustomer.size()+ " Customer Left...");
            this.cafe.listCustomer.clear();
        }
    }
         if(cafe.listCustomer.isEmpty()){
            closeCafe();
    }
    }
    
    public synchronized void setLastOrder() {
    LastOrderTime = true;
    System.out.println("Owner : Last Order");
    System.out.println("Owner : Cafe will be closing soon");
    }
    
    public synchronized void closeCafe() {
 
        if(cafe.listCustomer.isEmpty()){
            System.out.println("Owner: Time to close the shop");
            System.out.println("Today Sales");
            System.out.println("Total Customer Come: "+cafe.coming+" customers.");
            System.out.println("Total Customer Leave: "+cafe.left+" customers.");
            System.out.println("Total Customer Sit: "+cafe.total+" customers.");
            System.out.println("Total Customer Served: "+cafe.counter+" customers.");
            System.out.println("Number of coffee served :" +cafe.coffee);
            System.out.println("Number of juice served :" +cafe.juice);
            System.out.println("Owner leave the cafe");
            System.out.println("The cafe is closed");
        }
         
    }
    
}


