package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
@Test
    public void testThreeAddThreeRemove(){
    AListNoResizing<Integer> c= new AListNoResizing<>();
    BuggyAList<Integer> b = new BuggyAList<>();
    c.addLast(4);
    c.addLast(5);
    c.addLast(6);
    b.addLast(4);
    b.addLast(5);
    b.addLast(6);

    assertEquals(c.size(), b.size());
    assertEquals(c.removeLast(), b.removeLast());
    assertEquals(c.removeLast(), b.removeLast());
    assertEquals(c.removeLast(), b.removeLast());
}

@Test
    public void randomizedTest(){
    AListNoResizing<Integer> c = new AListNoResizing<>();
    BuggyAList<Integer> b = new BuggyAList<>();

    int N = 5000;
    for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        if (operationNumber == 0) {
            // addLast
            int randVal = StdRandom.uniform(0, 100);
            c.addLast(randVal);
            b.addLast(randVal);

        } else if (operationNumber == 1) {
            // size
            int size = c.size();
            int sizeb= b.size();


        } else if (operationNumber == 2 && c.size()!=0 || b.size()!=0) {
            // get Last

            int gl= c.getLast();
            int glb= b.getLast();



            }
        }


    //assertEquals(c.size(), b.size());
    //assertEquals(c.addLast(), b.addLast());

    //assertEquals(c.getLast(), b.getLast());
    //assertEquals(c.removeLast(), b.removeLast());
    }

  // YOUR TESTS HERE
}
