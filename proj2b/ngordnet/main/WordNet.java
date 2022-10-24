package ngordnet.main;

import edu.princeton.cs.algs4.In;

import java.io.File;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class WordNet<T>{
    private Graph graph;
    private HashMap<T, T> idtoword;
    //private HashMap<T, HashMap> idtohyp;
    private List<Graph.Edge> edges;


    public WordNet(String synsets, String hyponyms) {
        idtoword = new HashMap<T, T>();
        //idtohyp = new HashMap<T, HashMap>();
        edges = new ArrayList<Graph.Edge>();

        File file1 = new File(synsets);
        In a = new In(file1);
        String s = a.readLine();

        while (a.hasNextLine()) {
            String[] sarray = s.split(",",  0);
            T hc= (T) sarray[0];
            T word= (T) sarray[1];
            idtoword.put(hc,word);

            s = a.readLine();
        }

        File file2 = new File(hyponyms);

        In a2 = new In(file1);
        String s2 = a2.readLine();
        while (a2.hasNextLine()) {
            String[] sarray2 = s.split(",",  0);






            s2 = a2.readLine();

        }

        graph = new Graph(idtohyp);

    }
}
