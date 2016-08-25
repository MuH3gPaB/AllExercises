package Priority;

public class Priority implements Runnable{

    Thread thread;
    public int count = 0;

    static String currentName;
    static boolean stop = false;

    public Priority(String name){
        thread = new Thread(this, name);
        currentName = name;
    }

    public void run() {
        do{
            if(!currentName.equals(thread.getName())) {
                currentName = thread.getName();
            }
            count++;
            if(count > 10000000) stop = true;

        }while (!stop);
    }

}
