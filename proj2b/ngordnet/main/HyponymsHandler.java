package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import ngordnet.ngrams.NGramMap;

import java.util.List;

public class HyponymsHandler extends NgordnetQueryHandler {
        private WordNet wn;

        public HyponymsHandler(WordNet wninput) {
            wn = wninput;
        }

        @Override
        public String handle(NgordnetQuery q) {
            List<String> words = q.words();
            int startYear = q.startYear();
            int endYear = q.endYear();
            String response = "hello";

            return response;

        }
    }


