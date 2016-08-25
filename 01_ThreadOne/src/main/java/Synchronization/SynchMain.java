package Synchronization;


import java.util.Scanner;

public class SynchMain {

    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        MySummThread th1 = new MySummThread("Thread 1", a);
        MySummThread th2 = new MySummThread("Thread 2", a);
    }
}
