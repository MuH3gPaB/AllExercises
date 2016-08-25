import javax.xml.bind.SchemaOutputResolver;

public class JoinThreads {
    public static void main(String[] args){
        MyThread myThread1 = new MyThread("Thread 1");
        MyThread myThread2 = new MyThread("Thread 2");
        MyThread myThread3 = new MyThread("Thread 3");

        try{
            myThread1.join();
            System.out.println("Thread 1 joined!");
            myThread2.join();
            System.out.println("Thread 2 joined!");
            myThread3.join();
            System.out.println("Thread 3 joined!");
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }

    }
}

