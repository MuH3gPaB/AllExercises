import java.util.Arrays;

public class IntSorts {
    private IntSorts() {
    }

    // Selection sort
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            swap(array, i, getIndexMin(array, i, array.length));
        }
    }

    private static int getIndexMin(int[] array, int from, int to) {
        int minIndex = from;
        for (int i = from; i < to; i++) {
            if (array[i] < array[minIndex]) minIndex = i;
        }
        return minIndex;
    }

    private static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    // Bubble sort
    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) swap(array, j, j + 1);
            }
        }
    }

    

    // Merge sort
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
