package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private int size;
    private int nfirst;
    private int nlast;
    private static final int EIGHT = 8;
    private static final int SIXTEEN = 16;
    private static final int FOUR = 4;
    private T[] array;
    public ArrayDeque() {
        array = (T[]) new Object[EIGHT];
        size = 0;
        nfirst = 0;
        nlast = 1;
    }
    public int size() {
        return size;
    }

    private void resize(int cap) {
        T[] narray = (T[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            int a = (nfirst + i) % size;
            narray[i] = array[a];
        }
        array = narray;
        nfirst = cap - 1;
    }

    private void resizel(int cap) {
        T[] narray = (T[]) new Object[cap];
        for (int i = 0; i < (size + 1); i++) {
            int a = (nfirst + i + 1) % (size + 1);
            narray[i] = array[a];
        }
        array = narray;
        nfirst = cap - 1;
    }

    private void resizefirstrm(int cap) {
        T[] narray = (T[]) new Object[cap+1];
        for (int i = 0; i < size - 1; i++) {
            int a = (nfirst + 2+ i) % array.length;
            narray[i] = array[a];
        }
        array = narray;
        nfirst = cap;
    }

    private void resizelastrm(int cap) {
        T[] narray = (T[]) new Object[cap + 1];
        for (int i = 0; i < size - 1; i++) {
            int a = (1 + nfirst + i) % array.length;
            narray[i] = array[a];
        }
        array = narray;
        nfirst = cap;
    }

    public void addFirst(T item) {
        if (array.length == 0) {

            array = (T[]) new Object[1];
            array[nfirst] = item;
            size += 1;
            nlast = size;
        } else if (size == array.length) {

            resize(array.length * 2);
            array[nfirst] = item;
            size += 1;
            nlast = size;
        } else if (size == array.length - 1) {
                array[nfirst] = item;
                size += 1;
                resize(array.length * 2);
                nlast = size;
        } else {
            array[nfirst] = item;
            size += 1;
            nfirst -= 1;
            if (nfirst < 0) {
                nfirst = array.length - 1;
            }

        }

    }


    public void addLast(T item) {

        if (array.length == 0) {
            array = (T[]) new Object[1];
            nlast = 0;
            array[nlast] = item;
        } else if (size == array.length) {
            resize(array.length * 2);
            nlast = size;
            array[nlast] = item;
            size += 1;
        } else if (size == array.length - 1) {
            array[nlast] = item;
            resizel(array.length * 2);
            nlast = size;
        }

        else {
            array[nlast] = item;
        }
        size += 1;
        if (size != array.length) {
            nlast = (nlast + 1) % array.length;
        } else {
            nlast = (nlast + 1);
        }
    }

    public T removeFirst() {
        //resizef(array.length);
        if (array.length >= SIXTEEN && size <= FOUR) {
            resize(size - 1);
            nlast = size;
        }
        if (size != 0) {
            T res = array[(nfirst + 1) % array.length];
            array[(nfirst + 1) % array.length] = null;
            nfirst = (nfirst + 1) % array.length;
            size -= 1;
            return res;
        }
        return null;
    }

    public T removeLast() {
        if (array.length >= SIXTEEN && size <= FOUR) {
            resize(size - 1);
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
            array[nlast - 1] = null;
            size -= 1;
            nlast = size;
            return ans;
        }
        return null;
    }

    public T get(int index) {
        if (index > (size - 1) && size != 1) {
            return null;
        } else {
            return array[((index + nfirst + 1) % array.length)];
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
            T[] narray = (T[]) new Object[size - 1];
            System.arraycopy(array, 1, narray, 0, size - 1);
            count -= 1;
            i += 1;
        }
        System.out.println(res);
    }



    private class ArrayIter<E> implements Iterator<E> {
        private int iter = 0;
        public boolean hasNext() {
            return iter < size;
        }

        public E next() {
            E res = (E) get(iter);
            iter += 1;
            return res;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIter<T>();
    }


    private interface Iterable<T> {
        boolean hasNext();

        T next();
    }
}





