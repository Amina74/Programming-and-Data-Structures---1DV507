package ah224uq_assign4.count_word;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main  {
    public static void main(String[] args) {

        Scanner scanner = null;
        HashWordSet hash = new HashWordSet(5);
        TreeWordSet tree = new TreeWordSet();
        String read = "";
        String path = "/Users/mummy/Desktop/4key/src/ah224uq_assign4/count_word/words.txt";

        try {
            File file = new File(path); // make file
            scanner = new Scanner(file); // read file
            while (scanner.hasNext()) { // while scanner has next word
                read = scanner.next(); // save it in the string
                Word word = new Word(read); // create it an instance of word
                // class
                tree.add(word); // save it
                hash.add(word);
            }
            scanner.close();

            System.out.println("HashSet size is: " + hash.size());
            System.out.println("TreeSet size is: " + tree.size() + "\n");

            System.out.println("Iterating The Items In The TreeSet");
            Iterator<Word> wordIterator = tree.iterator();
            while (wordIterator.hasNext()) {
                System.out.println(wordIterator.next());
            }

        }

        catch (FileNotFoundException e) { // catch error if file not found
            System.err.println(e.getMessage());
        }

    }

}
