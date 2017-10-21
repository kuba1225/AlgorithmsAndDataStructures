
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import redblacktree.RedBlackTree;

public class RedBlackTreeJUnit {

    Random r;
    TestTools t;

    public RedBlackTreeJUnit() {
    }

    @Before
    public void setUp() {
        r = new Random();
        t = new TestTools();
    }

    /**
     * Metoda ta sprawdza czy po próbie wstawienia do słownika węzła o takim
     * samym kluczu ulegnie zmianie jedynie jego zawartość i nie zostanie on
     * dodany do drzewa jako nowy węzeł
     */
    @Test
    public void changeNodeValue() {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();

        rbt.setValue(6, "test");
        rbt.setValue(3, "test");
        rbt.setValue(8, "test");
        rbt.setValue(1, "test");
        rbt.setValue(5, "test");
        rbt.setValue(7, "test");
        rbt.setValue(9, "test");
        rbt.setValue(4, "test");

        assertEquals(rbt.getValue(6), "test");
        assertEquals(rbt.getValue(8), "test");
        assertEquals(rbt.getValue(9), "test");

        int numberOfNodes = rbt.getNumberOfAllNodes();

        rbt.setValue(6, "rabarbar");
        rbt.setValue(8, "rabarbar");
        rbt.setValue(9, "rabarbar");

        assertEquals(rbt.getValue(6), "rabarbar");
        assertEquals(rbt.getValue(8), "rabarbar");
        assertEquals(rbt.getValue(9), "rabarbar");
        assertEquals(numberOfNodes, rbt.getNumberOfAllNodes());
    }

    /**
     * Metoda ta sprawdza czy węzły skonstruowanego drzewa mają odpowiednie
     * kolory. Sprawdzenie odbywa się na podstawie porównania kolorów węzłów
     * utworzonego drzewa z kolorami węzłów drzewa o znanej strukturze.
     */
    @Test
    public void checkTreeColors() {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();

        rbt.setValue(11, "test");
        rbt.setValue(2, "test");
        rbt.setValue(14, "test");
        rbt.setValue(1, "test");
        rbt.setValue(7, "test");
        rbt.setValue(15, "test");
        rbt.setValue(5, "test");
        rbt.setValue(8, "test");

        assertEquals(rbt.getColor(11), "czarny");
        assertEquals(rbt.getColor(2), "czerwony");
        assertEquals(rbt.getColor(14), "czarny");
        assertEquals(rbt.getColor(1), "czarny");
        assertEquals(rbt.getColor(7), "czarny");
        assertEquals(rbt.getColor(15), "czerwony");
        assertEquals(rbt.getColor(5), "czerwony");
        assertEquals(rbt.getColor(8), "czerwony");
    }

    /**
     * Metoda ta testuje zachowanie drzewa po dodaniu do jego węzłów danych typu
     * String
     */
    @Test
    public void insertStringAsData() {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();
        String x1 = t.wordsBuilder(r.nextInt(10) + 1);
        String x2 = t.wordsBuilder(r.nextInt(10) + 1);
        String x3 = t.wordsBuilder(r.nextInt(10) + 1);
        String x4 = t.wordsBuilder(r.nextInt(10) + 1);
        String x5 = t.wordsBuilder(r.nextInt(10) + 1);
        String x6 = t.wordsBuilder(r.nextInt(10) + 1);
        String x7 = t.wordsBuilder(r.nextInt(10) + 1);
        String x8 = t.wordsBuilder(r.nextInt(10) + 1);

        rbt.setValue(11, x1);
        rbt.setValue(2, x2);
        rbt.setValue(14, x3);
        rbt.setValue(1, x4);
        rbt.setValue(7, x5);
        rbt.setValue(15, x6);
        rbt.setValue(5, x7);
        rbt.setValue(8, x8);

        assertEquals(rbt.getColor(11), "czarny");
        assertEquals(rbt.getColor(2), "czerwony");
        assertEquals(rbt.getColor(14), "czarny");
        assertEquals(rbt.getColor(1), "czarny");
        assertEquals(rbt.getColor(7), "czarny");
        assertEquals(rbt.getColor(15), "czerwony");
        assertEquals(rbt.getColor(5), "czerwony");
        assertEquals(rbt.getColor(8), "czerwony");

        assertEquals(rbt.getValue(11), x1);
        assertEquals(rbt.getValue(2), x2);
        assertEquals(rbt.getValue(14), x3);
        assertEquals(rbt.getValue(1), x4);
        assertEquals(rbt.getValue(7), x5);
        assertEquals(rbt.getValue(15), x6);
        assertEquals(rbt.getValue(5), x7);
        assertEquals(rbt.getValue(8), x8);
    }

