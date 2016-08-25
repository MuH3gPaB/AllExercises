package TickTock;


public class TickTock {

    private String state = "none";

    public synchronized void tick(boolean last){
        state = "tick";
        System.out.println(state);
        notify();
        if(last) return;

        while (state.equals("tick")){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

    public synchronized void tock(boolean last){
        state = "tock";
        System.out.println(state);
        notify();
        if(last) return;

        while (state.equals("tock")){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

}
