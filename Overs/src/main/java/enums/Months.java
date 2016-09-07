package enums;


public enum Months {
    JUNE("june", 30){
        @Override
        public String toString(){
            return this.name + " is absent!";
        }
    },
    JULY("july"),
    AUGUST("august", 31),
    SEPTEMBER("september", 30);

    protected final String name;
    protected int days = 0;

    Months(String name, int days) {
        this.name = name;
        this.days = days;
    }

    Months(String name){
        this.name = name;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString(){
        return "Month " + this.name + " have " + this.days + " days.";
    }
}
