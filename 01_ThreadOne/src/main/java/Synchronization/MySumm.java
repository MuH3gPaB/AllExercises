package Synchronization;


public class MySumm {

    private int summ;

    public synchronized int getSumm(int[] values){
        summ = 0;

        for (int i = 0; i < values.length; i++) {
            summ += values[i];
            System.out.println(Thread.currentThread().getName() + "summ = " + summ);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "interrupted");
        }
        return summ;
    }
}
