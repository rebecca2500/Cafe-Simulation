
package ccp1;



import java.util.Date;

class Customer implements Runnable
{
    String name;
    Date inTime;
    Cafe cafe;

   
    public Customer(Cafe cafe)
    {
        this.cafe = cafe;
    }

 
    public String getName() {
        return name;
    }
 
    public Date getInTime() {
        return inTime;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
 
    public void run()
    {
       goinside();
        
    }
    private synchronized void goinside()
    {
        cafe.add(this);
    }
    
}