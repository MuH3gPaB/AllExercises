import java.io.*;

public class AnyClass {

    static String normalizeString(boolean templateLiteral, String value) {
        if (templateLiteral) {
            // <CR><LF> and <CR> are normalized as <LF> for raw string value
            value = value.replaceAll("\r\n?", "\n");
        }
        int start = templateLiteral ? 0 : 1; // skip the leading quote
        int cur = value.indexOf('\\');
        if (cur == -1) {
            // short circuit no escapes.
            return templateLiteral ? value : value.substring(1, value.length() - 1);
        }
        StringBuilder result = new StringBuilder();
        while (cur != -1) {
            if (cur - start > 0) {
                result.append(value, start, cur);
            }
            cur += 1; // skip the escape char.
            char c = value.charAt(cur);
            switch (c) {
                case '\'':
                case '"':
                case '\\':
                    result.append(c);
                    break;
                case 'b':
                    result.append('\b');
                    break;
                case 'f':
                    result.append('\f');
                    break;
                case 'n':
                    result.append('\n');
                    break;
                case 'r':
                    result.append('\r');
                    break;
                case 't':
                    result.append('\t');
                    break;
                case 'v':
                    result.append('\u000B');
                    break;
                case '\n':
                    System.out.println("WARNING!!!");
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    char next1 = value.charAt(cur + 1);
                    break;
                case 'x':
                    break;
                case 'u':
                    int escapeEnd;
                    String hexDigits;
                    if (value.charAt(cur + 1) != '{') {
                        // Simple escape with exactly four hex digits: \\uXXXX
                        escapeEnd = cur + 5;
                        hexDigits = value.substring(cur + 1, escapeEnd);
                    } else {
                        // Escape with braces can have any number of hex digits: \\u{XXXXXXX}
                        escapeEnd = cur + 2;
                        while (Character.digit(value.charAt(escapeEnd), 0x10) >= 0) {
                            escapeEnd++;
                        }
                        hexDigits = value.substring(cur + 2, escapeEnd);
                        escapeEnd++;
                    }
                    result.append(Character.toChars(Integer.parseInt(hexDigits, 0x10)));
                    cur = escapeEnd - 1;
                    break;
                default:
                    // TODO(tbreisacher): Add a warning because the user probably
                    // intended to type an escape sequence.
                    result.append(c);
                    break;
            }
            start = cur + 1;
            cur = value.indexOf('\\', start);
        }
        // skip the trailing quote.
        result.append(value, start, templateLiteral ? value.length() : value.length());

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
//        File file = new File("StringDance/Closurecompiler/dialog.js");
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        boolean read = true;
//        while (read){
//            String str = br.readLine();
//            if(str != null) System.out.print(str.toCharArray());
//            else read = false;
//        }
//
//        br.close();
        System.out.print(normalizeString(true, "return $(' \\" + '\n'));
        System.out.print("!END!");
    }
}
