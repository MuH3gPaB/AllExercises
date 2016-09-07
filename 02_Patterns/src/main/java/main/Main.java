package main;


import singleton.DoubleCheckedSingleton;

public class Main {

    public static void main (String[] args){
        System.out.println("start!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stop!");
        DoubleCheckedSingleton.getInstance();
    }
}
