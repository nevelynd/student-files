package ngordnet.ngrams;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import edu.princeton.cs.algs4.In;


/** An object that provides utility methods for making queries on the
 *  Google NGrams dataset (or a subset thereof).
 *
 *  An NGramMap stores pertinent data from a "words file" and a "counts
 *  file". It is not a map in the strict sense, but it does provide additional
 *  functionality.
 *
 *  @author Josh Hug
 */
public class NGramMap {
    /** Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME. */
    private HashMap<String, TimeSeries> ngrammap = new HashMap<String, TimeSeries>();
    private TimeSeries counts = new TimeSeries();
    public NGramMap(String wordsFilename, String countsFilename) {
        File file1 = new File(wordsFilename);

        In a = new In(file1);
        String s = a.readLine();
        while (a.hasNextLine()) {
            String[] sarray = s.split("\\s+",  0);

            int key = Integer.parseInt(sarray[1]);
            double val = Double.parseDouble(sarray[2]);
            if (ngrammap.containsKey(sarray[0])) {
                ngrammap.get(sarray[0]).put(key, val);
                //TimeSeries tsmap = ngrammap.get(sarray[0]);
                //TimeSeries newts = tsmap.plus(yrcount);
                //double newval = newts.get(key);
                //yrcount.put(key, newval);
                ngrammap.put(sarray[0], ngrammap.get(sarray[0]));

            } else {
                TimeSeries yrcount = new TimeSeries();
                yrcount.put(key, val);
                ngrammap.put(sarray[0], yrcount);
            }
            s = a.readLine();
        }
        File file2 = new File(countsFilename);
        In b = new In(file2);
        String ss;

        while (b.hasNextLine()) {
            ss = b.readLine();
            String[] sarray2 = ss.split(",", 0);
            int key2 = Integer.parseInt(sarray2[0]);
            double val2 = Double.parseDouble(sarray2[1]);
            if (!counts.containsKey(key2)) {
                counts.put(key2, val2);
            } else {
                counts.put(key2, counts.get(key2) + val2);
            }

        }
        //System.out.println("counts");
        //System.out.println(counts);
    }

    /** Provides the history of WORD. The returned TimeSeries should be a copy,
     *  not a link to this NGramMap's TimeSeries. In other words, changes made
     *  to the object returned by this function should not also affect the
     *  NGramMap. This is also known as a "defensive copy". */
    public TimeSeries countHistory(String word) {
        TimeSeries thi = ngrammap.get(word);
        TimeSeries t = new TimeSeries();
        for (int x : thi.keySet()) {
            int key2 = x;
            double val2 = thi.get(x);
            t.put(key2,  val2);

        }

        return t;

    }

    /** Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     *  returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other words,
     *  changes made to the object returned by this function should not also affect the
     *  NGramMap. This is also known as a "defensive copy". */
    public TimeSeries countHistory(String word, int startYear, int endYear) {
        TimeSeries res = new TimeSeries(countHistory(word), startYear, endYear);
        //System.out.println("counthistory ");
        //System.out.println(res);
        return res;

    }

    /** Returns a defensive copy of the total number of words recorded per year in all volumes. */
    public TimeSeries totalCountHistory() {
        TimeSeries t = new TimeSeries();

        for (int x: counts.keySet()) {
            int key2 = (x);
            double val2 = (counts.get(x));
            t.put(key2, val2);
        }
        //System.out.println("totalcounthistory ");
        //System.out.println(t);
        return t;
    }

    /** Provides a TimeSeries containing the relative frequency per year of WORD compared to
     *  all words recorded in that year. */
    public TimeSeries weightHistory(String word) {
        TimeSeries res = countHistory(word);

        for (int year: res.keySet()) {
            if (counts.containsKey(year) && counts.get(year) != null && counts.get(year) != 0.0) {
                double newval = (double) res.get(year) / counts.get(year);
                res.put(year, newval);
            }
        }
        //System.out.println(res);

        return res;
    }

    /** Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     *  and ENDYEAR, inclusive of both ends. */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        TimeSeries t = weightHistory(word);
        TimeSeries res = new TimeSeries(t, startYear, endYear);


        return res;
    }

    /** Returns the summed relative frequency per year of all words in WORDS. */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        TimeSeries res = new TimeSeries();

        for (String word: words) {
            TimeSeries weightedword = weightHistory(word);
            res = res.plus(weightedword);

        }
        return res;
    }

    /** Provides the summed relative frequency per year of all words in WORDS
     *  between STARTYEAR and ENDYEAR, inclusive of both ends. If a word does not exist in
     *  this time frame, ignore it rather than throwing an exception. */
    public TimeSeries summedWeightHistory(Collection<String> words,
                              int startYear, int endYear) {
        TimeSeries t = summedWeightHistory(words);
        TimeSeries res = new TimeSeries(t, startYear, endYear);


        return res;
    }


}