    /**
     * Metoda ta testuje zachowanie drzewa po dodaniu do jego węzłów długich
     * łańcuchów danych typu String
     */
    @Test
    public void insertLongStringAsData() {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();
        String x1 = t.wordsBuilder(100) + t.wordsBuilder(100);
        String x2 = t.wordsBuilder(100) + t.wordsBuilder(100);
        String x3 = t.wordsBuilder(100) + t.wordsBuilder(100);
        String x4 = t.wordsBuilder(100) + t.wordsBuilder(100);
        String x5 = t.wordsBuilder(100) + t.wordsBuilder(100);
        String x6 = t.wordsBuilder(100) + t.wordsBuilder(100);
        String x7 = t.wordsBuilder(100) + t.wordsBuilder(100);
        String x8 = t.wordsBuilder(100) + t.wordsBuilder(100);

        rbt.setValue(11, x1);
        rbt.setValue(2, x2);
        rbt.setValue(14, x3);
        rbt.setValue(1, x4);
        rbt.setValue(7, x5);
        rbt.setValue(15, x6);
        rbt.setValue(5, x7);
        rbt.setValue(8, x8);

        assertEquals(rbt.getColor(11), "czarny");
        assertEquals(rbt.getColor(2), "czerwony");
        assertEquals(rbt.getColor(14), "czarny");
        assertEquals(rbt.getColor(1), "czarny");
        assertEquals(rbt.getColor(7), "czarny");
        assertEquals(rbt.getColor(15), "czerwony");
        assertEquals(rbt.getColor(5), "czerwony");
        assertEquals(rbt.getColor(8), "czerwony");

        assertEquals(rbt.getValue(11), x1);
        assertEquals(rbt.getValue(2), x2);
        assertEquals(rbt.getValue(14), x3);
        assertEquals(rbt.getValue(1), x4);
        assertEquals(rbt.getValue(7), x5);
        assertEquals(rbt.getValue(15), x6);
        assertEquals(rbt.getValue(5), x7);
        assertEquals(rbt.getValue(8), x8);
    }

    /**
     * Metoda ta testuje zachowanie drzewa po dodaniu do jego węzłów danych typu
     * Double
     */
    @Test
    public void insertDoubleAsData() {
        RedBlackTree<Integer, Double> rbt = new RedBlackTree<Integer, Double>();
        Double x1 = r.nextDouble();
        Double x2 = r.nextDouble();
        Double x3 = r.nextDouble();
        Double x4 = r.nextDouble();
        Double x5 = r.nextDouble();
        Double x6 = r.nextDouble();
        Double x7 = r.nextDouble();
        Double x8 = r.nextDouble();

        rbt.setValue(11, x1);
        rbt.setValue(2, x2);
        rbt.setValue(14, x3);
        rbt.setValue(1, x4);
        rbt.setValue(7, x5);
        rbt.setValue(15, x6);
        rbt.setValue(5, x7);
        rbt.setValue(8, x8);

        assertEquals(rbt.getColor(11), "czarny");
        assertEquals(rbt.getColor(2), "czerwony");
        assertEquals(rbt.getColor(14), "czarny");
        assertEquals(rbt.getColor(1), "czarny");
        assertEquals(rbt.getColor(7), "czarny");
        assertEquals(rbt.getColor(15), "czerwony");
        assertEquals(rbt.getColor(5), "czerwony");
        assertEquals(rbt.getColor(8), "czerwony");

        assertEquals(rbt.getValue(11), x1);
        assertEquals(rbt.getValue(2), x2);
        assertEquals(rbt.getValue(14), x3);
        assertEquals(rbt.getValue(1), x4);
        assertEquals(rbt.getValue(7), x5);
        assertEquals(rbt.getValue(15), x6);
        assertEquals(rbt.getValue(5), x7);
        assertEquals(rbt.getValue(8), x8);
    }

