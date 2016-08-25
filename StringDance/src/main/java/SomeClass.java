public class SomeClass {
    private static String cookString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i++);
            if (c == '\\') {
                char c2 = s.charAt(i++);
                switch (c2) {
                    case 't':
                        sb.append('\t');
                        break;
                    case 'n':
                        sb.append('\n');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 'f':
                        sb.append('\f');
                        break;
                    case 'b':
                        sb.append('\b');
                        break;
                    case 'u':
                        int unicodeValue = Integer.parseInt(s.substring(i, i + 4), 16);
                        sb.append((char) unicodeValue);
                        i += 4;
                        break;
                    // Strip line continuation.
                    case '\n':
                    case '\u2028':
                    case '\u2029':
                        break;
                    case '\r':
                        // \ \r \n should be stripped as one
                        if (s.charAt(i + 1) == '\n') {
                            i++;
                        }
                        break;

                    default:
                        sb.append(c);
                        sb.append(c2);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] arg){
        System.out.print(cookString("return $(' \\n"));
        System.out.print("!END!");
    }
}
