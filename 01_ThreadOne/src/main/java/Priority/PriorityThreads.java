package Priority;

public class PriorityThreads {

    public static void main (String[] args){
        Priority pr1 = new Priority("Thread 1");
        Priority pr2 = new Priority("Thread 2");

        pr1.thread.setPriority(1);
        pr2.thread.setPriority(10);

        pr1.thread.start();
        pr2.thread.start();

        try {
            pr1.thread.join();
            pr2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted main!");
        }

        System.out.println("Thread 1 count = " + pr1.count);
        System.out.println("Thread 2 count = " + pr2.count);
    }



}
