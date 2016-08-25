import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

//      Нельзя выкидывать throw из блока catch без объявления в сигнатуре метода
//        try{
//            String a = null;
//        }catch (Throwable e){
//            System.out.println("error");
//            throw e;
//        }finally {
//            System.out.println("finnaly");
//        }


        // Можно создавать объекты класса без конструктора (видимо используется конструктор Object)
        new MyClass().makeString("Ivan", "Petrov");

        // Существуют классы примитивных типов
        Class class1 = Integer.class;
        System.out.println(class1);
        Class class2 = String[].class;
        System.out.println(class2);
        Class class3 = int.class;
        System.out.println(class3);



        // == сравнивает указатели, equals - значения
        Long a = new Long(5000L);
        Long b = new Long(5000L);
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println("");

        // Еще одна проверка equals
        String stringOne;
        String stringTwo;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Если ввести одинаковые строки, то == даст false, а equals - true
            System.out.print("Строка 1:");
            stringOne = br.readLine();
            System.out.print("Строка 2:");
            stringTwo = br.readLine();

            System.out.println(stringOne==stringTwo?" == true":" == false");
            System.out.println(stringOne.equals(stringTwo)?" equals true":" equalsg false");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
