import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class SortTest extends Assert {

    private static int[] array;
    private Runnable algorithm;

    public SortTest(Runnable algorithm) {
        this.algorithm = algorithm;
    }

    @Parameterized.Parameters
    public static Runnable[] getSorts() {
        return new Runnable[]{
                () -> IntSorts.mergeSort(array),
                () -> IntSorts.selectionSort(array),
                () -> IntSorts.bubbleSort(array),
                () -> IntSorts.shakeSort(array),
                () -> IntSorts.quickSort(array),
                () -> IntSorts.gnomeSort(array),
                () -> IntSorts.insertSort(array)
        };
    }

    @Test
    public void simpleSortTest() throws Exception {
        array = new int[]{0, 12, -1, 22, 999, 0, -15, 45, -12, 24345, Integer.MAX_VALUE};

        checkSortAlgorithm();
    }

    @Test
    public void emptyArraySortTest() throws Exception {
        array = new int[]{};

        checkSortAlgorithm();
    }

    @Test
    public void revertedArraySortTest() throws Exception {
        array = new int[]{99, 50, 12, 0, -1, -1000};

        checkSortAlgorithm();
    }

    private void checkSortAlgorithm() {
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        algorithm.run();

        assertArrayEquals(expected, array);
    }
}
