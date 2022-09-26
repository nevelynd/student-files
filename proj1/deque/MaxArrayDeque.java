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
                int cres = comp.compare(ans, iterator().next());

                ans = comp.compare(ans, crest);

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
                T cres = c.compare(ans, iterator().next());
                ans = c.compare(ans, cres);
            }
            return ans;
        }
    }






}

