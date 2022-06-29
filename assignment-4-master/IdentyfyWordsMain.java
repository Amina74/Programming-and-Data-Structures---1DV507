package ah224uq_assign4.count_word;
import java.io.*;
public class IdentyfyWordsMain {
	 /**
     * @param historyOfProgrammingFile file object for historyOfProgramming file
     * @param wordsFile file object for words file
     * */
    private static File historyOfProgrammingFile;
    private static File wordsFile;

    /**
     * Launches a call to the static method readText()
     * */
    public static void main(String[] args) {
        readText();
    }

    /**
     * The method starts by instantiating the words and historyOFProgramming file objects, it then begins
     * the file reading operation and uses the buffered reader to read each line from the history text
     * , if the line isn't null (it has not gotten to the end of the file), it passes the whole line into
     * the ripCharacters method as an array (after splitting and proper trimming), to remove all non-letter
     * character, the string returned is then appended to the words file. Appropriate error handling is pro-
     * vided. All opened connections to the reader and writer streams are also closed at the end.
     * */
    private static void readText() {
        wordsFile = new File("/Users/mummy/Desktop/4key/src/ah224uq_assign4/count_word/words.txt");
        historyOfProgrammingFile = new
                File("/Users/mummy/Desktop/4key/src/ah224uq_assign4/count_word/HistoryOfProgramming.txt");
        System.out.println("Reading ungoing....");
        try(
                FileReader reader = new FileReader(historyOfProgrammingFile);
                BufferedReader bufferedReader = new BufferedReader(reader);
                PrintWriter printWriter = new PrintWriter(wordsFile)
                ) {

            String line;
            printWriter.write("");
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.append(ripOffCharacters(line.split(" ")).trim() + "\n");
            }


        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
        }
        System.out.println("Done!");

    }

    /**
     * @param sequence an array containing the strings in the line gotten from the file.
     * It starts by constructing a StringBuilder, it then loops through each string in the array, it further
     * breaks the string into an array of characters. These characters are compared to see if they are alphabet
     * -s using ASCII set-down regulations, if they are, the character is appended to a StringBuilder, at the
     * end of the loop, the whole string is trimmed and added to the parent stringBuilder, whose string format
     * is returned to the calling method.
     * */
    private static String ripOffCharacters(String[] sequence) {
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder newString = new StringBuilder();
        for (String s: sequence) {
            for (char ch: s.toCharArray()) {
                if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                    newString.append(ch);
                }
            }
            newString.append(" ");
        }
        stringBuilder.append(newString.toString().trim() + "\n");

        return stringBuilder.toString();

    }

}
