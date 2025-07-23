package unit11.moonbase.part2;

public class Rover implements Runnable {
    //state
    private String name;
    private int seconds;
    private Base from;
    private Base to;
    private Object lock;

    //constructor
    public Rover(String name, int seconds, Base from, Base to, Object lock){
        this.name=name;
        this.seconds=seconds;
        this.from=from;
        this.to=to;
        this.lock=lock;
    }

    @Override
    public void run(){
        //prints the starting message
        System.out.println(name+"("+seconds+")"+" is ready to start traversal at the "+from+" end of the tunnel.");
        synchronized(lock){
            Control control = new Control(lock);
            control.accessTunnel();
            for(int i=0;i<seconds;i++){
                if(i==0){
                    //when it starts it prints this and prints the else for every other time
                    System.out.println(name+"("+seconds+")"+" is starting traversal.");
                }else{
                    System.out.println("\t"+name+"("+seconds+"): "+i+" seconds.");
                }
        }
        control.leaveTunnel();
        //prints when finished
        System.out.println(name+"("+seconds+") has completed traversal and has reached the "+to+" end of the tunnel.");
    }

    }

    public static void main(String[] args) {
        Object lock = new Object();
        //creates rovers and their respective threads
        Rover rov = new Rover("Rov", 10, Base.Hyperion, Base.Odyssey,lock);
        Thread thread1 = new Thread(rov);
        Rover rovJr = new Rover("RovJr", 5, Base.Hyperion, Base.Odyssey,lock);
        Thread thread2 = new Thread(rovJr);
        Rover rusty = new Rover("Rusty", 15, Base.Odyssey, Base.Hyperion,lock);
        Thread thread3 = new Thread(rusty);
        Rover cyberRover = new Rover("David", 2, Base.Odyssey, Base.Hyperion,lock);
        Thread thread4 = new Thread(cyberRover);

        //starts the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
