package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] intgrid;
    private boolean[][] boolgrid;
    private boolean[][] isfullgrid;

    private int topsite;
    private int bottomsite;
    private int opensites = 0;

    WeightedQuickUnionUF table;
    public Percolation(int N) {

        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        intgrid = new int[N][N];
        boolgrid = new boolean[N][N];
        isfullgrid = new boolean[N][N];


        table = (WeightedQuickUnionUF) new WeightedQuickUnionUF(N * N + 2);
        topsite = N * N;
        bottomsite = N * N + 1;

    }
    // create N-by-N grid, with all sites initially blocked
    private void xygrid() {
        int num  = 0;
        for (int r = 0; r < intgrid.length; r++) {
            for (int c = 0; c < intgrid.length; c++) {
                intgrid[r][c] = num;
                boolgrid[r][c] = false;
                isfullgrid[r][c] = false;
                num += 1;

            }
        }
    }
    private int xyto1d(int row, int col) {
        if (row >= boolgrid.length || row < 0 || col >= boolgrid.length || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        return intgrid[row][col];
    }


    public void open(int row, int col) {


        if (row >= boolgrid.length || row < 0 || col >= boolgrid.length || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!boolgrid[row][col]) {
            boolgrid[row][col] = true;
            opensites += 1;
            if (row == 0) {
                table.union(xyto1d(row, col), topsite);
                isfullgrid[row][col] = true;
            }
            if (col == boolgrid.length) {
                table.union(xyto1d(row, col), bottomsite);
            }
            if ((col + 1 < boolgrid.length) && isOpen(row, col + 1)) {
                table.union(xyto1d(row, col), xyto1d(row, col + 1));
            }
            if ((col - 1 >= 0) && isOpen(row, col - 1)) {
                table.union(xyto1d(row, col), xyto1d(row, col - 1));
            }
            if ((row - 1 >= 0) && isOpen(row - 1, col)) {
                table.union(xyto1d(row, col), xyto1d(row - 1, col));

            }
            if ((row + 1 < boolgrid.length) && isOpen(row + 1, col)) {
                table.union(xyto1d(row, col), xyto1d(row + 1, col));
            }

            if (table.connected(topsite, xyto1d(row, col))) {
                isfullgrid[row][col] = true;
            }

        }

    }

    // open the site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        if (row >= boolgrid.length || row < 0 || col >= boolgrid.length || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!boolgrid[row][col]) {
            return false;
        }
        return true;
    }

    // is the site (row, col) open?
    public boolean isFull(int row, int col) {

        if (row >= boolgrid.length || row < 0 || col >= boolgrid.length || col < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (isfullgrid[row][col] && isOpen(row, col)) {
            return true;
        }
        return false;
    }
    // is the site (row, col) full?
    public int numberOfOpenSites() {
        return opensites;
    }

    // number of open sites
    public boolean percolates() {
        return table.connected(topsite, bottomsite);
    }

    // does the system percolate?
}

