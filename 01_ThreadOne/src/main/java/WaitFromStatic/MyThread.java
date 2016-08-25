package WaitFromStatic;

public class MyThread implements Runnable{

    Thread thread;

    public MyThread(){
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        System.out.println("Started!");
        MyClass.myMethod();
        System.out.println("Finished!");
    }
}
