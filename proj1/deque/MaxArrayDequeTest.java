package deque;
import org.junit.Test;



import static org.junit.Assert.*;



public class MaxArrayDequeTest<T> {
    @Test
    public void Test1() {
        //Comparators<T> cc = maxx();
        MaxArrayDeque<Integer> ad1 = new MaxArrayDeque<Integer>(null);


    }


    private class Comparatorr<E> {
        public int maxx(int x, int y) {
            if (x < y) {
                return 1;
            }
            if (x > y) {
                return -1;
            } else {
                return 0;
            }
        }

    }

}