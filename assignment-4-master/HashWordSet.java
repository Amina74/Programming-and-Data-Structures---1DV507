package ah224uq_assign4.count_word;

public class HashWordSet implements WordSet {
	 private Node<Word>[] array;
	    private int size;
	    private int bucketSize;

	    public  HashWordSet(int size){
	        this.size = size;
	        array = new Node[size];
	    }

	    @Override
	    public void add(Word word) {
	        int bucketArrayIndex = hashFunc(word.hashCode());
	        Node<Word> bucket = array[bucketArrayIndex];

	        if (bucket == null)
	        {
	            array[bucketArrayIndex] = new Node<Word>(word);
	            bucketSize++;
	        }
	        else if (!contains(bucket, word))
	        {
	            Node<Word> node = bucket;
	            while (node.nextNode != null)
	                node = node.nextNode;
	            node.nextNode = new Node<Word>(word);
	            bucketSize++;
	        }

	        if (bucketSize == array.length)
	            rehash();

	    }

	    //rehash
	    private void rehash()
	    {
	        Node<Word>[] temp = array;
	        array= new Node[bucketSize * 2];
	        bucketSize = 0;

	        for (Node<Word> node : temp)
	            while (node != null)
	            {
	                if (node.data != null)
	                    add(node.data);
	                node = node.nextNode;
	            }
	    }
	    //hashfunc
	    private int hashFunc(int hash)
	    {
	        return Math.abs(hash % array.length);
	    }

	    //contains
	    private boolean contains(Node<Word> node, Word word)
	    {
	        while (node != null)
	        {
	            if (node.data != null && node.data.equals(word))
	                return true;
	            else
	                node = node.nextNode;
	        }

	        return false;
	    }

	    @Override
	    public boolean contains(Word word) {

	            return contains(getBucketHash(word.hashCode()), word);
	    }

	    private Node<Word> getBucketHash(int hash)
	    {
	        return array[hashFunc(hash)];
	    }

	    @Override
	    public String toString() {
	        String string = "[ ";

	        for (Node<Word> single : array)
	        {
	            Node<Word> n = single;
	            while (single != null)
	            {
	                string += single.data;
	                if (single.nextNode != null)
	                    string += ", ";
	                single = single.nextNode;
	            }
	            if (n != null)
	                string += ", ";
	        }

	        return string += " ]";
	    }

	    @Override
	    public int size() {
	        return bucketSize;
	    }
}
