package Callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name){
        this.name = name;
    }

    public Integer call() throws Exception {
        System.out.println(name + " : start.");
        int i;
        for (i = 0; i < 10; i++) {
            System.out.println(name + " count : " + i);
            Thread.sleep(100);
        }
        System.out.println(name + " : finished. Count : " + i);
        return i;
    }
}
