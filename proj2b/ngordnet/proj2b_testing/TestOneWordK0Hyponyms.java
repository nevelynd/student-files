package ngordnet.proj2b_testing;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Tests the most basic case for Hyponyms where the list of words is one word long, and k = 0.*/
public class TestOneWordK0Hyponyms {
    // this case doesn't use the NGrams dataset at all, so the choice of files is irrelevant
    public static final String WORDS_FILE = "data/ngrams/very_short.csv";
    public static final String TOTAL_COUNTS_FILE = "data/ngrams/total_counts.csv";
    public static final String SMALL_SYNSET_FILE = "data/wordnet/synsets16.txt";
    public static final String SMALL_HYPONYM_FILE = "data/wordnet/hyponyms16.txt";

    public static final String BIG_SYNSET_FILE = "data/wordnet/synsets.txt";
    public static final String BIG_HYPONYM_FILE = "data/wordnet/hyponyms.txt";

    @Test
    public void testActK0() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("act");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[act, action, change, demotion, human_action, human_activity, variation]";




        assertEquals(expected, actual);
    }

    @Test
    public void testActK04() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, BIG_SYNSET_FILE, BIG_HYPONYM_FILE);
        List<String> words = List.of("ASCII_text_file");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[ASCII_text_file, source_code]";




        assertEquals(expected, actual);
    }



    @Test
    public void testActK05() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, BIG_SYNSET_FILE, BIG_HYPONYM_FILE);
        List<String> words = List.of("ASCII_character");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[ASCII_character, ASCII_control_character, backspace_character, control_character]";




        assertEquals(expected, actual);
    }

    @Test
    public void testActK0m5() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, BIG_SYNSET_FILE, BIG_HYPONYM_FILE);
        List<String> words = List.of("euro");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[euro]";




        assertEquals(expected, actual);
    }
    @Test
    public void testActK025() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, BIG_SYNSET_FILE, BIG_HYPONYM_FILE);
        List<String> words = List.of("wefewer");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[]";




        assertEquals(expected, actual);
    }

    @Test
    public void testActK02() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("change");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[alteration, change, demotion, increase, jump, leap, modification, saltation, transition, variation]";




        assertEquals(expected, actual);
    }

    @Test
    public void testActK03() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("occurrence");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[adjustment, alteration, change, conversion, happening, increase, jump, leap, modification, mutation, natural_event, occurrence, occurrent, saltation, transition]";




        assertEquals(expected, actual);
    }
}
