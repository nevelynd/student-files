package deque;
import org.junit.Test;
import java.util.Comparator;


import static org.junit.Assert.*;



public class MaxArrayDequeTest<T> {
    @Test
    public void Test1() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        Comparator<Integer> cc = getNameComparator();
        MaxArrayDeque<Integer> ad1 = new MaxArrayDeque<Integer>(null);


    }
   
}
public static class NameComparator implements Comparator<Integer> {
    public int compare(int x, int y) {
        if (x < y) {
            return 1;
        }
        if (x > y) {
            return -1;
        } else {
            return 0;
        }
    }

    public static Comparator<Integer> getNameComparator()  {
        return new NameComparator();
    }

}





  //  }