package enums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String [] args) throws IOException {
        Months.AUGUST.setDays(5);
        for(Months month : Months.values()){
            System.out.println(month);
        }
    }
}
