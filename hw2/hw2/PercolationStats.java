package hw2;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
public class PercolationStats {
    private int totalsites;
    private double[] thresholds;
    private static final double MULT =  1.96;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        totalsites = N * N;
        thresholds = new double[T];
        for (int i = 0;  i <  T; i++) {
            Percolation perc = pf.make(N);
            while (!perc.percolates()) {
                int randomx = StdRandom.uniform(N);
                int randomy = StdRandom.uniform(N);
                perc.open(randomx, randomy);
            }
            thresholds[i] = (perc.numberOfOpenSites() / (N * N));


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

}
