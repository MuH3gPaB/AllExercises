package from.forum;

public class Food {
    protected double prezzokg, peso, prezzoun;
    protected int calorie;
    protected String descr, marca, cat;
    public Food(double prezzokg, double peso, double prezzoun, int calorie, String descr, String marca, String cat)
    {
        this.prezzokg=prezzokg;
        this.peso=peso;
        this.prezzoun=prezzoun;
        this.calorie=calorie;
        this.descr=descr;
        this.marca=marca;
        this.cat=cat;
    }
    public double Total()
    {
        return prezzokg*peso;
    }

    public Food(){
        super();
    }
}
