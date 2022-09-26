package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private int size;
    private int nfirst;
    private int nlast;
    public static final int EIGHT = 8;
    public static final int SIXTEEN = 16;
    public static final int FOUR = 4;

    private T[] array;
    public ArrayDeque() {

        array = (T[]) new Object[EIGHT];
        size = 0;
        nfirst = 0;
        nlast = 1;


    }
    public int size() {
        return size; }
    public boolean isEmpty() {
        return size == 0; }

    private void resizebrm(int cap) {

        T[] narray = (T[]) new Object[cap];
        System.arraycopy(array, 0, narray, 0, cap);
        array = narray;
    }

    private void resizef(int cap) {

        T[] narray = (T[]) new Object[cap];
        int b = 1;
        if (nfirst == 0) {
            b = 0;
        }
        for (int i = 0; i < size; i++) {
            int a = (nfirst + i + b) % size;
            narray[i] = array[a];
        }
        array = narray;
        nfirst = cap - 1;
    }
    private void resizel(int cap) {
        T[] narray = (T[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            int a = (nfirst + i) % size;
            narray[i] = array[a];
        }
        array = narray;
        nfirst = cap - 1; }
    private void resizefirstrm(int cap) {


        T[] narray = (T[]) new Object[cap];
        if (size == 2) {
            if (nfirst == 0) {
                T temp = array[0];
            } else {
                T temp = array[(nfirst + 2) % array.length];
                array = (T[]) new Object[1];
                array[0] = temp;
            }
        } else {
            int b = 2;
            if (nfirst == 0) {
                b = 1;
            }
            for (int i = 0; i < size - 1; i++) {
                int a = (b + nfirst + i) % array.length;
                narray[i] = array[a]; }
            array = narray;
        }
        nfirst = 0;
    }

    private void resizelastrm(int cap) {
        T[] narray = (T[]) new Object[cap];
        if (size == 2) {
            T temp = array[(nfirst + 2) % array.length];
            array = (T[]) new Object[1];
            array[0] = temp;
        } else {
            for (int i = 0; i < size - 1; i++) {
                int a = (1 + nfirst + i) % array.length;
                narray[i] = array[a];
            }


            array = narray;
        }
        nfirst = 0;
    }

    public void addFirst(T item) {
        if (size == array.length) {
            if (array.length == 0) {
                array = (T[]) new Object[1];
            } else {
                resizef(array.length * 2);
            }
            nlast = size;
        }
        array[nfirst] = item;
        nfirst = (nfirst - 1);
        if (nfirst < 0) {
            nfirst = array.length - 1;
        }
        size += 1;
    }
    public void addLast(T item) {

        if (array.length == 0) {
            array = (T[]) new Object[1];
            nlast = 0;
        }
        if (size == array.length) {
            resizel(array.length * 2);
            nlast = size;
        }
        array[nlast] = item;
        size += 1;
        if (size != array.length) {
            nlast = (nlast + 1) % array.length;
        } else {
            nlast = (nlast + 1);
        }
    }

    public T removeFirst() {
        if (array.length >= SIXTEEN && size <= FOUR) {
            resizebrm(array.length / 2);
        }
        if (size != 0) {
            T res = array[(nfirst + 1) % array.length];
            resizefirstrm(size - 1);
            size -= 1;
            nlast = array.length;
            return res;
        }
        return null;
    }
    public T removeLast() {
        if (array.length >= SIXTEEN && size <= FOUR) {
            resizebrm(array.length / 2);
        }
        if (size != 0) {
            int oldbacki;
            oldbacki = nlast - 1;

            if (oldbacki < 0) {
                if (size != 1) {
                    oldbacki = array.length - 1;
                } else {
                    oldbacki = 0;
                }
            }
            T ans = array[oldbacki];
            resizelastrm(size - 1);
            size -= 1;
            nlast = array.length;
            return ans;
        }
        return null;
    }

    public T get(int index) {
        if (index > (size - 1) && size != 1) {
            return null;
        } else if (size == array.length && nfirst == 0) {
            return array[((index + nfirst) % array.length)];
        } else {
            return array[((index + nfirst  + 1) % array.length)];
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Deque<?>) {
            Deque<T> newe = (Deque<T>) o;
            if (size() != newe.size()) {
                return false;
            }
            for (int i = 0; i < size(); i++) {
                if (!newe.get(i).equals(get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void printDeque() {
        T[] copy = (T[]) new Object[size];
        System.arraycopy(array, 0, copy, 0, size);
        int i = 0;
        int count = size;
        String res = "";
        if (size == 0) {
            res = " ";
        }
        while (size != 0 && copy != null) {
            res += copy[i] + " ";
            T[] narray =  (T[]) new Object[size - 1];
            System.arraycopy(array, 1, narray, 0, size - 1);
            count -= 1;
            i += 1;
        }
        System.out.println(res);
    }


    public Iterator<T> iterator() {
        return null;
        //boolean hasNext();
        //T next();



    }
}
