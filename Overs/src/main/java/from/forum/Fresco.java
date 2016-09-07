package from.forum;

import java.util.Scanner;

public class Fresco extends Food {

    public void Scan()
    {
        Scanner rec = new Scanner(System.in);
        System.out.println("Describe product FRESH");
        descr=rec.next();
        System.out.println("Input the price for kg");
        prezzokg=Double.parseDouble(rec.next());
        System.out.println("Input the weight in kg");
        peso=Double.parseDouble(rec.next());
        System.out.println("Input the calories");
        calorie=Integer.parseInt(rec.next());
    }
}
