package WaitFromStatic;


public class MyMain {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread.sleep(1000);

        synchronized (MyClass.class){
            MyClass.ready = true;
            MyClass.class.notify();
        }
    }
}
