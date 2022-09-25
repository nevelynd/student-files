package deque;

import org.junit.Test;

import java.util.Optional;
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

        for (int i = 0; i < 10; i++) {
            int a = n.nextInt(3);
            a = 0;
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

        for (int i = 0; i < 10000; i++) {
            ad1.addFirst(i);
        }



        //for (int i = 0; i < 5000; i++) {
         //  ad1.removeLast();}

       //for (int i = 0; i < 500000; i++) {
           // ad1.removeLast();
       // }}
}
    @Test
    public void Test4() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
        ad1.addLast(i);

        assertEquals("i", (int) ad1.get(i), i);}
        for (int i = 0; i <5; i++) {
            assertEquals("i", (int) ad1.removeFirst(), i);}
        for (int i = 9; i >=5; i--) {
            assertEquals("i", (int) ad1.removeLast(), i);}
}

    @Test
    public void Test5() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();

        for (int i = 0; i < 8; i++) {
        ad1.addFirst(i);}
        for (int i = 7; i >=0; i-=1) {
            {assertEquals("i", (int) ad1.removeFirst(), i);}}
        }}




















