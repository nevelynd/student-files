package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;
        public IntNode(IntNode p, T i, IntNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private int size;
    private IntNode sentinel;
    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
    }
    public void addFirst(T item) {
        if (sentinel.next != null) {
            IntNode temp = sentinel.next;
            sentinel.next = new IntNode(sentinel, item, sentinel.next);
            temp.prev = sentinel.next;
        } else {
            sentinel.next = new IntNode(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
        }
        size += 1;
    }
    public void addLast(T item) {
        if (sentinel.prev != null) {
            IntNode temp = sentinel.prev;
            sentinel.prev = new IntNode(sentinel.prev, item, sentinel);
            temp.next = sentinel.prev;
        } else {
            sentinel.prev = new IntNode(sentinel, item, sentinel);
            sentinel.next = sentinel.prev;
        }
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque()  {
        int count = size;
        String res = "";
        if (size == 0) {
            res = " ";
        }
        while (size != 0 && count >= 0 && sentinel.item != null) {
            res += sentinel.item + " ";
            sentinel = sentinel.next;
            count -= 1;
        }
        System.out.println(res);
    }
    public T removeFirst() {
        if (size == 0 || sentinel.next == null) {
            return null;
        } else {
            size -= 1;
            T res = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return res;
        }
    }
    public T removeLast() {
        if (size == 0 || sentinel.prev == null) {
            return null;
        } else {
            size -= 1;
            IntNode oldback = sentinel.prev;
            IntNode newback = oldback.prev;
            sentinel.prev = newback;
            newback.next = sentinel;
            return oldback.item;
        }
    }
    public T get(int index) {
        IntNode p = sentinel.next;
        T ans = p.item;
        while (index <= size && index != 0) {
            p = p.next;
            index -= 1;
            ans = p.item;
        }
        return ans;
    }
    private T helper(IntNode p, int index) {
        if (index < 0) {
            return null;
        }  else if (index == 0) {
            return p.item;
        }
        p = p.next;
        index -= 1;
        return helper(p, index);
    }
    public T getRecursive(int index) {
        IntNode p = sentinel.next;
        T ans = helper(p, index);
        return ans;
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

    private class LLIter<E> implements Iterator<E> {
        private IntNode iter = sentinel.next;
        public boolean hasNext() {
            return iter.next != null;
        }

        public E next() {
            E res = (E) iter.item;
            iter = iter.next;
            return res;
        }
    }

    public Iterator<T> iterator() {
        return new LLIter<T>();
    }

    private interface Iterable<T> {
        boolean hasNext();

        T next();
    }
}





