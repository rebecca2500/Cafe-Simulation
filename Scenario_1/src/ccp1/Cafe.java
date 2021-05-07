/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ccp1;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


class Cafe {
int counter,coffee,juice,total,left,coming;
public boolean closingTime = false;
public boolean LastOrder = true;
int nchair = 10;
Cupboard cb;
List<Customer> listCustomer;

public Cafe() {
    listCustomer = new LinkedList<Customer>();
}

public void order(String server){
Customer customer;
synchronized (listCustomer) {
    while (listCustomer.size() == 0) {
        System.out.println(server + " is waiting for customer.");
        try {
            listCustomer.wait();
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }
    System.out.println(server + " found a customer in the queue.");
    customer = (Customer) ((LinkedList<?>) listCustomer).poll();
}


Cupboard cupboard = new Cupboard();
Random random=new Random(); 
System.out.println(server+" Taking order from Customer : " + customer.getName());
counter++;//calculate total customer served
int order=random.nextBoolean()? 0:1;

if(order==0){
    juice++;//calculate number of juice served
    System.out.println(customer.getName()+ " is ordering Juice");   
    cupboard.take_glass(server, customer, listCustomer);
    cupboard.take_juice(server, customer, listCustomer);
    cupboard.pour_juice(server, customer, listCustomer);
    cupboard.serve_juice(server, customer, listCustomer);
    }
else{
    coffee++;//calculate number of cappucino served
    System.out.println(customer.getName()+ " is ordering Cappucino");
    cupboard.take_cup(server, customer, listCustomer);
    cupboard.take_coffee(server, customer, listCustomer);
    cupboard.take_milk(server, customer, listCustomer);
    cupboard.mix_capp(server, customer, listCustomer);
    cupboard.put_back1(server, customer, listCustomer);
    cupboard.serve_capp(server, customer, listCustomer);

}
System.out.println("Customer " + customer.getName() + " exits...");

}



public void add(Customer customer) {

System.out.println("Customer : " + customer.getName() + " entering the shop at " + customer.getInTime());
coming++;
synchronized (listCustomer) {
    if (listCustomer.size() == nchair) {

    System.out.println("No chair available for customer " + customer.getName());
    System.out.println("Customer " + customer.getName() + " Go home");
    left++;
    //return;
    }
    if(listCustomer.size() < nchair){
    ((LinkedList<Customer>) listCustomer).offer(customer);
    System.out.println("Customer : " + customer.getName() + " got the chair.");
    total++;//calculate total customer that go in the cafe
    if (listCustomer.size() == 1) {
    listCustomer.notify();
        }

    }
}
}

public synchronized void setClosingTime() {
    closingTime = true;

    }

}


