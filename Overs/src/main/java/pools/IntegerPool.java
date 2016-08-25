package pools;

import java.util.ArrayList;

public class IntegerPool {
    public static void main (String[] args){

        // В java существует пул объектов, содержащих целочисленные переменные типа Byte, Short, Integer, Long
        // со значениями от -128 до 127

        Integer a = 128;    // Создается новый объект
        Integer b = 128;    // Создается новый объект
        Integer c = -128;   // Берется ссылка из пула
        Integer d = -128;   // Берется ссылка из пула на тот же объект, что и c

        System.out.println(a==b);       // Разные объекты
        System.out.println(c==d);       // Ссылки на один объект
        }
}