    /**
     * Metoda ta testuje zachowanie drzewa po dodaniu do jego węzłów danych typu
     * Char
     */
    @Test
    public void insertCharAsData() {
        RedBlackTree<Integer, Character> rbt = new RedBlackTree<Integer, Character>();
        Character x1 = (char) (r.nextInt(26) + 65);
        Character x2 = (char) (r.nextInt(26) + 65);
        Character x3 = (char) (r.nextInt(26) + 65);
        Character x4 = (char) (r.nextInt(26) + 65);
        Character x5 = (char) (r.nextInt(26) + 65);
        Character x6 = (char) (r.nextInt(26) + 65);
        Character x7 = (char) (r.nextInt(26) + 65);
        Character x8 = (char) (r.nextInt(26) + 65);

        rbt.setValue(11, x1);
        rbt.setValue(2, x2);
        rbt.setValue(14, x3);
        rbt.setValue(1, x4);
        rbt.setValue(7, x5);
        rbt.setValue(15, x6);
        rbt.setValue(5, x7);
        rbt.setValue(8, x8);

        assertEquals(rbt.getColor(11), "czarny");
        assertEquals(rbt.getColor(2), "czerwony");
        assertEquals(rbt.getColor(14), "czarny");
        assertEquals(rbt.getColor(1), "czarny");
        assertEquals(rbt.getColor(7), "czarny");
        assertEquals(rbt.getColor(15), "czerwony");
        assertEquals(rbt.getColor(5), "czerwony");
        assertEquals(rbt.getColor(8), "czerwony");

        assertEquals(rbt.getValue(11), x1);
        assertEquals(rbt.getValue(2), x2);
        assertEquals(rbt.getValue(14), x3);
        assertEquals(rbt.getValue(1), x4);
        assertEquals(rbt.getValue(7), x5);
        assertEquals(rbt.getValue(15), x6);
        assertEquals(rbt.getValue(5), x7);
        assertEquals(rbt.getValue(8), x8);
    }

    @Test
    public void insertCharIntKey() {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();

        /**
         * Klucze:
         */
        int k1 = 11;
        int k2 = 2;
        int k3 = 14;
        int k4 = 1;
        int k5 = 7;
        int k6 = 15;
        int k7 = 5;
        int k8 = 8;

        rbt.setValue(k1, "test1");
        rbt.setValue(k2, "test2");
        rbt.setValue(k3, "test3");
        rbt.setValue(k4, "test4");
        rbt.setValue(k5, "test5");
        rbt.setValue(k6, "test6");
        rbt.setValue(k7, "test7");
        rbt.setValue(k8, "test8");

        /**
         * Sprawdzamy czy poszczególne węzły drzewa mają odpowiednie kolory:
         */
        assertEquals(rbt.getColor(k1), "czarny");
        assertEquals(rbt.getColor(k2), "czerwony");
        assertEquals(rbt.getColor(k3), "czarny");
        assertEquals(rbt.getColor(k4), "czarny");
        assertEquals(rbt.getColor(k5), "czarny");
        assertEquals(rbt.getColor(k6), "czerwony");
        assertEquals(rbt.getColor(k7), "czerwony");
        assertEquals(rbt.getColor(k8), "czerwony");

        /**
         * Sprawdzamy czy klucze zwracają odpowiednie dane:
         */
        assertEquals(rbt.getValue(k1), "test1");
        assertEquals(rbt.getValue(k2), "test2");
        assertEquals(rbt.getValue(k3), "test3");
        assertEquals(rbt.getValue(k4), "test4");
        assertEquals(rbt.getValue(k5), "test5");
        assertEquals(rbt.getValue(k6), "test6");
        assertEquals(rbt.getValue(k7), "test7");
        assertEquals(rbt.getValue(k8), "test8");
    }

