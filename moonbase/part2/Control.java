package unit11.moonbase.part2;


public class Control {
    //instance variable lock
    Object lock;

    //constructor
    public Control(Object lock){
        this.lock=lock;
    }
    
    //allows access to the tunnel
    public void accessTunnel(){
        lock.notifyAll();
        synchronized(lock){
            try{lock.wait();
            }catch (InterruptedException e){};
        }
        
    }

    //notifies the control system when a rover has finished
    public void leaveTunnel(){
        lock.notify();
    }
}
