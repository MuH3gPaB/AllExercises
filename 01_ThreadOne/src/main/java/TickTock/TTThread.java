package TickTock;

public class TTThread implements Runnable{

    Thread thrd;
    private String type;
    private TickTock tickTock;

    public TTThread (String name, String type, TickTock tickTock){
        thrd = new Thread(this, name);
        this.type = type;
        this.tickTock = tickTock;
        thrd.start();
    }

    public void run() {
        if (this.type.equals("tick")){
            for (int i = 0; i < 5; i++) {
                tickTock.tick(false);
            }
            tickTock.tick(true);
        }
        else{
            for (int i = 0; i < 5; i++) {
                tickTock.tock(false);
            }
            tickTock.tock(true);
        }
    }
}
