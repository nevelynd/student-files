package deque;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized ADeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        int a = 0;
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            a = ad1.size();

            ad1.addLast(i);
        }
        for (double i = 0; i < 5; i++) {
            //ad1.removeFirst();
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 9; i > 5; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }


    }

}























