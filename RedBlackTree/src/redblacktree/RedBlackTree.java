package redblacktree;

import java.util.Random;

public class RedBlackTree<T extends Comparable<T>> {

    private static final boolean BLACK = false;
    private static final boolean RED = true;
    /**
     * Reprezentuje korzeń drzewa czerwono-czarnego.
     */
    private RBTNode root = null;
    /**
     * Reprezentuje strażnika drzewa czerwono-czarnego.
     */
    private RBTNode guard;

    RedBlackTree() {

        guard = new RBTNode();
        guard.color = BLACK;
        guard.up = guard;
        guard.left = guard;
        guard.right = guard;
        root = guard;
    }

    /**
     * Klasa reprezentująca pojedyńczy węzeł drzewa
     */
    private class RBTNode {

        RBTNode left;
        RBTNode right;
        RBTNode up;
        boolean color;
        int key;
        T data;

        private void setBlackColor() {
            this.color = BLACK;
        }

        private void setRedColor() {
            this.color = RED;
        }
    }

    private boolean getColor(RBTNode n) {
        return n.color;
    }

    /**
     * Metoda ta służy do wstawiania nowych elementów do drzewa
     * czerwono-czarnego.
     *
     * @param key klucz nowego węzła
     * @param obj nowy obiekt znajdujący się wewnątrz wstawianego węzła
     */
    public void push(int key, T obj) {
        RBTNode t = new RBTNode();
        t.left = guard;
        t.right = guard;
        t.up = root;//na początku nowy węzeł ustawiamy pod korzeniem
        t.key = key;
        t.data = obj;

        if (t.up == guard) {
            root = t;
        } else {
            compareKeys(t, key);
        }

        t.color = RED;//ustawiamy kolor nowego węzła na czerwony

        repaintRBTreeAfterPush(t);
    }

    /**
     * Metoda ta służy do ustawiania węzłów w taki sposób aby jego klucze
     * spełniały warunek binarnego drzewa przeszukiwań.
     *
     * @param t wstawiany węzeł
     * @param key klucz nowego węzła
     */
    private void compareKeys(RBTNode t, int key) {
        if (key < t.up.key) {//gdy klucz wstawianego węzła jest mniejszy od kluca jego ojca
            if (t.up.left == guard) {
                t.up.left = t;
            } else {
                t.up = t.up.left;
                compareKeys(t, key);
            }
        } else {
            if (t.up.right == guard) {
                t.up.right = t;
            } else {
                t.up = t.up.right;
                compareKeys(t, key);
            }
        }

    }

    /**
     * Metoda ta służy do ustawiania nowego węzła w drzewie tak, aby po jego
     * wstawieniu drzewo spełniało warunek drzewa czerwono-czarnego.
     * Rozpatrujemy tu trzy podstawowe przypadki umiejscowienia węzłów jakie
     * mogą wystąpić podczas wstawiania do drzewa nowego węzła.
     *
     * @param t węzeł wstawiany do drzewa
     */
    private void repaintRBTreeAfterPush(RBTNode t) {
        RBTNode uncle;
        while (t != root && t.up.color == RED) {
            if (t.up == t.up.up.left) {
                uncle = t.up.up.right;//"wujek" wstawianego węzła
                if (uncle.color == RED) {//PIERWSZY PRZYPADEK
                    t.up.setBlackColor();
                    uncle.setBlackColor();
                    t.up.up.setRedColor();
                    t = t.up.up;//tymcasowy węzeł staje się "dziadkiem"
                } else {
                    if (t == t.up.right) {//DRUGI PRZYPADEK
                        t = t.up;
                        rotacjaLewo(t);
                    }
                    t.up.setBlackColor();//TRZECI PRZYPADEK
                    t.up.up.setRedColor();
                    rotacjaPrawo(t.up.up);
                }
            } else {//Przypadki lustrzane
                uncle = t.up.up.left;
                if (uncle.color == RED) {//PIERWSZY PRZYPADEK
                    t.up.setBlackColor();
                    uncle.setBlackColor();
                    t.up.up.setRedColor();
                    t = t.up.up;//tymcasowy węzeł staje się "dziadkiem"
                } else {
                    if (t == t.up.left) {//DRUGI PRZYPADEK
                        t = t.up;
                        rotacjaPrawo(t);
                    }
                    t.up.setBlackColor();//TRZECI PRZYPADEK
                    t.up.up.setRedColor();
                    rotacjaLewo(t.up.up);
                }
            }
        }
        root.color = BLACK;//ustawiamy kolor korzenia na czarny (w razie gdyby w wyniku powyższych operacji stał się czerwony)

    }

