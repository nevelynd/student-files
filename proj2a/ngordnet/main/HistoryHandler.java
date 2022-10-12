package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import ngordnet.ngrams.NGramMap;
import ngordnet.ngrams.TimeSeries;
import ngordnet.plotting.Plotter;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;

public class HistoryHandler extends NgordnetQueryHandler {
    private NGramMap m;

    public HistoryHandler(NGramMap map) {
        m = map;
    }
    @Override
    public String handle(NgordnetQuery q) {

        ArrayList<TimeSeries> lts = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        for (String word : q.words()) {
            labels.add(word);
            //System.out.println(word);
            //System.out.println(m);
            //System.out.println(m.weightHistory(word, q.startYear(), q.endYear()));
            lts.add(m.weightHistory(word, q.startYear(), q.endYear()));
        }

        XYChart chart = Plotter.generateTimeSeriesChart(labels, lts);
        String encodedImage = Plotter.encodeChartAsString(chart);
        System.out.println(encodedImage);
        return encodedImage;
    }
}
