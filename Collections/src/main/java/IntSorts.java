import java.util.Arrays;
import java.util.Random;

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

    // Shake sort
    public static void shakeSort(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int leftLimit = i;
            int rightLimit = array.length - i - 1;

            for (int j = leftLimit; j < rightLimit; j++) {
                if (array[j] > array[j + 1]) swap(array, j, j + 1);
            }

            for (int j = rightLimit; j > leftLimit; j--) {
                if (array[j] < array[j - 1]) swap(array, j, j - 1);
            }
        }
    }

    // Gnome sort
    public static void gnomeSort(int[] array) {
        int position = 0;
        while (position < array.length) {
            if (position == 0) {
                position++;
            } else if (array[position - 1] > array[position]) {
                swap(array, position - 1, position);
                position--;
            } else {
                position++;
            }
        }
    }

    // Insert sort
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            int insertToIndex = i;
            while (insertToIndex > 0 && array[insertToIndex - 1] > element) {
                insertToIndex--;
                array[insertToIndex + 1] = array[insertToIndex];
            }
            array[insertToIndex] = element;
        }
    }

    // Shell sort
    public static void shellSort(int[] array) {
        int interval = array.length / 2;
        while (interval > 0) {
            sortInterval(array, interval);
            interval = interval / 2;
        }
    }

    private static void sortInterval(int[] array, int interval) {
        for (int i = 0; i < interval; i++) {
            for (int j = i; j < array.length; j += interval) {
                int element = array[j];
                int insertToIndex = j;
                while (insertToIndex > i && array[insertToIndex - interval] > element) {
                    insertToIndex -= interval;
                    array[insertToIndex + interval] = array[insertToIndex];
                }
                array[insertToIndex] = element;
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

    // Quick sort
    public static void quickSort(int[] array) {
        quickSort1(array, 0, array.length);
    }

    private static void quickSort1(int[] array, int from, int to) {
        if (Math.abs(to - from) <= 1) return;

        int random = Math.abs(new Random().nextInt());
        int pivotPosition = from + random % (to - from);
        int pivot = array[pivotPosition];

        int leftMark = from;
        int rightMark = to - 1;

        while (leftMark < rightMark) {
            while (array[leftMark] < pivot && leftMark < rightMark) leftMark++;
            while (array[rightMark] > pivot && leftMark < rightMark) rightMark--;
            if (array[leftMark] == array[rightMark]) {
                leftMark++;
                continue;
            }
            swap(array, leftMark, rightMark);
        }

        quickSort1(array, from, rightMark);
        quickSort1(array, rightMark, to);
    }

}
