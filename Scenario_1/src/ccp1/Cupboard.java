/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ccp1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author rebeccadamanik
*/

public class Cupboard {
long duration = 0;

    public void take_cup( String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server+" is taking a cup for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void take_coffee (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server+" is taking coffee for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void take_milk(String server, Customer cst, List listCustomer){    
        synchronized (listCustomer){
            System.out.println(server+" is taking milk for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void mix_capp (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server+ " mix coffee and milk for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
    }
    public void put_back1 (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server + " put back the ingredients.");
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void serve_capp (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server + " Serve Cappucino for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }

    public void take_glass(String server, Customer cst,List listCustomer){
        synchronized (listCustomer){
            System.out.println(server+" is taking a glass for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void take_juice (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server+" is taking juice tap for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void pour_juice (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server+ " pour juice into the glass for "+cst.getName());
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void put_back2 (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server + " put back the juice tap.");
            duration = (long) (Math.random() * 500);
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void serve_juice (String server, Customer cst, List listCustomer){
        synchronized (listCustomer){
            System.out.println(server + " Serve juice for "+cst.getName());
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Cupboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}


