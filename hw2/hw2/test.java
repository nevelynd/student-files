package hw2;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


public class test {
    @Test
    public void test1() {
        PercolationFactory a = new PercolationFactory();
        int N = 2;
        int totalsites = N * N;
        double[] thresholds = new double[4];
        //StdOut.println(a.mean());
        //StdOut.println(a.stddev());
        double ans;
        for (int i = 0;  i <  N; i++) {
            Percolation perc = new Percolation(N);
            int count = 0;
            while (!perc.percolates()) {

                int randomx = count;
                int randomy = 1;
                perc.open(randomx, randomy);
                count  += 1;
            }
            double c = (double) count;
            thresholds[i] = (count / (4.0) );
        }}

}