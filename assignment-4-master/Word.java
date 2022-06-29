package ah224uq_assign4.count_word;

public class Word implements Comparable<Word> {

    private String word;

    public Word(String str) {
        this.word = str;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int hashCode() {
        return word.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            return hashCode() == obj.hashCode();
        }

        return false;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public int compareTo(Word o) {
        return word.toLowerCase().compareTo(o.getWord().toLowerCase());
    }

    public static void main(String[] args) {
        Word word1 = new Word("HELLO");
        Word word2 = new Word("Hello");
        Word word3 = new Word("hElLo");

        System.out.println(word1.equals(word2));
        System.out.println(word2.hashCode());
        System.out.println(word1.compareTo(new Word("Jake")));
        System.out.println(word3.hashCode());
    }


}
