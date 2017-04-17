import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class SortTest extends Assert {

    private int[] array;
    private Runnable algorithm;

    public SortTest(Runnable algorithm) {
        this.algorithm = algorithm;
    }

    @Parameterized.Parameters
    public Runnable[] getSorts() {
        return new Runnable[]{
                () -> Sorts.mergeSort(array)
        };
    }



}
