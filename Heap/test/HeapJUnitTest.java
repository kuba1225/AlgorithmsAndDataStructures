
import heap.Heap;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapJUnitTest {

    public HeapJUnitTest() {
    }

    /**
     * test metody pup
     */
    @Test
    public void testPutMethod() {
        Heap<Integer> h = new Heap<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            h.put(r.nextInt(100));
        }
    }

    /**
     * test metody pop
     */
    @Test
    public void testPopMethod() {
        Heap<Integer> h = new Heap<Integer>();
        int[] v = new int[10];
        int x;
        for (int i = 0; i < 10; i++) {
            h.put(i);
        }
        for (Integer i = 9; i >= 0; i--) {

            assertEquals(h.pop(), i);
        }
    }

    /**
     * test metody pop wobec pustego kopca
     */
    @Test
    public void testPopForEmptyHeap() {
        Heap<Integer> h = new Heap<Integer>();
        Random r = new Random();

        for (int i = 0; i < 1; i++) {
            try {
                System.out.println(h.pop());
            } catch (IndexOutOfBoundsException e) {
                assertEquals(e.getMessage(), "Heap is empty!");
                assertEquals(h.size(), 0);
            }
        }
    }

    /**
     * test metody podwajającej rozmiar wektora
     */
    @Test
    public void doubleVectorSizeTest() {
        Heap<Integer> h = new Heap<Integer>();
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            h.put(r.nextInt(1000));
        }

    }

    /**
     * test działania struktury wobec elementów String
     */
    @Test
    public void stringTest() {
        Heap<String> h = new Heap<String>();
        h.put("Ala");
        h.put("ma");
        h.put("kota");
        h.put("a");
        h.put("Karol");
        h.put("ma");
        h.put("psa");

        assertEquals(h.pop(), "psa");
        assertEquals(h.pop(), "ma");
        assertEquals(h.pop(), "ma");
        assertEquals(h.pop(), "kota");
        assertEquals(h.pop(), "a");
        assertEquals(h.pop(), "Karol");
        assertEquals(h.pop(), "Ala");
    }

    /**
     * test działania struktury wobec elementów String składających się z kilku
     * wyrazów
     */
    @Test
    public void longStringTest() {
        Heap<String> h = new Heap<String>();
        String x = "Stół z powyłamywanymi nogami";
        h.put(x);
        h.put("ABC DEF");
        assertEquals(h.pop(), x);
    }

    /**
     * test działania struktury wobec elementów Double
     */
    @Test
    public void doubleNumbersTest() {
        Heap<Double> h = new Heap<Double>();
        Double[] v = {9.23, 8.225, 7.234, 5.234, 2.654, 1.42324, 0.3};
        for (int i = 0; i < v.length; i++) {
            h.put(v[i]);
        }
        for (int i = 0; i < v.length; i++) {
            assertEquals(h.pop(), v[i]);
        }
    }

    /**
     * test działania struktury wobec elementów Long
     */
    @Test
    public void longNumbersTest() {
        Heap<Long> h = new Heap<Long>();
        Long[] v = {93453543l, 83442334l, 73442340l, 67567567l, 56767567l};
        for (int i = 0; i < v.length; i++) {
            h.put(v[i]);
        }
        for (int i = 0; i < v.length; i++) {
            assertEquals(h.pop(), v[i]);
        }
    }

    /**
     * test działania struktury wobec elementów Float
     */
    @Test
    public void floatTest() {
        Heap<Float> h = new Heap<Float>();
        Float[] v = {5.234f, 4.2323f, 2.2342f, 1.2342f, 0.2343f};
        for (int i = 0; i < v.length; i++) {
            h.put(v[i]);
        }
        for (int i = 0; i < v.length; i++) {
            assertEquals(h.pop(), v[i]);
        }
    }

    /**
     * test działania struktury wobec elementów Char
     */
    @Test
    public void charTest() {
        Heap<Character> h = new Heap<Character>();
        Character[] v = {'z', 'f', 'd', 'b', 'a'};
        for (int i = 0; i < v.length; i++) {
            h.put(v[i]);
        }
        for (int i = 0; i < v.length; i++) {
            assertEquals(h.pop(), v[i]);
        }
    }

}
