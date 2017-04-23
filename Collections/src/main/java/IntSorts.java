import java.util.Arrays;

public class IntSorts {
    private IntSorts() {
    }

    public static void mergeSort(int[] array) {
        int firstCell = (int) Math.pow(2, Math.ceil(Math.log(array.length)));
        mergeSort1(firstCell, array);
    }

    private static void mergeSort1(int cellSize, int[] array) {
        if (cellSize == 0) return;
        mergeSort1(cellSize / 2, array);

        int cellsCount = (int) Math.ceil((array.length / cellSize) / 2.0);

        for (int i = 0; i < cellsCount; i++) {
            int fromIndex = 2 * i * cellSize;
            int toIndex = (2 * i + 1) * cellSize;

            merge(array, fromIndex, toIndex);
        }
    }

    private static void merge(int[] data, int fromInc, int toExc) {
        int[] first = Arrays.copyOfRange(data, fromInc, toExc);
        int lastIndex = Math.min(data.length, toExc + first.length);
        int[] second = Arrays.copyOfRange(data, toExc, lastIndex);

        int i = 0;
        int j = 0;

        for (int index = fromInc; index < lastIndex; index++) {
            if (i == first.length) data[index] = second[j++];
            else if (j == second.length) data[index] = first[i++];
            else
                data[index] = (first[i] > second[j]) ? second[j++] : first[i++];
        }
    }

}
