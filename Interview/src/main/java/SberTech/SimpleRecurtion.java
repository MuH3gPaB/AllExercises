package SberTech;

public class SimpleRecurtion {

    static int sum(int n){
        return(n-1 > 0)?(n-1+sum(n-1)):0;
    }

    public static void main(String args[]){
        System.out.println("0 : " + sum(0));
        System.out.println("1 : " + sum(1));
        System.out.println("2 : " + sum(2));
        System.out.println("3 : " + sum(3));
        System.out.println("4 : " + sum(4));
        System.out.println("5 : " + sum(5));
        System.out.println("6 : " + sum(6));
        System.out.println("7 : " + sum(7));
        System.out.println("8 : " + sum(8));
        System.out.println("9 : " + sum(9));
        System.out.println("10 : " + sum(10));
    }
}
