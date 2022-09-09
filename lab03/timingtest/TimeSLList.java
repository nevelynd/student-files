package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        int i=0;
        SLList test= new SLList<Integer>();
        AList ns= new AList<Integer>();
        AList times= new AList<Double>();
        AList opcounts= new AList<Integer>();
        int i=0;
        int l=0;
       ;while (i<=1000*(2^l)) {
        test.addLast(i);
        }
        i=0;
        while (l<=7){
            Stopwatch sw= new Stopwatch();



                test.getLast();



            double time =sw.elapsedTime();
            times.addLast(time);
            ns.addLast(1000*(2^l));

            opcounts.addLast(10000);
            l+=1;
        }

        printTimingTable(ns, times, opcounts);



        // TODO: YOUR CODE HERE
    }


}
