package boxing;

import java.io.IOException;

public class Boxing {
    public static void main (String args[]) throws IOException {
        Character character = 10;
        Byte mybyte = 10;
        Short myshort = 10;
        Integer integer = 10;
        Long mylong = 10L;
        Float myfloat = 10F;
        Double mydouble = 10D;

        int i;
        for (i = 0; (char) System.in.read() != 'S'; i++){
            System.out.println("reopen #" + i );
        }

    }
}
