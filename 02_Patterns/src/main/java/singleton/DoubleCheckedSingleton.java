package singleton;

public final class DoubleCheckedSingleton {

    private static final DoubleCheckedSingleton instance = new DoubleCheckedSingleton();

    private DoubleCheckedSingleton(){
        System.out.println("Constructor!");
    }

    public static DoubleCheckedSingleton getInstance(){
        System.out.println("get instance!");
        return instance;
    }
}
