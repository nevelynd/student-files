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
    ArrayList<Double> sums = new ArrayList();


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
        HashSet<String> result = new HashSet<>();
        if (words.size() == 0) {
            return result.toString();
        }
        String response = "";
        String first = words.get(0);
        response = wn.findchildren(first);
        String firstsplitstring = response.substring(1, response.length() - 1);
        List<String> firstsarray = new ArrayList<String>(Arrays.asList(firstsplitstring.split(", ", 0)));
        if (firstsarray.size() <= 1) {
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
        if (k != 0 && firstsarray.size() > 1) {
            wordtopop = new HashMap<Double, String>();
            for (String word : firstsarray) {
                TimeSeries b = ngm.weightHistory(word, startYear, endYear);
                if (!b.isEmpty() && b.size() != 0) {
                    double sum = 0;
                    for (double val : b.values()) {
                        sum += val;
                    }
                    wordtopop.put(sum, word);
                    sums.add(sum);
                }
            }
            Collections.sort(sums, Collections.reverseOrder());
            int n = 0;
            for (int i = 0; i < sums.size(); i++) {
                String c = wordtopop.get(sums.get(i));
                if (c != null && !result.contains(c) && sums.get(i) != 0.0) {
                    n += 1;
                    result.add(c);
                }
                if (n == k) {
                    break;
                }
            }
            ArrayList newresult = new ArrayList();
            for (String wordss  : result) {
                newresult.add(wordss);
            }
            Collections.sort(newresult);
            return newresult.toString();
        }
        return firstsarray.toString();
    }
}


