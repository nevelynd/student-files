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
        assertEquals("i", (int) ArrayDeque.get(0), 0);
        ArrayDeque.addLast(1);
        ArrayDeque.addLast(2);
        assertEquals("i", 1,  (int) ArrayDeque.get(1));
    }

    @Test
    public void Test8() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
        ArrayDeque.addFirst(i);}
        for (int i = 0; i < 10; i++) {
        ArrayDeque.removeFirst();}
        for (int i = 0; i < 10; i++) {
            ArrayDeque.addFirst(i);}

    }
    @Test
    public void Test9() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();


        ArrayDeque.addFirst(2);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();
    }

    @Test
    public void Test00() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.addFirst(9);
        ArrayDeque.addFirst(10);
        ArrayDeque.addFirst(11);
        ArrayDeque.addFirst(12);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(13);
        ArrayDeque.removeLast();
}
    @Test
    public void Test01() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addLast(2);
        ArrayDeque.addLast(3);
        ArrayDeque.addLast(4);
        ArrayDeque.addLast(5);
        ArrayDeque.addLast(6);
        ArrayDeque.addLast(7);
        ArrayDeque.addLast(8);
        ArrayDeque.addLast(9);
        ArrayDeque.addLast(10);
        ArrayDeque.addLast(11);
        ArrayDeque.addLast(12);
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(13);
        ArrayDeque.removeLast();

    }





}




















