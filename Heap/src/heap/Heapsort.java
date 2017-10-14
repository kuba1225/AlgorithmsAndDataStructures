package heap;

public class Heapsort implements ListSorterAlgorithm {

    /**
     * Ta metoda zwraca wektor posortowanych liczb typu double
     */
    @Override
    public double[] sort(double[] argv) {
        int n = argv.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapArray(argv, n, i);
        }//sprawdzamy tutaj warunek kopca od ostatniego ojca do korzenia(budujemy kopiec)

        for (int i = n - 1; i > 0; i--) {
            swap(argv, i, 0);//zamieniamy korzeń kopca z jego ostatnim liściem
            heapArray(argv, i, 0);
        }
        return argv;
    }

    /**
     * Ta metoda używana jest do sprawdzania warunku kopca
     */
    private void heapArray(double[] argv, int w, int parentIndex) {
        int large = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        if (leftChild < w && argv[leftChild] > argv[large]) {//jeżeli lewy syn danego węzła jest większy to on staje się el. maksymalnym
            large = leftChild;
        }

        if (rightChild < w && argv[rightChild] > argv[large]) {
            large = rightChild;
        }

        if (large != parentIndex) {//jeżeli el.maksymalny jest różny od węzła-rodzica to zamieniamy miejscami dany węzeł z większym synem, i rekurencyjnie przeszukujemy dalszą część kopca
            swap(argv, large, parentIndex);
            heapArray(argv, w, large);
        }
    }

    /**
     * Metoda ta zamienia ze sobą miejscami dwa elementy tablicy
     */
    private void swap(double[] argv, int i, int j) {
        double tmp = argv[i];
        argv[i] = argv[j];
        argv[j] = tmp;
    }

}
