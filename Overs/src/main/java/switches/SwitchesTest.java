package switches;

public class SwitchesTest {
    public static void main(String[] args) {
        testSwitch(Colors.GREEN);
        testSwitch(Colors.RED);
        testSwitch(Colors.YELLOW);
        testSwitch(null);
    }

    private static void testSwitch(Colors color) {
        switch (color) {
            case RED:
                System.out.println("RED");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }
    }

    private enum Colors {
        RED,
        YELLOW,
        GREEN
    }
}
