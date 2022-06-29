package ah224uq_assign1.Ex5;
import java.util.Iterator;
/**
 * The implementation of linked queue is to store integers  using
 * top-and-down approach and Implements the <code>IntQueue</code>interface.
 * Trying to access an index which is not in the Queue size  will throw an unchecked
 * exception of the type <code>NullPointerException</code>.
 * 
 * @author Amina Hamza
 * 
 */


public class LinkedQueue implements IntQueue{
	
	
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	/**
	 *  private inner class is created to represent the Node class. 
	 * a constructor is created with intergers in its parameter
	 * 
	 */
	private class Node {

		public int data;
		public Node next;

		public Node(int element) {
			this.data = element;
		}
	}

	/**
	 * this will return the size of the Queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * this will return ture if the Queue happens to be empty
	 */
	@Override
	public boolean isEmpty() {
		if(head == null) 
		{
			return true;
		}
		else 
		{
			return false;
		}

	}
	/**
	 * Adding Integers to the end of the Queue
	 */
	@Override
	public void enqueue(int element) {

		Node node = new Node(element);

		if (tail == null)
			head = node;
		else
			tail.next = node;
		tail = node;
		size++;
	}

	/**
	 * this removes first element in Queue 
	 * 
	 * @throws NullPointerException if Queue is empty
	 */
	@Override
	public int dequeue() throws NullPointerException {
		int tip;
		if (isEmpty()) {
			throw new NullPointerException();
		} else {

			tip = head.data;
			head = head.next;
			size--;
		}
		return tip;
	}

	/**
	 * return first element in Queue
	 * 
	 * @throws NullPointerException if empty
	 */
	@Override
	public int first() throws NullPointerException { // return without removing the first element
		if (isEmpty()) {
			throw new NullPointerException();
		} else
			return head.data;
	}

	/**
	 *last elemnt in Queue is returned
	 * 
	 * @throws NullPointerException if Queue is empty
	 */
	@Override
	public int last() throws NullPointerException { // return (without removing) last element
		if (isEmpty()) {
			throw new NullPointerException();
		} else
			return tail.data;
	}

	/**
	 * Iterator iterates over all elements of the queue
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new QueueIterator();
	}

	/**
	 * private Inner classQueueIterator created with two methods, implements Iterator<T>;
	 * next() and HasNext
	 */
	private class QueueIterator implements Iterator<Integer> {

		private Node node = head;

		public Integer next() {
			int value = node.data;
			node = node.next;
			return value;
		}

		public boolean hasNext() {
			return node != null;
		}
	}

	/**
	 * expected to return a string representation of the queue content
	 */
	@Override
	public String toString() {

		Node temp = head;

		StringBuilder str = new StringBuilder();
		str.append("[ ");
		while (temp != null) {
			str.append(temp.data + " ");

			temp = temp.next;
		}

		str.append(" ]");
		return str.toString();

	}
	
	

}
