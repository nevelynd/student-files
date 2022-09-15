package flik;
import org.junit.Test;
import static org.junit.Assert.*;
public class fliktests {

@Test
    public void test1() {
    int i=1000;
    int j=1000;
    boolean ans= Flik.isSameNumber(i,j);
    assertEquals(true, ans);


    }

    public void test2() {
        int i=1000;
        int j=100;
        boolean ans= Flik.isSameNumber(i,j);
        assertEquals(false, ans);


    }
}
