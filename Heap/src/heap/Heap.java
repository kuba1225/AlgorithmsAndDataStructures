package heap;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private Object[] array;
    private int arraySize = 0;

    public Heap() {
        array = new Object[10];
    }

    /**
     * metoda ta służy do wstawiania obiektów do kopca
     */
    @Override
    public void put(T item) {
        int i = arraySize;
        arraySize++;

        if (arraySize > array.length) {
            doubleSize();
        }
        int j = (i - 1) / 2;

        while (i > 0 && ((T) array[j]).compareTo(item) < 0) {//tutaj wyszukujemy odpowiednie miejsce dla wstawianego obiektu, aby był spełniony warunek kopca
            array[i] = array[j];
            i = j;
            j = (i - 1) / 2;
        }
        array[i] = item;
    }

    /**
     * metoda ta służy do podwajania rozmiaru tablicy array[]
     */
    private void doubleSize() {
        Object[] d = new Object[2 * array.length];
        System.arraycopy(array, 0, d, 0, array.length);
        array = d;
    }

    /**
     * metoda ta służy do pobierania największego elementu kopca - korzenia
     */
    @Override
    public T pop() {
        if (arraySize > 0) {
            arraySize--;
            T x = (T) array[arraySize];
            T y = (T) array[0];//największy element kopca - korzeń
            int i = 0;
            int j = 1;
            while (j < arraySize) {
                if (j + 1 < arraySize && ((T) array[j]).compareTo(((T) array[j + 1])) < 0) {//wybieramy który z synów danego węzła jest większy (jeżeli istnieje)
                    j++;
                }
                if (x.compareTo((T) array[j]) >= 0) {//jeżeli synowie danego węzła są od niego mniejsi to przerywamy poszukiwania
                    break;
                }

                array[i] = array[j];
                i = j;
                j = 2 * j + 1;
            }

            array[i] = x;
            return y;
        }
        throw new IndexOutOfBoundsException("Heap is empty!");//gdy kopiec jest pusty rzucamy wyjątek 
    }

    /**
     * metoda ta zwraca aktualny rozmiar kopca
     */
    public int size() {
        return arraySize;
    }

}
