package ah224uq_assign4.count_word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class WordCount1Main {

    /**
     * @param wordHashSet the hashset holding the hashed representation of the words
     * @param wordTreeSet the treeset
     * */
    private static HashSet<Word> wordHashSet;
    private static TreeSet<Word> wordTreeSet;


    /**
     * @param args command-line arguments
     * This method instantiates the wordHashSet and wordTreeSet collections, and goes on to call the start
     * method.
     * */
    public static void main(String[] args) {
        wordHashSet = new HashSet<>();
        wordTreeSet = new TreeSet<>();

        start();
    }


    /**
     * This method creates a file object referencing the words.txt, and provides a message if the file
     * does not exist i.e IdentyfyWordsMain has not been run. else, a scanner is used to read the file
     * word after word, each word is used to construct a word object, and added to both the hashset and
     * treeset. I then go on to iterate through treeset in alphabetic order.
     * */
    public static void start() {
        File file = new File("/Users/mummy/Desktop/4key/src/ah224uq_assign4/count_word/words.txt");
        if (!file.exists()) {
            System.out.println("File words.txt does not exist, run IdentyfyWordsMain.java first.");
        } else {

            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    String w = scanner.next();
                    Word word = new Word(w);

                    wordTreeSet.add(word);
                    wordHashSet.add(word);
                }
                scanner.close();

                System.out.println("Sizes Of the Data Structures.");
                System.out.println("HashSet size: " + wordHashSet.size());
                System.out.println("TreeSet size: " + wordTreeSet.size());

                System.out.println();

                System.out.println("Iterating The Items In The TreeSet");
                Iterator<Word> wordIterator = wordTreeSet.iterator();
                while (wordIterator.hasNext()) {
                    System.out.println(wordIterator.next());
                }

            } catch (FileNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }

        }
    }


}
