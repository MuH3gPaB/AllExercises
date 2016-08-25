package numerals;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class NumeralsTest extends Assert{

    @Test
    public void numeralsTest(){
        assertEquals("0 комментариев", NumeralsMain.numeral(0));

        assertEquals("1 комментарий", NumeralsMain.numeral(1));

        assertEquals("2 комментария", NumeralsMain.numeral(2));
        assertEquals("3 комментария", NumeralsMain.numeral(3));
        assertEquals("4 комментария", NumeralsMain.numeral(4));

        assertEquals("5 комментариев", NumeralsMain.numeral(5));
        assertEquals("10 комментариев", NumeralsMain.numeral(10));
        assertEquals("11 комментариев", NumeralsMain.numeral(11));
        assertEquals("12 комментариев", NumeralsMain.numeral(12));
        assertEquals("14 комментариев", NumeralsMain.numeral(14));
        assertEquals("18 комментариев", NumeralsMain.numeral(18));

        assertEquals("20 комментариев", NumeralsMain.numeral(20));
        assertEquals("21 комментарий", NumeralsMain.numeral(21));
        assertEquals("22 комментария", NumeralsMain.numeral(22));
        assertEquals("23 комментария", NumeralsMain.numeral(23));
        assertEquals("24 комментария", NumeralsMain.numeral(24));
        assertEquals("25 комментариев", NumeralsMain.numeral(25));

        assertEquals("50 комментариев", NumeralsMain.numeral(50));
        assertEquals("51 комментарий", NumeralsMain.numeral(51));
        assertEquals("52 комментария", NumeralsMain.numeral(52));
        assertEquals("53 комментария", NumeralsMain.numeral(53));
        assertEquals("54 комментария", NumeralsMain.numeral(54));
        assertEquals("55 комментариев", NumeralsMain.numeral(55));

        assertEquals("100 комментариев", NumeralsMain.numeral(100));

        assertEquals("101 комментарий", NumeralsMain.numeral(101));
        assertEquals("102 комментария", NumeralsMain.numeral(102));
        assertEquals("104 комментария", NumeralsMain.numeral(104));
        assertEquals("111 комментариев", NumeralsMain.numeral(111));
        assertEquals("116 комментариев", NumeralsMain.numeral(116));
        assertEquals("121 комментарий", NumeralsMain.numeral(121));

        assertEquals("1010012 комментариев", NumeralsMain.numeral(1010012));
        assertEquals("102123 комментария", NumeralsMain.numeral(102123));
        assertEquals("10124 комментария", NumeralsMain.numeral(10124));
        assertEquals("11111 комментариев", NumeralsMain.numeral(11111));
        assertEquals("11160 комментариев", NumeralsMain.numeral(11160));
        assertEquals("1213 комментариев", NumeralsMain.numeral(1213));
    }

}
