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
        int l=0;
        AList test= new AList<Integer>();
        AList ns= new AList<Integer>();
        AList times= new AList<Double>();
        AList opcounts= new AList<Integer>();
        while (l<=7){
        while (i<=1000*(2^l)) {
            Stopwatch sw= new Stopwatch();

            test.addLast(i);
            double time =sw.elapsedTime();
            times.addLast(time);



            i+=1;
        }
            ns.addLast(1000*(2^l));

            opcounts.addLast(1000*(2^l));
            l+=1;
        }

        printTimingTable(ns, times, opcounts);







        // TODO: YOUR CODE HERE
    }
}
