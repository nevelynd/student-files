package deque;
import java.util.Comparator;
import java.util.Iterator;
public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }
    public T max() {
        if (size() == 0) {
            return null;
        } else {
            Iterator<T> i = iterator();
            T ans = i.next();

            while (i.hasNext()) {
                T temp =  i.next();
                if (comp.compare(ans, temp) == -1) {
                    ans = temp;
                }

            }
            return ans;

        }
    }


    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        } else {
            Iterator<T> i = iterator();
            T ans = i.next();
            while (i.hasNext()) {
                T temp =  i.next();
                if (c.compare(ans, temp) == -1) {
                    ans = temp;
                }

            }
            return ans;
        }
    }






}

