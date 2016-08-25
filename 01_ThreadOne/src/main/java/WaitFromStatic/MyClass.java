package WaitFromStatic;

public class MyClass {
    static boolean ready = false;

    public static synchronized void myMethod(){
        while(!ready) {
            try {
                System.out.println("Waiting for ready...");
                MyClass.class.wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
    }
}
