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
        AList ns= new AList<Integer>();
        AList times= new AList<Double>();
        AList opcounts= new AList<Integer>();
        while (i<=7) {
            Stopwatch sw= new Stopwatch();

            ns.addLast(1000*(2^i));
            double time =sw.elapsedTime();
            times.addLast(time);

            opcounts.addLast(1000*(2^i));

            i+=1;
        }

        printTimingTable(ns, times, opcounts);







        // TODO: YOUR CODE HERE
    }
}