    /**
     * Metoda ta służy do wykonywania rotacji węzłów drzewa w prawo względem
     * podanego węzła. Metoda lustrzana do metody rotacjaLewo(RBTNode node).
     *
     * @param node węzeł względem którego ma zostać wykonana rotacja w prawo
     */
    private void rotacjaPrawo(RBTNode node) {
        RBTNode tmp1, tmp2;

        tmp1 = node.left;
        if (tmp1 != guard) {
            tmp2 = node.up;
            node.left = tmp1.right;

            if (node.left != guard) {
                node.left.up = node;
            }
            tmp1.right = node;
            tmp1.up = tmp2;
            node.up = tmp1;

            if (tmp2 != guard) {
                if (tmp2.left == node) {
                    tmp2.left = tmp1;
                } else {
                    tmp2.right = tmp1;
                }
            } else {
                root = tmp1;
            }
        }
        //System.out.println("Rotacja w prawo");
    }

    /**
     * Metoda ta służy do wykonywania rotacji węzłów drzewa w lewo względem
     * podanego węzła. Metoda lustrzana do metody rotacjaPrawo(RBTNode node).
     *
     * @param node węzeł względem którego ma zostać wykonana rotacja w lewo
     */
    private void rotacjaLewo(RBTNode node) {
        RBTNode tmp1, tmp2;

        tmp1 = node.right;
        if (tmp1 != guard) {
            tmp2 = node.up;
            node.right = tmp1.left;
            if (node.right != guard) {
                node.right.up = node;
            }
            tmp1.left = node;
            tmp1.up = tmp2;
            node.up = tmp1;

            if (tmp2 != guard) {
                if (tmp2.left == node) {
                    tmp2.left = tmp1;
                } else {
                    tmp2.right = tmp1;
                }
            } else {
                root = tmp1;
            }
        }
        //System.out.println("Rotacja w lewo");
    }

    private void print(RBTNode t) {
        System.out.println("ROOT -> Kolor: " + t.color + " klucz: " + t.key);
        while (t.right != guard) {
            System.out.println("Kolor: " + t.right.color + " klucz: " + t.right.key);
            t = t.right;
        }
        System.out.println("GUARD -> Kolor: " + t.right.color + " klucz: " + t.right.key);
    }

    private void printTree() {
        print(root);
    }

    public static void main(String[] args) {

        Random r = new Random();
        int x;
        String y;
        RedBlackTree<String> rbt = new RedBlackTree<String>();
        //for (int i = 0; i < 1000; i++) {
        x = r.nextInt(1000);
        y = wordsBuilder(10);
        //rbt.push(i, y);
        //System.out.println("test " + i + " : " + x + ",\t" + y);
        rbt.push(6, "test");
        rbt.push(3, "test");
        rbt.push(8, "test");
        rbt.push(1, "test");
        rbt.push(5, "test");
        rbt.push(7, "test");
        rbt.push(9, "test");
        rbt.push(4, "test");
        //}
        rbt.printTree();
    }

    /**
     * Metoda służąca do generowania losowych łańcuchów znaków.
     *
     * @param n długość łańcucha znaków do wygenerowania
     * @return wygenerowany łańcuch znaków
     */
    public static String wordsBuilder(int n) {
        Random r = new Random();
        StringBuilder b = new StringBuilder();
        b.append((char) ('A' + r.nextInt(26)));
        for (int i = 1; i < n; i++) {
            b.append((char) ('a' + r.nextInt(26)));
        }
        return b.toString();
    }
}
