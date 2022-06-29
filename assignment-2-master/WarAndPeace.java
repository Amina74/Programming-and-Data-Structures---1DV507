package ah224uq_assign2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;
public class WarAndPeace {
	
    public static void main(String[] args) throws IOException{

        String text = readText("/Users/mummy/Desktop/4key/src/ah224uq_assign2/WarAndPeace");
        String[] words = text.split(" ");
        System.out.println("Initial word count: " + words.length);

        Stream<String> stream = Arrays.stream(words);

        long wordCount = stream
                .map(w -> cleanUp(w))
                .filter(w -> w.length() > 0)
                .map(w -> w.toLowerCase())
                .distinct()
                .count();
        System.out.println("Unique words: " + wordCount);

    }

    public static String cleanUp(String word){
        word = word.replaceAll("\\p{Pd}", "-");     //Change all em-dash (—) to  basic dash (-)
        word = word.replaceAll("[^A-Za-z-]", "");   //Save A-z and -
        return word;
    }

    public static String readText(String filePath) throws IOException{
        StringBuffer stringBuff = new StringBuffer();
        try{
            String line;
            FileReader in = new FileReader(filePath);
            BufferedReader bufferRead = new BufferedReader(in);
            while((line = bufferRead.readLine()) != null){
                stringBuff.append(line + " ");
            }
            bufferRead.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return stringBuff.toString();
    }


}
