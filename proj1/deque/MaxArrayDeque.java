package deque;
import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }
    public T max() {
        if (size() == 0) {
            return null;
        } else {
            T ans = get(0);
            while (iterator().hasNext()) {
                if (comp.compare(ans, iterator().next()) == 1) {
                    ans = iterator().next();
                }

            }
            return ans;

        }
    }


    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        } else {
            T ans = get(0);
            while (iterator().hasNext()) {
                if (c.compare(ans, iterator().next()) == 1) {
                    ans = iterator().next();
                }
            }
            return ans;
        }
    }






}

