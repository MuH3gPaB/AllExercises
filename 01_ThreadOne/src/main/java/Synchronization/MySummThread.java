package Synchronization;

public class MySummThread implements Runnable{

    Thread thread;
    private static MySumm calc = new MySumm();
    public int summ = 0;
    int[] values;

    public MySummThread(String name, int[] values){
        thread = new Thread(this, name);
        this.values = values;
        thread.start();
    }

    public void run() {
        summ = calc.getSumm(values);
        System.out.println(thread.getName() + " Ended --> summ = " + summ);
    }
}
