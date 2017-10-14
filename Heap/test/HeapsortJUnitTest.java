
import heap.Heapsort;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapsortJUnitTest {

    Heapsort hs;

    public HeapsortJUnitTest() {
    }

    @Before
    public void setUp() {
        hs = new Heapsort();
    }

    /**
     * metoda sprawdzająca zachowanie algorytmu podczas sortowania długiej
     * tablicy
     */
    @Test
    public void longVectorTest() {
        double[] v = new double[1000];
        Random r = new Random();

        for (int i = 0; i < v.length; i++) {
            v[i] = r.nextDouble() * r.nextInt(1000);
        }

        hs.sort(v);

        assertTrue(assertAscendingOrder(v));
    }

    /**
     * metoda sprawdzająca zachowanie algorytmu wobec posortowanej rosnąco
     * tablicy
     */
    @Test
    public void sortedElementTest() {
        double[] v = new double[100];
        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }

        hs.sort(v);

        assertTrue(assertAscendingOrder(v));
    }

    /**
     * metoda sprawdzająca zachowanie algorytmu sortującego wobec pustej tablicy
     */
    @Test
    public void emptyVectorTest() {
        double[] v = new double[100];

        double[] x = hs.sort(v);

        assertTrue(assertAscendingOrder(x));
    }

    /**
     * metoda sprawdzająca zachowanie algorytmu sortującego wobec tablicy
     * zawierającej te same liczby
     */
    @Test
    public void thisSameElementsInVectorTest() {
        double[] v = {3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0};

        double[] x = hs.sort(v);

        assertTrue(assertAscendingOrder(x));
    }

    /**
     * metoda ta służy do sprawdzenia złożoności czasowej algorytmu (wynosi ona
     * N*log2(N)
     */
    @Test
    public void timeComplexityTest() {
        double[] v128 = new double[128];
        double[] v256 = new double[256];
        double[] v512 = new double[512];
        double[] v1024 = new double[1024];
        double[] v2048 = new double[2048];

        for (int i = v128.length; i > 0; i--) {
            v128[i - 1] = i;
        }

        for (int i = v256.length; i > 0; i--) {
            v256[i - 1] = i;
        }

        for (int i = v512.length; i > 0; i--) {
            v512[i - 1] = i;
        }

        for (int i = v1024.length; i > 0; i--) {
            v1024[i - 1] = i;
        }

        for (int i = v2048.length; i > 0; i--) {
            v2048[i - 1] = i;
        }

        long start, stop;
        long r128, r256, r512, r1024, r2048;

        start = System.nanoTime();
        hs.sort(v128);
        stop = System.nanoTime();
        r128 = stop - start;

        start = System.nanoTime();
        hs.sort(v256);
        stop = System.nanoTime();
        r256 = stop - start;

        start = System.nanoTime();
        hs.sort(v512);
        stop = System.nanoTime();
        r512 = stop - start;

        start = System.nanoTime();
        hs.sort(v1024);
        stop = System.nanoTime();
        r1024 = stop - start;

        start = System.nanoTime();
        hs.sort(v2048);
        stop = System.nanoTime();
        r2048 = stop - start;

        System.out.println("Test złożoności czasowej algorytmu: ");
        System.out.println((double) r256 / (double) r128 + " <= " + (256 * Math.log(256) / Math.log(2)) / (128 * Math.log(128) / Math.log(2)));
        System.out.println((double) r512 / (double) r256 + " <= " + (512 * Math.log(512) / Math.log(2)) / (256 * Math.log(256) / Math.log(2)));
        System.out.println((double) r1024 / (double) r512 + " <= " + (1024 * Math.log(1024) / Math.log(2)) / (512 * Math.log(512) / Math.log(2)));
        System.out.println((double) r2048 / (double) r1024 + " <= " + (2048 * Math.log(2048) / Math.log(2)) / (1024 * Math.log(1024) / Math.log(2)));

    }

    /**
     * metoda sprawdzająca czy tablica została poprawnie posortowana
     */
    private boolean assertAscendingOrder(double[] argv) {
        boolean test = true;
        for (int i = 0; i < argv.length - 1; i++) {
            if (argv[i + 1] < argv[i]) {
                test = false;
                break;
            }
        }
        return test;
    }

}
