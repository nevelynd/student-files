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

        for (int i = 0; i < 9; i++) {
            int a = n.nextInt(2);
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

        for (int i = 0; i < 1000000; i++) {
            ad1.addLast(i);


        }



        for (int i = 0; i < 49; i++) {
           ad1.removeFirst();}
        for (int i =49; i < 50000; i++) {
            ad1.removeLast();}

       //for (int i = 0; i < 500000; i++) {
           // ad1.removeLast();
       // }}
}
    @Test
    public void Test4() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            Random n = new Random();
            int b = n.nextInt(2);
            if (b==0)
            {ad1.addLast(i);}
            else {ad1.addFirst(i);}
        }

        for (int i = 10; i >0; i--) {
            Random n = new Random();
            int a = n.nextInt(2);
            if (a==0)
            {ad1.removeLast();

            }
            else {ad1.removeFirst();}

}}

    @Test
    public void Test5() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();

        for (int i = 0; i < 8; i++) {
        ad1.addFirst(i);}
        for (int i = 7; i >=0; i-=1) {
            {assertEquals("i", (int) ad1.removeFirst(), i);}}
        }

    @Test
    public void Test6() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        Random n = new Random();
        int a = n.nextInt(20000);
        for (int i = 0; i < a; i++) {

                ad1.addLast(i);}
        int b = n.nextInt(20000);
            for (int i = 0; i < b; i++) {
                ad1.addFirst(i);}
        int c = n.nextInt(20000);
        for (int i = 0; i < c; i++) {
                ad1.removeLast();}
        int d = n.nextInt(20000);
        for (int i = 0; i < d; i++) {
                ad1.removeFirst();}
            }
    @Test
    public void Test7() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();

        ArrayDeque.addLast(0);
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(2);
        ArrayDeque.addLast(3);
    }
}




















