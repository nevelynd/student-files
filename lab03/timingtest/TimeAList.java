package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        int i=0;
        int n=1000;
        AList test= new AList<Integer>();
        AList ns= new AList<Integer>();
        AList times= new AList<Double>();
        AList opcounts= new AList<Integer>();
        while (n<=128000){
            Stopwatch sw= new Stopwatch();
            while (i<=n) {
                test.addLast(i);
                i+=1;}
            double time =sw.elapsedTime();

            times.addLast(time);
            ns.addLast(n);
            i=0;
            opcounts.addLast(n);
            n=2*n;
            test= new AList<Integer>();
        }

        printTimingTable(ns, times, opcounts);







        // TODO: YOUR CODE HERE
    }
}
