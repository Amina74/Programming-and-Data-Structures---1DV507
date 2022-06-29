package ah224uq_assign4.count_word;
import java.util.Iterator;
public class TreeWordSet implements WordSet {
	private class BinaryTreeNode<T extends Comparable<T>> {
		final T element;

		BinaryTreeNode<T> parent;

		BinaryTreeNode<T> leftChild;
		BinaryTreeNode<T> rightChild;

		public BinaryTreeNode(T element)
		{
			this.element = element;
		}

		private BinaryTreeNode(BinaryTreeNode<T> parent, T element)
		{
			this(element);
			parent = parent;
		}

		public boolean add(T element)
		{
			int compareTo = this.element.compareTo(element);

			if (compareTo < 0) // this.element < element
			{
				if (rightChild == null)
				{
					rightChild = new BinaryTreeNode<T>(this, element);
					return true;
				}
				else
					return rightChild.add(element);
			}
			else if (compareTo > 0)
			{
				if (leftChild == null)
				{
					leftChild = new BinaryTreeNode<T>(this, element);
					return true;
				}
				else
					return leftChild.add(element);
			}
			return false; // the element wasn't added
		}

		public boolean search(T element)
		{
			int compareTo = this.element.compareTo(element);
			if (compareTo == 0)
				return true;
			else
			{
				if (compareTo < 0 && rightChild != null)
					return rightChild.search(element);
				if (compareTo > 0 && leftChild != null)
					return leftChild.search(element);
			}
			return false;
		}

		@Override
		public String toString()
		{
			return String.format("[ %s, l: %s, r: %s ]",
					element,
					(leftChild != null ? leftChild.element : null),
					(rightChild != null ? rightChild.element : null));
		}
	}

	private class BinaryTreeIterator<T extends Comparable<T>> implements Iterator<T>
	{
		private final BinaryTreeNode<T> root;
		private final T minValue;
		private final T maxValue;

		private BinaryTreeNode<T> currentNode;
		private T previousValue = null;

		public BinaryTreeIterator(BinaryTreeNode<T> root)
		{
			this.root = root;

			currentNode = root;
			while (currentNode.leftChild != null)
				currentNode = currentNode.leftChild;

			minValue = currentNode.element;

			// find maximum
			BinaryTreeNode<T> node = root;
			while (node.rightChild != null)
				node = node.rightChild;

			maxValue = node.element;
		}

		@Override
		public boolean hasNext() {
			return previousValue == null || maxValue.compareTo(previousValue) > 0;
		}

		@Override
		public T next() {
			if (previousValue != null)
				findNext();
			return (previousValue = currentNode.element); // assign, THEN return
		}

		private void findNext() {
			if (currentNode.rightChild != null)
			{
				currentNode = currentNode.rightChild;
				while (currentNode.leftChild != null)
					currentNode = currentNode.leftChild;
			}
			else
			{
				currentNode = currentNode.parent; // reverse
				while (currentNode.element.compareTo(previousValue) < 0)
					currentNode = currentNode.parent;
			}
		}
	}

    BinaryTreeNode<Word> root;

    int size = 0;

    public Iterator<Word> iterator() {
        return new BinaryTreeIterator<Word>(root);
    }

    @Override
    public void add(Word word) {
        if (root == null)
        {
            root = new BinaryTreeNode<Word>(word);
            size++;
        }
        else
        if (root.add(word))
            size++;
    }

    @Override
    public boolean contains(Word word) {
        return root.search(word);
    }

    @Override
    public int size() {
        return size;
    }
}
