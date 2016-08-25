package TickTock;

public class TTMain {
    public static void main(String[] args){
        TickTock tickTock = new TickTock();
        TTThread tt1 = new TTThread("tt1", "tick", tickTock);
        TTThread tt2 = new TTThread("tt2", "tock", tickTock);
        try{
            tt1.thrd.join();
            tt2.thrd.join();
        }catch (InterruptedException ex){
            System.out.println("Interrupted!");
        }
        System.out.println("Done!");
    }
}
