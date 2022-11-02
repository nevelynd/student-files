package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import ngordnet.ngrams.NGramMap;
import ngordnet.ngrams.TimeSeries;

import java.util.*;

public class HyponymsHandler extends NgordnetQueryHandler {
    private WordNet wn;
    private NGramMap ngm;

    private HashMap<Double, String> wordtopop;
    LinkedList sums = new LinkedList();

    public HyponymsHandler(WordNet wninput, NGramMap ngmap) {
        wn = wninput;
        ngm = ngmap;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        int k = q.k();
        LinkedList result = new LinkedList();





        String response = "";
        String first = words.get(0);
        response = wn.findchildren(first);
        String firstsplitstring = response.substring(1, response.length() - 1);
        List<String> firstsarray = new ArrayList<String>(Arrays.asList(firstsplitstring.split(", ", 0)));
        if (firstsarray.size() == 0) {
            return result.toString();
        }
        for (int i = 1; i < words.size(); i++)  {
            String compare = "";
            compare = wn.findchildren(words.get(i));
            String othersplitstring = compare.substring(1, compare.length() - 1);
            List<String> sarraycompare = new ArrayList<String>(Arrays.asList(othersplitstring.split(", ", 0)));

            for (Iterator<String> iter = firstsarray.iterator(); iter.hasNext();) {
                String check = iter.next();
                if (!sarraycompare.contains(check)) {
                    iter.remove();
                }
                if (sarraycompare.size() == 0) {
                    return result.toString();
                }
            }

        }
        System.out.println(firstsarray);
        if (k != 0) {
            wordtopop = new HashMap<Double, String>();
            for (String word : firstsarray) {
                TimeSeries b = ngm.weightHistory(word, startYear, endYear);
                double sum = 0;
                if (b != null) {
                    for (double val : b.values()) {
                        sum += val;
                    }
                }
                wordtopop.put(sum, word);
                sums.add(sum);
            }
            Collections.sort(sums, Collections.reverseOrder());
            int n = 0;
            for (int i = 0; i < sums.size(); i++) {
                String c = wordtopop.get(sums.get(i));

                if (c != null && !result.contains(c)) {
                    n += 1;
                    result.add(c);
                }

                if (n == k) {
                    break;
                }

            }
            Collections.sort(result);


            return result.toString();


        }




        return firstsarray.toString();

    }
}


