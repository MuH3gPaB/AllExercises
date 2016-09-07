package from.forum;

public class Main {
    public static void main (String args[])
    {
        double prezzokg, peso;
        int cod=0, calorie, prezzoun;
        String descr, marca, categ;
        System.out.println("Benvenuto in Esselunga");
        Fresco f = new Fresco();
        f.Scan();
        System.out.println("Food, fresh product, code "+cod+" : "+f.descr+", "+"total price €"+f.Total());
    }
}