    @Test
    public void insertCharAsKey() {
        RedBlackTree<Character, String> rbt = new RedBlackTree<Character, String>();

        /**
         * Klucze:
         */
        char k1 = (char) (65 + 11);
        char k2 = (char) (65 + 2);
        char k3 = (char) (65 + 14);
        char k4 = (char) (65 + 1);
        char k5 = (char) (65 + 7);
        char k6 = (char) (65 + 15);
        char k7 = (char) (65 + 5);
        char k8 = (char) (65 + 8);

        rbt.setValue(k1, "test1");
        rbt.setValue(k2, "test2");
        rbt.setValue(k3, "test3");
        rbt.setValue(k4, "test4");
        rbt.setValue(k5, "test5");
        rbt.setValue(k6, "test6");
        rbt.setValue(k7, "test7");
        rbt.setValue(k8, "test8");

        /**
         * Sprawdzamy czy poszczególne węzły drzewa mają odpowiednie kolory:
         */
        assertEquals(rbt.getColor(k1), "czarny");
        assertEquals(rbt.getColor(k2), "czerwony");
        assertEquals(rbt.getColor(k3), "czarny");
        assertEquals(rbt.getColor(k4), "czarny");
        assertEquals(rbt.getColor(k5), "czarny");
        assertEquals(rbt.getColor(k6), "czerwony");
        assertEquals(rbt.getColor(k7), "czerwony");
        assertEquals(rbt.getColor(k8), "czerwony");

        /**
         * Sprawdzamy czy klucze zwracają odpowiednie dane:
         */
        assertEquals(rbt.getValue(k1), "test1");
        assertEquals(rbt.getValue(k2), "test2");
        assertEquals(rbt.getValue(k3), "test3");
        assertEquals(rbt.getValue(k4), "test4");
        assertEquals(rbt.getValue(k5), "test5");
        assertEquals(rbt.getValue(k6), "test6");
        assertEquals(rbt.getValue(k7), "test7");
        assertEquals(rbt.getValue(k8), "test8");
    }

    @Test
    public void insertStringAsKey() {
        RedBlackTree<String, String> rbt = new RedBlackTree<String, String>();

        /**
         * Klucze:
         */
        String k1 = t.wordsBuilder(10, (char) (65 + 11));
        String k2 = t.wordsBuilder(10, (char) (65 + 2));
        String k3 = t.wordsBuilder(10, (char) (65 + 14));
        String k4 = t.wordsBuilder(10, (char) (65 + 1));
        String k5 = t.wordsBuilder(10, (char) (65 + 7));
        String k6 = t.wordsBuilder(10, (char) (65 + 15));
        String k7 = t.wordsBuilder(10, (char) (65 + 5));
        String k8 = t.wordsBuilder(10, (char) (65 + 8));

        rbt.setValue(k1, "test1");
        rbt.setValue(k2, "test2");
        rbt.setValue(k3, "test3");
        rbt.setValue(k4, "test4");
        rbt.setValue(k5, "test5");
        rbt.setValue(k6, "test6");
        rbt.setValue(k7, "test7");
        rbt.setValue(k8, "test8");

        /**
         * Sprawdzamy czy poszczególne węzły drzewa mają odpowiednie kolory:
         */
        assertEquals(rbt.getColor(k1), "czarny");
        assertEquals(rbt.getColor(k2), "czerwony");
        assertEquals(rbt.getColor(k3), "czarny");
        assertEquals(rbt.getColor(k4), "czarny");
        assertEquals(rbt.getColor(k5), "czarny");
        assertEquals(rbt.getColor(k6), "czerwony");
        assertEquals(rbt.getColor(k7), "czerwony");
        assertEquals(rbt.getColor(k8), "czerwony");

        /**
         * Sprawdzamy czy klucze zwracają odpowiednie dane:
         */
        assertEquals(rbt.getValue(k1), "test1");
        assertEquals(rbt.getValue(k2), "test2");
        assertEquals(rbt.getValue(k3), "test3");
        assertEquals(rbt.getValue(k4), "test4");
        assertEquals(rbt.getValue(k5), "test5");
        assertEquals(rbt.getValue(k6), "test6");
        assertEquals(rbt.getValue(k7), "test7");
        assertEquals(rbt.getValue(k8), "test8");
    }

