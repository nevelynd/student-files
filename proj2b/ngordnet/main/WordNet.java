package ngordnet.main;
import edu.princeton.cs.algs4.In;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.LinkedList;
import edu.princeton.cs.algs4.Queue;
import java.util.ArrayList;



public class WordNet {
    private HashMap<String, HashSet<String>> idtoword;
    private HashMap<String, HashSet<String>>  wordtoid;

    private HashMap<String, HashSet<String>> idtoid;


    public WordNet(String synsets, String hyponyms) {

        idtoword = new HashMap<String, HashSet<String>>();
        wordtoid = new HashMap<String, HashSet<String>>();
        idtoid = new HashMap<String, HashSet<String>>();
        File file1 = new File(synsets);

        In a = new In(file1);
        while (!a.isEmpty()) {
            String s = a.readLine();
            String[] sarray = s.split(",", 0);
            String id = sarray[0];
            String words = sarray[1];

            String[] sarray3 = words.split(" ", 0);
            for (int i = 0; i < sarray3.length; i++) {
                String word = sarray3[i];


                if (idtoword.containsKey(id)) {
                    idtoword.get(id).add(word);
                } else {
                    HashSet<String> x = new HashSet<String>();
                    idtoword.put(id, x);
                    idtoword.get(id).add(word);
                }
                if (wordtoid.containsKey(word)) {
                    wordtoid.get(word).add(id);
                } else {
                    HashSet<String> x = new HashSet<String>();
                    x.add(id);
                    wordtoid.put(word, x);
                    //wordtoid.get(word).add(id);
                }
            }



        }

        File file2 = new File(hyponyms);
        In a2 = new In(file2);

        while (!a2.isEmpty()) {
            String s2 = a2.readLine();
            String[] sarray2 = s2.split(",", 0);
            String r = sarray2[0];
            for (int i = 1; i < sarray2.length; i++) {
                String word = sarray2[i];
                if (idtoid.containsKey(r)) {
                    idtoid.get(r).add(word);
                } else {
                    HashSet<String> x = new HashSet<String>();
                    idtoid.put(r, x);
                    idtoid.get(r).add(word);
                }
                //graph.addEdge(idtoword.get(r), idtoword.get(word));
            }


            //s2 = a2.readLine();

        }

    }


    public String findchildren(String word) {
        boolean[] marked = new boolean[idtoword.size()];
        Queue<String> fringe = new Queue<String>();
        HashSet<String> result = new HashSet<>();


        if (wordtoid.get(word) == null) {
            return result.toString();
        }

        if (wordtoid.get(word) != null) {
            for (String id : wordtoid.get(word)) {
                fringe.enqueue(id);
                //going through each id of the word's id


                while (!fringe.isEmpty()) {
                    String v = fringe.dequeue();
                    int intid3 = Integer.parseInt(v);
                    marked[intid3] = true;


                    for (String actualwords : idtoword.get(v)) {
                        if (!result.contains(actualwords))  {
                            result.add(actualwords);

                        }
                    }
                    //going through each id connected to current id/front fringe item
                    if (idtoid.get(v) != null) {
                        for (String w : idtoid.get(v)) {
                            int intid = Integer.parseInt(w);
                            if (!marked[intid]) {
                                fringe.enqueue(w);
                            }
                        }
                    }
                }
            }
        }
        ArrayList newresult = new ArrayList();
        for (String wordss  : result) {
            newresult.add(wordss);
        }
        Collections.sort(newresult);


        return newresult.toString();

    }



}


