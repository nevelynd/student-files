package gh2;

import deque.ArrayDeque;
import deque.Deque;
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    private Deque<Double> buffer = new ArrayDeque<>();

    public GuitarString(double frequency) {

        double s = Math.round(SR / frequency);
        int  ss = (int) s;
        for (int i = 0; i < ss; i++) {
            buffer.addFirst((double) 0);
        }
    }


    public void pluck() {

        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.

        for (int i = 0; i < buffer.size(); i++) {
            double r = Math.random() - 0.5;
            buffer.removeFirst();
            buffer.addLast(r);
        }
    }


    public void tic() {
        if (buffer != null) {

                double rm = buffer.removeFirst();
                double g = buffer.get(0);
                double a = DECAY * (.5 * (rm + g));
                buffer.addLast(a);

        }
    }


    public double sample() {
        if (buffer == null) {
            return (double) 0;
        }
        return buffer.get(0);
    }
}
