
class MyThread extends Thread{

        MyThread(String name){
            super(name);
            start();
        }

        public void run(){
        System.out.println(getName() + " запущен!");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Счетчик " + getName() + " : " + i);
                sleep(400);
            }
        }catch (InterruptedException e){
            System.out.println(getName() + " прерван!");
        }
        System.out.println(getName() + " завершен!");
    }
}
