package deque;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;


public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized ADeque should be empty", ad1.isEmpty());
        assertEquals("i", ad1.size(), 0);
    }

    @Test
    public void Test2() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        Random n = new Random();

        for (int i = 0; i < 100; i++) {
            int a = n.nextInt(3);
            if (a == 0) {
                ad1.addLast(i);
            }
            if (a == 1) {
                ad1.addFirst(i);
            }
            if (a == 2) {
                ad1.removeLast();
            }
            if (a == 3) {
                ad1.removeFirst();
            }
        }
    }


    @Test
    public void Test3() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        Random n = new Random();
        int a = n.nextInt(7);
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }
        for (int i = 0; i < a; i++) {
            ad1.removeLast();
        }
        for (int i = 0; i < ad1.size(); i++) {
            int b=ad1.get(i);
            assertEquals(b,i);
        }


    }

}

















