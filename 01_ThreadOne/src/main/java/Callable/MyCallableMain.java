package Callable;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCallableMain {

    public static void main (String[] args){

        MyCallable th1 = new MyCallable("Thread 1");
        MyCallable th2 = new MyCallable("Thread 2");

        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.submit(th1);
        ex.submit(th2);

        ex.shutdown();

    }
}
