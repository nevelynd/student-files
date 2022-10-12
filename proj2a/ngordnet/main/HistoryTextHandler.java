package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import ngordnet.ngrams.NGramMap;


import java.util.List;

public class HistoryTextHandler extends NgordnetQueryHandler {
    private NGramMap m;

    public HistoryTextHandler(NGramMap map) {
        m = map;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        String response = "";
        for (String word : words) {
            response += word + ": " + m.weightHistory(word, startYear, endYear).toString() + "\n";
        }
        return response;

    }
}


