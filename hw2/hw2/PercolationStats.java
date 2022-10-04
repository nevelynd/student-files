package hw2;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
public class PercolationStats {
    private double totalsites;
    private double[] thresholds;
    private static final double MULT =  1.96;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        double totalsites = (double) N * N;
        thresholds = new double[T];
        for (int i = 0;  i <  T; i++) {
            Percolation perc = pf.make(N);
            double count = 0;
            while (!perc.percolates()) {
                int randomx = StdRandom.uniform(N);
                int randomy = StdRandom.uniform(N);
                perc.open(randomx, randomy);
                count += 1;
            }
            thresholds[i] = (count / totalsites );



        }
    }
    // perform T independent experiments on an N-by-N grid
    public double mean() {
        return StdStats.mean(thresholds);
    }
    // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }
    // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return (mean() - (MULT * stddev() / Math.sqrt(thresholds.length)));
    }
    // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return (mean() + (MULT * stddev() / Math.sqrt(thresholds.length)));
    }
    // high endpoint of 95% confidence interval

    /*package hw2;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


public class pstest {
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
             thresholds[i] = (count );
    }}

}

    */
}
