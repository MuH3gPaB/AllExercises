package numerals;

class NumeralsMain {

    static String numeral(int value) {
        StringBuilder result = new StringBuilder(String.valueOf(value));

        value = value%100;
        if(value > 20) value = value%10;

        if(value == 1) result.append(" комментарий");
        else if ((value > 1) && (value < 5)) result.append(" комментария");
        else result.append(" комментариев");

        return result.toString();
    }
}
