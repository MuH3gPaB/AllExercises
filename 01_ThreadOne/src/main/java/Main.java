
public class Main {
    public static void main(String[] args){
        MyThread myThread1 = new MyThread("Поток 1");
        MyThread myThread2 = new MyThread("Поток 2");
        MyThread myThread3 = new MyThread("Поток 3");

        do{
            System.out.print("*");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Главный поток прерван!");
            }
        }while (myThread1.isAlive() || myThread2.isAlive() || myThread3.isAlive());
    }
}