    @Test
    public void insertDoubleAsKey() {
        RedBlackTree<Double, String> rbt = new RedBlackTree<Double, String>();

        /**
         * Klucze:
         */
        double k1 = 11 + r.nextDouble();
        double k2 = 2 + r.nextDouble();
        double k3 = 14 + r.nextDouble();
        double k4 = 1 + r.nextDouble();
        double k5 = 7 + r.nextDouble();
        double k6 = 15 + r.nextDouble();
        double k7 = 5 + r.nextDouble();
        double k8 = 8 + r.nextDouble();

        rbt.setValue(k1, "test1");
        rbt.setValue(k2, "test2");
        rbt.setValue(k3, "test3");
        rbt.setValue(k4, "test4");
        rbt.setValue(k5, "test5");
        rbt.setValue(k6, "test6");
        rbt.setValue(k7, "test7");
        rbt.setValue(k8, "test8");

        /**
         * Sprawdzamy czy poszczególne węzły drzewa mają odpowiednie kolory:
         */
        assertEquals(rbt.getColor(k1), "czarny");
        assertEquals(rbt.getColor(k2), "czerwony");
        assertEquals(rbt.getColor(k3), "czarny");
        assertEquals(rbt.getColor(k4), "czarny");
        assertEquals(rbt.getColor(k5), "czarny");
        assertEquals(rbt.getColor(k6), "czerwony");
        assertEquals(rbt.getColor(k7), "czerwony");
        assertEquals(rbt.getColor(k8), "czerwony");

        /**
         * Sprawdzamy czy klucze zwracają odpowiednie dane:
         */
        assertEquals(rbt.getValue(k1), "test1");
        assertEquals(rbt.getValue(k2), "test2");
        assertEquals(rbt.getValue(k3), "test3");
        assertEquals(rbt.getValue(k4), "test4");
        assertEquals(rbt.getValue(k5), "test5");
        assertEquals(rbt.getValue(k6), "test6");
        assertEquals(rbt.getValue(k7), "test7");
        assertEquals(rbt.getValue(k8), "test8");
    }

    /**
     * Metoda ta sprawdza czy numer węzłów drzewa zwrócony przez funkcję równy
     * jest ilości wstawionych węzłów
     */
    @Test
    public void bigAmountOfRandomData() {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();
        for (int i = 0; i < 1000; i++) {
            rbt.setValue(i, t.wordsBuilder());
        }
        assertEquals(rbt.getNumberOfAllNodes(), 1000);
    }

    /**
     * Metoda ta sprawdza czy korzeń drzewa po wprowadzeniu dużej ilości danych
     * pozostaje czarny
     */
    @Test
    public void rbtreeRootTest() {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();
        for (int i = 0; i < 1000; i++) {
            rbt.setValue(r.nextInt(100), t.wordsBuilder());
        }
        assertEquals(rbt.getColor(rbt.getRootKey()), "czarny");
    }

    /*private void print(RedBlackTree.RBTNode t) {
        RedBlackTree.RBTNode tmp = t;
        System.out.println("ROOT -> Kolor: " + t.color + " klucz: " + t.key + " wartość: " + t.right.data);
        System.out.println("\n~~LEFT~~");
        while (t.left != guard) {
            System.out.println("Kolor: " + t.left.color + " klucz: " + t.left.key + " wartość: " + t.left.data);
            t = t.left;
        }
        System.out.println("GUARD -> Kolor: " + t.right.color + " klucz: " + t.right.key + " wartość: " + t.right.data);
        t = tmp;
        System.out.println("\n~~RIGHT~~");
        while (t.right != guard) {
            System.out.println("Kolor: " + t.right.color + " klucz: " + t.right.key + " wartość: " + t.right.data);
            t = t.right;
        }
        System.out.println("GUARD -> Kolor: " + t.right.color + " klucz: " + t.right.key + " wartość: " + t.right.data);
    }

    private void printTree() {
        print(root);
    }*/
}
