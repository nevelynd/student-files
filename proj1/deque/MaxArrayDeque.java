package deque;

import java.util.Iterator;


public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }


    public T max() {
        if (this.size() == 0) {
            return null;
        } else {
            T ans = this.get(0);
            while (this.hasNext()) {
                T cres = comp.compare(ans, this.next());
            }
        }
    }


    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        } else {
            for (int i = 0; i < this.size(); i++) {
                T cres = c.compare(this.get(0), this.next());

            }

        }
    }


    public interface Comparator<T> {
        int compare(T o1, T o2);
    }

    
}

